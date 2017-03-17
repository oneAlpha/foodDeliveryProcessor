package Entity;

import Core.PathFinderConstants;

import java.util.Date;

/**
 * Created by bibek on 11/03/17.
 */
public class DeliveryExecutive extends GeoNode{
    static Integer globalIdCount = 0;

    private Integer id;

    private String name;

    // In mt/sec
    private Integer averageSpeed;

    private Date lastDeliveryTime;

    public DeliveryExecutive(String name, Integer averageSpeed){
        super(name, PathFinderConstants.DELIVERY_EXICUTIVE_ENTITY);
        this.name = name;
        this.averageSpeed = averageSpeed;
        globalIdCount++;
        id = globalIdCount;
        this.state = DEState.DE_FREE;
    }

    public String getName(){
        return name;
    }

    public String getUniqueId(){
        return this.getClass().getSimpleName() + id;
    }

    public enum DEState{
        DE_FREE, DE_BUSY
    }

    private DEState state;

    public Integer getAverageSpeed(){
        return this.averageSpeed;
    }

    public void setLastDeliveryTime(Date lastDeliveryTime){
        this.lastDeliveryTime = lastDeliveryTime;
    }

    public Date getLastDeliveryTime(){
        return this.lastDeliveryTime;
    }

    public DEState getState(){
        return state;
    }

    public void setState(DEState state){
        this.state = state;
    }
}
