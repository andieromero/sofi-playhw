package services;

import models.LunchOrder;

import java.util.List;

public interface LunchService {
    LunchOrder getOrderById(Integer id);

    Integer save(LunchOrder order);

    List<LunchOrder> getAllLunchOrders();

    void clearAllLunchOrders();
}
