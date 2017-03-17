package application;

import Core.BestPathFinder;
import Core.OrderAllocator;
import Entity.*;
import javafx.util.Pair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bibek on 16/03/17.
 */
public class PathFinderApplication {

    private static PathFinderApplication application = null;

    private PathFinderConfig config;

    private PathFinderApplication(){
        this.config = new PathFinderConfig();
        this.config.setFirstMileWeight(60);
        this.config.setOrderDelayTimeWeight(90);
        this.config.setWaitTimeWeight(40);
    }

    public static PathFinderApplication getInstance(){
        if(application == null){
            application = new PathFinderApplication();
        }

        return application;
    }

    public PathFinderConfig getConfig(){
        return config;
    }

    public static void runBestPathFinderTest(){

        System.out.print("\nRunning PATH FINDER Test: \n");

        Double pt1 = 12.0;
        Double pt2 = 13.0;

        Neighbourhood neighbourhood = new Neighbourhood();
        HashMap<String, Resturant> orderMap = new HashMap<String, Resturant>();

        // Create delivery executives
        DeliveryExecutive aman = new DeliveryExecutive("Amman", 8);
        aman.updateLocation(new Pair<Double, Double>(14.9, 34.6));
        neighbourhood.addNeighbour(aman.getUniqueId(), aman);

        // Create resturants
        Resturant r1 = new Resturant("R1", pt1);
        r1.updateLocation(new Pair<Double, Double>(09.1, 37.6));
        neighbourhood.addNeighbour(r1.getUniqueId(), r1);
        Resturant r2 = new Resturant("R2", pt2);
        r2.updateLocation(new Pair<Double, Double>(13.1, 37.6));
        neighbourhood.addNeighbour(r2.getUniqueId(), r2);

        // Create Customers
        Customer c1 = new Customer("C1");
        c1.updateLocation(new Pair<Double, Double>(12.2, 38.1));
        neighbourhood.addNeighbour(c1.getUniqueId(), c1);
        Customer c2 = new Customer("C2");
        c2.updateLocation(new Pair<Double, Double>(11.2, 39.1));
        neighbourhood.addNeighbour(c2.getUniqueId(), c2);

        // Update map
        aman.addNeighbour(r1);
        aman.addNeighbour(r2);

        r1.addNeighbour(c1);
        r1.addNeighbour(r2);
        r1.addNeighbour(c2);

        r2.addNeighbour(r1);
        r2.addNeighbour(c1);
        r2.addNeighbour(c2);

        c1.addNeighbour(r1);
        c1.addNeighbour(r2);
        c1.addNeighbour(c2);

        c2.addNeighbour(r1);
        c2.addNeighbour(c1);
        c2.addNeighbour(r2);

        // Create order map
        orderMap.put(c1.getUniqueId(), r1);
        orderMap.put(c2.getUniqueId(), r2);

        BestPathFinder pathFinder = new BestPathFinder();
        DeliveryPath path = pathFinder.getShortestPath(aman, neighbourhood, orderMap);

        System.out.print("Best Path: \n");
        System.out.print(path.printPath());
    }

    public void runSampleOrderMapping(){

        System.out.print("\nRunning ORDER MAPPING Test: \n");

        // Create customers
        Customer c1 = new Customer("C1");
        c1.updateLocation(new Pair<Double, Double>(12.2, 38.1));
        Customer c2 = new Customer("C2");
        c2.updateLocation(new Pair<Double, Double>(11.2, 39.1));
        Customer c3 = new Customer("C3");
        c3.updateLocation(new Pair<Double, Double>(12.2, 39.1));
        Customer c4 = new Customer("C4");
        c4.updateLocation(new Pair<Double, Double>(11.2, 32.1));
        Customer c5 = new Customer("C5");
        c5.updateLocation(new Pair<Double, Double>(15.2, 39.1));
        Customer c6 = new Customer("C6");
        c6.updateLocation(new Pair<Double, Double>(11.2, 31.1));
        Customer c7 = new Customer("C7");
        c7.updateLocation(new Pair<Double, Double>(12.2, 32.1));
        Customer c8 = new Customer("C8");
        c8.updateLocation(new Pair<Double, Double>(21.2, 39.1));
        Customer c9 = new Customer("C9");
        c9.updateLocation(new Pair<Double, Double>(19.0, 39.1));
        Customer c10 = new Customer("C10");
        c10.updateLocation(new Pair<Double, Double>(19.1, 39.1));

        // Create Restorants
        Resturant r1 = new Resturant("R1", 20.0);
        r1.updateLocation(new Pair<Double, Double>(09.1, 37.6));
        Resturant r2 = new Resturant("R2", 21.0);
        r2.updateLocation(new Pair<Double, Double>(12.1, 37.6));
        Resturant r3 = new Resturant("R3", 23.1);
        r3.updateLocation(new Pair<Double, Double>(11.1, 37.6));
        Resturant r4 = new Resturant("R4", 23.1);
        r4.updateLocation(new Pair<Double, Double>(13.1, 32.6));
        Resturant r5 = new Resturant("R5", 23.1);
        r5.updateLocation(new Pair<Double, Double>(13.1, 33.6));
        Resturant r6 = new Resturant("R6", 23.1);
        r6.updateLocation(new Pair<Double, Double>(13.1, 34.6));
        Resturant r7 = new Resturant("R7", 23.1);
        r7.updateLocation(new Pair<Double, Double>(15.1, 37.6));
        Resturant r8 = new Resturant("R8", 23.1);
        r8.updateLocation(new Pair<Double, Double>(16.1, 36.6));
        Resturant r9 = new Resturant("R9", 23.1);
        r9.updateLocation(new Pair<Double, Double>(17.1, 32.6));
        Resturant r10 = new Resturant("R10", 23.1);
        r10.updateLocation(new Pair<Double, Double>(11.1, 34.6));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy/hh:mm:ss");
        List<Order> orderList = new ArrayList<Order>();
        List<DeliveryExecutive> deList = new ArrayList<DeliveryExecutive>();

        // Create orders
        try {
            Order o1 = new Order(c1, r1, dateFormat.parse("16/03/2017/13:01:23"));
            orderList.add(o1);
            Order o2 = new Order(c2, r2, dateFormat.parse("16/03/2017/13:02:23"));
            orderList.add(o2);
            Order o3 = new Order(c3, r3, dateFormat.parse("16/03/2017/13:04:23"));
            orderList.add(o3);
            Order o4 = new Order(c4, r4, dateFormat.parse("16/03/2017/13:01:23"));
            orderList.add(o4);
            Order o5 = new Order(c5, r5, dateFormat.parse("16/03/2017/13:02:23"));
            orderList.add(o5);
            Order o6 = new Order(c6, r6, dateFormat.parse("16/03/2017/13:11:23"));
            orderList.add(o6);
            Order o7 = new Order(c7, r7, dateFormat.parse("16/03/2017/13:10:23"));
            orderList.add(o7);
            Order o8 = new Order(c8, r8, dateFormat.parse("16/03/2017/13:12:23"));
            orderList.add(o8);
            Order o9 = new Order(c9, r9, dateFormat.parse("16/03/2017/13:22:23"));
            orderList.add(o9);
            Order o10 = new Order(c10, r10, dateFormat.parse("16/03/2017/13:07:23"));
            orderList.add(o10);

            // Create DE
            DeliveryExecutive de1 = new DeliveryExecutive("DE1", 8);
            de1.updateLocation(new Pair<Double, Double>(14.9, 34.6));
            de1.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:55:23"));
            deList.add(de1);
            DeliveryExecutive de2 = new DeliveryExecutive("DE2", 8);
            de2.updateLocation(new Pair<Double, Double>(12.9, 34.6));
            de2.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:55:23"));
            deList.add(de2);
            DeliveryExecutive de3 = new DeliveryExecutive("DE3", 8);
            de3.updateLocation(new Pair<Double, Double>(14.9, 32.6));
            de3.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:55:23"));
            deList.add(de3);
            DeliveryExecutive de4 = new DeliveryExecutive("DE4", 8);
            de4.updateLocation(new Pair<Double, Double>(14.9, 31.6));
            de4.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:50:23"));
            deList.add(de4);
            DeliveryExecutive de5 = new DeliveryExecutive("DE5", 8);
            de5.updateLocation(new Pair<Double, Double>(11.9, 32.6));
            de5.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:45:23"));
            deList.add(de5);
            DeliveryExecutive de6 = new DeliveryExecutive("DE6", 8);
            de6.updateLocation(new Pair<Double, Double>(16.9, 34.6));
            de6.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:59:23"));
            deList.add(de6);
            DeliveryExecutive de7 = new DeliveryExecutive("DE7", 8);
            de7.updateLocation(new Pair<Double, Double>(13.9, 33.6));
            de7.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:55:23"));
            deList.add(de7);
            DeliveryExecutive de8 = new DeliveryExecutive("DE8", 8);
            de8.updateLocation(new Pair<Double, Double>(15.9, 34.6));
            de8.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:53:23"));
            deList.add(de8);

            DeliveryExecutive de9 = new DeliveryExecutive("DE9", 8);
            de9.updateLocation(new Pair<Double, Double>(13.9, 34.6));
            de9.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:59:23"));
            deList.add(de9);
            DeliveryExecutive de10 = new DeliveryExecutive("DE10", 8);
            de10.updateLocation(new Pair<Double, Double>(11.9, 34.6));
            de10.setLastDeliveryTime(dateFormat.parse("16/03/2017/12:51:23"));
            deList.add(de10);

        }catch (ParseException e){
            System.out.print(e.getMessage());
        }

        // create the pairs
        OrderAllocator orderAllocator = new OrderAllocator();

        List<OrderFulfilment> output = orderAllocator.getFulfilementPair(orderList, deList);

        for(OrderFulfilment fulfiledOrder : output){
            System.out.print(fulfiledOrder.print() + "\n");
        }
    }
}
