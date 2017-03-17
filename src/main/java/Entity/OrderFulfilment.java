package Entity;

import Core.HaversineDistance;
import application.PathFinderApplication;

import java.util.Date;

/**
 * Created by bibek on 16/03/17.
 */
public class OrderFulfilment implements Comparable<OrderFulfilment>{

    private Order order;

    private DeliveryExecutive deliveryExecutive;

    private Integer orderWeight;

    public OrderFulfilment(Order order, DeliveryExecutive deliveryExecutive){
        this.order = order;
        this.deliveryExecutive = deliveryExecutive;
        this.orderWeight = calculateOrderWeight();
    }

    private Integer calculateOrderWeight(){

        Date currentTime = new Date();

        Double firstMile = (HaversineDistance.getDistance(order.getResturant().getLocation(),
                deliveryExecutive.getLocation()))/deliveryExecutive.getAverageSpeed()
                * PathFinderApplication.getInstance().getConfig().getFirstMileWeight();

        Double deWaitTime = (double)((currentTime.getTime() - deliveryExecutive.getLastDeliveryTime().getTime())/1000)
                * PathFinderApplication.getInstance().getConfig().getWaitTimeWeight();

        Double orderDelayTime = (double)((currentTime.getTime() - order.getOrderTime().getTime())/1000)
                * PathFinderApplication.getInstance().getConfig().getOrderDelayTimeWeight();

        return (firstMile.intValue() + deWaitTime.intValue() + orderDelayTime.intValue());
    }

    public Integer getOrderWeight(){
        return this.orderWeight;
    }

    public Order getOrder(){
        return order;
    }

    public DeliveryExecutive getDeliveryExecutive(){
        return deliveryExecutive;
    }

    public String print(){
        return ("ORDER: " + order.getUniqueId() + " -> DE: " + deliveryExecutive.getUniqueId());
    }

    public int compareTo(OrderFulfilment o){
        return (this.orderWeight - o.getOrderWeight());
    }
}
