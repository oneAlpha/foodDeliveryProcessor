package Entity;

import Core.PathFinderConstants;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by bibek on 11/03/17.
 */
public class GeoNode{

    private String label;

    private Pair<Double, Double> location;

    private ArrayList<GeoNode> adjacencyList;

    private String type;

    GeoNode(String label, String type){
        this.label = label;
        adjacencyList = new ArrayList<GeoNode>();
        this.type = type;
    }

    public void updateLocation(Pair<Double, Double> loc){
        this.location = loc;
        return;
    }

    public Pair<Double, Double> getLocation(){
        return location;
    }

    public void addNeighbour(GeoNode node){
        if(adjacencyList.indexOf(node) == -1) {
            adjacencyList.add(node);
        }
    }

    public ArrayList<GeoNode> getNeighbours(){
        return adjacencyList;
    }

    public String getType(){return type;}

    public String getLabel(){
        return label;
    }
}
