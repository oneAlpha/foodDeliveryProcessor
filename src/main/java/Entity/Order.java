package Entity;

import java.util.Date;

/**
 * Created by bibek on 16/03/17.
 */
public class Order {

    static Integer globalIdCount = 0;

    private Integer id;

    private Customer customer;

    private Resturant resturant;

    private Date orderTime;

    public enum OrderState{
        ORDER_INITIATED, ORDER_ALLOCATED, ORDER_PICKED, ORDER_DELIVERED
    }

    private OrderState state;

    public Order(Customer customer, Resturant resturant, Date orderTime){
        this.customer = customer;
        this.resturant = resturant;
        globalIdCount++;
        id = globalIdCount;
        state = OrderState.ORDER_INITIATED;
        this.orderTime = orderTime;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Resturant getResturant(){
        return this.resturant;
    }

    public Date getOrderTime(){
        return this.orderTime;
    }

    public OrderState getState(){
        return state;
    }

    public void setState(OrderState state){
        this.state = state;
    }

    public String getUniqueId(){
        return this.getClass().getSimpleName() + id;
    }
}
