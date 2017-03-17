package Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bibek on 11/03/17.
 */
public class Neighbourhood {
    HashMap<String, GeoNode> graph;

    public Neighbourhood(){
        this.graph = new HashMap<String, GeoNode>();
    }

    public Integer getSize(){
        return graph.size();
    }

    public void addNeighbour(String id, GeoNode node){
        graph.put(id, node);
    }
}