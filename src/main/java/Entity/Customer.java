package Entity;

import Core.PathFinderConstants;
import javafx.util.Pair;

/**
 * Created by bibek on 11/03/17.
 */
public class Customer extends GeoNode {

    static Integer globalIdCount = 0;

    private Integer id;

    private String name;

    public Customer(String name){
        super(name, PathFinderConstants.CUSTOMER_ENTITY);
        this.name = name;
        globalIdCount++;
        id = globalIdCount;
    }

    public String getName(){
        return name;
    }

    public String getUniqueId(){
        return this.getClass().getSimpleName() + id;
    }
}
