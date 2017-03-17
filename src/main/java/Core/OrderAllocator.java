package Core;

import Entity.DeliveryExecutive;
import Entity.Order;
import Entity.OrderFulfilment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by bibek on 16/03/17.
 */
public class OrderAllocator {

    private Queue<OrderFulfilment> getShortedOrderDEPair(List<Order> orderList,
                                                         List<DeliveryExecutive> dEList){

        Queue<OrderFulfilment> retVal = new PriorityQueue<OrderFulfilment>();

        for(Order order : orderList){
            for(DeliveryExecutive de : dEList){
                retVal.add(new OrderFulfilment(order, de));
            }
        }

        return retVal;
    }

    public List<OrderFulfilment> getFulfilementPair(List<Order> orderList,
                                                    List<DeliveryExecutive> dEList){

        List<OrderFulfilment> finalList = new ArrayList();

        Queue<OrderFulfilment> orderedPairs = getShortedOrderDEPair(orderList, dEList);


        for(OrderFulfilment orderItem : orderedPairs){
            if((orderItem.getOrder().getState() == Order.OrderState.ORDER_INITIATED)
                && (orderItem.getDeliveryExecutive().getState() == DeliveryExecutive.DEState.DE_FREE)){
                finalList.add(orderItem);
                orderItem.getOrder().setState(Order.OrderState.ORDER_ALLOCATED);
                orderItem.getDeliveryExecutive().setState(DeliveryExecutive.DEState.DE_BUSY);
            }

            if(finalList.size() >= orderList.size()){
                break;
            }
        }

        return finalList;
    }
}
