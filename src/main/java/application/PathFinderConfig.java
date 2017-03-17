package application;

/**
 * Created by bibek on 16/03/17.
 */
public class PathFinderConfig {

    private Integer firstMileWeight;

    private Integer waitTimeWeight;

    private Integer orderDelayTimeWeight;

    public PathFinderConfig(){
        firstMileWeight = 100;
        waitTimeWeight = 100;
        orderDelayTimeWeight = 100;
    }

    public void setFirstMileWeight(Integer firstMileWeight){
        this.firstMileWeight = firstMileWeight;
    }

    public Integer getFirstMileWeight(){
        return this.firstMileWeight;
    }

    public void setWaitTimeWeight(Integer waitTimeWeight){
        this.waitTimeWeight = waitTimeWeight;
    }

    public Integer getWaitTimeWeight(){
        return this.waitTimeWeight;
    }

    public void setOrderDelayTimeWeight(Integer orderDelayTimeWeight){
        this.orderDelayTimeWeight = orderDelayTimeWeight;
    }

    public Integer getOrderDelayTimeWeight(){
        return this.orderDelayTimeWeight;
    }
}
