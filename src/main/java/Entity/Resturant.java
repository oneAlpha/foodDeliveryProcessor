package Entity;

import Core.PathFinderConstants;
import javafx.util.Pair;

/**
 * Created by bibek on 11/03/17.
 */
public class Resturant extends GeoNode {

    static Integer globalIdCount = 0;

    private Integer id;

    private String name;

    private Double averagePrepTime;

    public Resturant(String name, Double averagePrepTime){
        super(name, PathFinderConstants.RESTAURANT_ENTITY);
        this.name = name;
        globalIdCount++;
        id = globalIdCount;
        this.averagePrepTime = averagePrepTime;
    }

    public String getName(){
        return name;
    }

    public String getUniqueId(){
        return this.getClass().getSimpleName() + id;
    }

    public Double getAveragePrepTime(){
        return averagePrepTime;
    }
}
