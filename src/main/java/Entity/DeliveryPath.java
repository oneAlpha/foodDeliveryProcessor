package Entity;

import Core.HaversineDistance;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bibek on 11/03/17.
 */
public class DeliveryPath {
    public ArrayList<GeoNode> pathList;

    public Double timeTaken;

    public Integer averageSpeed = 1;

    public Double getTimeTakenToReachNextNode(GeoNode node){
        GeoNode lastNode = pathList.get(pathList.size() - 1);
        return (HaversineDistance.getDistance(lastNode.getLocation(), node.getLocation())/averageSpeed);
    }

    public DeliveryPath(){
        pathList = new ArrayList<GeoNode>();
    }

    public DeliveryPath(DeliveryPath path){
        pathList = new ArrayList<GeoNode>();
        this.timeTaken = path.timeTaken;

        for(GeoNode node: path.pathList)
            this.pathList.add(node);
    }

    public boolean hasNode(GeoNode node){
        if(pathList.indexOf(node) == -1){
            return false;
        }

        return true;
    }

    public boolean addNode(GeoNode node){
        if(pathList.size() == 0){
            pathList.add(node);
            timeTaken = 0.0;
            return true;
        }

        timeTaken += getTimeTakenToReachNextNode(node);
        pathList.add(node);

        return true;
    }

    public String printPath(){
        String pathString = "";

        for(GeoNode node : pathList){
            pathString += node.getLabel() + " --> ";
        }

        pathString += timeTaken.toString();

        return pathString;
    }
}
