package Core;

import Entity.*;
import com.sun.tools.internal.xjc.reader.gbind.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bibek on 11/03/17.
 */
public class BestPathFinder {

    List<DeliveryPath> paths;

    Neighbourhood neighbourhood;

    HashMap<String, Resturant> orderMap;

    public DeliveryPath getShortestPath(GeoNode begining, Neighbourhood neighbourhood, HashMap<String, Resturant> orderMap){

        this.neighbourhood = neighbourhood;
        this.orderMap = orderMap;
        paths = new ArrayList<DeliveryPath>();

        DeliveryPath startPath = new DeliveryPath();

        startPath.addNode(begining);

        getPath(startPath, begining);

        Double shortestTime = Double.MAX_VALUE;
        DeliveryPath shortestPath = null;

        for(DeliveryPath path: paths){
            System.out.print(path.printPath() + "\n");
            if(path.timeTaken < shortestTime){
                shortestPath = path;
                shortestTime = path.timeTaken;
            }
        }

        return shortestPath;
    }

    private boolean isOrderFullfiled(DeliveryPath path, Customer customer){
        return path.pathList.indexOf(orderMap.get(customer.getUniqueId())) != -1;
    }

    public DeliveryPath getPath(DeliveryPath path, GeoNode start){

        if(path.pathList.size() >= neighbourhood.getSize()){
            paths.add(path);
            return path;
        }

        for(GeoNode node : start.getNeighbours()){

            if(node.getType().equals(PathFinderConstants.CUSTOMER_ENTITY)){
                if(!isOrderFullfiled(path, (Customer)node))
                {
                    continue;
                }
            }
            if(node.getType().equals(PathFinderConstants.RESTAURANT_ENTITY)){
                // TODO:: Add the logic when already delivered to all other customer
                // then irrespective of this get the order fulfilled.
                if(path.getTimeTakenToReachNextNode(node) < ((Resturant)node).getAveragePrepTime()){
                    continue;
                }
            }
            if(!path.hasNode(node)) {
                DeliveryPath localPath = new DeliveryPath(path);
                localPath.addNode(node);
                getPath(localPath, node);
            }
        }

        return path;
    }
}
