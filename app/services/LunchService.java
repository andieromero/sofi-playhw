package services;

import models.LunchOrder;

import java.util.Set;

public interface LunchService {
    LunchOrder getOrderById(Integer id);

    Integer save(LunchOrder order);

    Set<LunchOrder> getAllLunchOrders();
}
