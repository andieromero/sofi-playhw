package services;

import models.LunchOrder;

import views.html.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.spec.ECField;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Service
public class LunchServiceImpl implements LunchService {
    private static final Logger logger = LoggerFactory.getLogger(LunchServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    public LunchOrder getOrderById(Integer id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return em.find(LunchOrder.class, id);
    }

    @Transactional(noRollbackFor = Exception.class)
    public Integer save(LunchOrder order) {
        try {
            if (order == null) {
                throw new IllegalArgumentException();
            }
            List<LunchOrder> allOrders = getAllLunchOrders();
//            if (allOrders.stream().filter((orderDB -> orderDB.getPerson() == order.getPerson())) != 0) {
//                throw new IllegalArgumentException("An order already exists for " + order.getPerson());
//            }
            em.persist(order);
            logger.debug("Order for {} with special request {} at {} made for {} saved to db.", order.getOrder(),
                         order.getSpecialRequest(), order.getRestaurant(), order.getPerson());
            return order.getId();
        }
        catch (Exception e) {
            return -1;
        }
    }
    @Transactional
    public List<LunchOrder> getAllLunchOrders() {
        List<LunchOrder> lunchList = em.createQuery("SELECT l FROM LunchOrder l", LunchOrder.class).getResultList();
        lunchList.sort((LunchOrder lunch1, LunchOrder lunch2) -> lunch1.getPerson().compareTo(lunch2.getPerson())) ;
        return lunchList;
    }
    
    @Transactional
    public void clearAllLunchOrders() {
        em.createQuery("DELETE FROM LunchOrder").executeUpdate();
    }
}
