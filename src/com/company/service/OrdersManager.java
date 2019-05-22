package com.company.service;

import com.company.model.Dish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class OrdersManager implements OnlineOrderOps {

    private Scanner sc;
    private Object filePath;
    private IdentityHashMap ordersMap;

    public OrdersManager() {
    }

    public List<Order> readCSV(String fileName) throws Exception {

        String filePath = "./src/com/company/data/online-order-sample.csv";
        Scanner sc = new Scanner(new filePath(filePath));
        while (sc.hasNext()) {
        System.out.println(sc.nextLine());
        }

        while (true) {
            String[] order = sc.nextLine();
            if (order != null) {
                ≤ ordersMap;
                for (int i = 0; i < order.length; i++) {
                    ordersMap.put(categories[i], order[i]);
                }

                new Order(
                        ordersMap.get("customerName"),
                        ordersMap.get("dishName"),
                        ordersMap.get("type"),
                        Boolean.valueOf(ordersMap.get("gfd")),
                        Boolean.valueOf(ordersMap.get("vgd")),
                        Boolean.valueOf(ordersMap.get("hmd")),
                        Boolean.valueOf(ordersMap.get("sfd")),
                        ordersMap.get("extras"));

            } else {
                break;
            }
        }
        return Order.getOrders();

    }


    public void writeCSV(List<Order> orders) throws Exception {
        PrintWriter writer = new PrintWriter("online-order-sample.csv");

        writer.println("customerName,dishName,type,gfd,vgd,hmd,sfd,extras");

        for (Order order : orders) {
            writer.println(order.getCustomerName() + ","
                    + order.getDish().getDishName() + ","
                    + order.getType() + ","
                    + order.getDish().isGlutenFree() + ","
                    + order.getDish().isVegetarian() + ","
                    + order.getDish().isHalalMeat() + ","
                    + order.getDish().isSeafoodFree() + ","
                    + order.getDish().getExtras());
        }

        writer.close();

        System.out.println("Your order has been processed! :)");
    }

    public int getNumberOrders(List orderList) {
        return orderList.size();
    }

    public Object getOrder(List orderList, int orderIndex) {
        return orderList.get(orderIndex);
    }

    public String getAllOrdersToString(List orderList) {
        String result = "";
        for (Object order : orderList) {
            result += order.toString() + "\n";
        }
        return result;
    }

    public Dish getDish(List dishList, int dishIndex) {
        return (Dish) dishList.get(dishIndex);
    }

    public String getAllDishToString(List dishList) {
        String result = "";
        for (Object dish : dishList) {
            result += dish.toString() + "\n";
        }
        return result;
    }

    public List getDishesByType(List dishList, String dishType) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishList) {
            if (dish.getClass().getName().contains(dishType)) {
                result.add(dish);
            }
        }
        return result;
    }

    public List getDishesByFeature(List dishList, String feature) {
        List<Object> result = new ArrayList<Object>();
        for (Object dishInList : dishList) {
            Dish dish = (Dish) dishInList;
            if (dish.isGlutenFree() && feature.equals("gfd")) {
                result.add(dish);
            } else if (dish.isVegetarian() && feature.equals("vgd")) {
                result.add(dish);
            } else if (dish.isHalalMeat() && feature.equals("hmd")) {
                result.add(dish);
            } else if (dish.isSeafoodFree() && feature.equals("sfd")) {
                result.add(dish);
            }
        }

        return result;
    }

    public String getStatsByDishType(List dishList, String dishType) {
        List<Object> filtered = getDishesByFeature(dishList, dishType);
        float stats = ((float) filtered.size() / (float) dishList.size()) * 100;
        return stats + "% of " + dishList.size() + " meals ordered are " + dishType;
    }

    public String getStatsByCustomer(List<Order> orders, String customerName) {
        float counter = 0;
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                counter++;
            }
        }
        float stats = counter / orders.size() * 100;
        return stats + "% of " + orders.size() + " orders are made by " + customerName;
    }
}