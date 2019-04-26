package com.company.service;

import java.util.List;

public interface OnlineOrderOps<T, S extends Dish> {

    public int getNumberOrders(List<T> orderList);

    public T getOrder(List<T> orderList, int orderIndex);

    public String getAllOrdersToString(List<T> orderList);

    public S getDish(List<S> dishList, int dishIndex);

    public String getAllDishToString(List<S> dishList);

    public List<S> getDishesByType(List<S> dishList, String dishType);

    public List<S> getDishesByFeature(List<S> dishList, String feature);

    public String getStatsByDishType(List<S> dishList, String dishType);
}