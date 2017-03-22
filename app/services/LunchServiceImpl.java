package services;

import models.LunchOrder;

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
    private static final Logger logger = LoggerFactory.getLogger(TripServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    public LunchOrder getOrderById(Integer id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return em.find(LunchOrder.class, id);
    }

    @Transactional
    public Integer save(LunchOrder order) {
        try {
            if (order == null) {
                throw new IllegalArgumentException();
            }
            Set<LunchOrder> allOrders = getAllLunchOrders();
            if (allOrders.stream().filter(orderDB -> orderDB.getPerson() == order.getPerson())) {
                throw new IllegalArgumentException("An order already exists for " + order.getPerson());
            }
            em.persist(order);
            logger.debug("Order for {} at {} made for {} and id {} saved to db.", order.getOrder(), order.getRestaurant(),
                         order.getPerson(), order.getId());
            return order.getId();
        }
        catch (Exception e) {
            return -1;
        }
    }
    @Transactional
    public Set<LunchOrder> getAllLunchOrders() {
        CriteriaQuery<LunchOrder> query = em.getCriteriaBuilder().createQuery(LunchOrder.class);
        query.from(LunchOrder.class);
        List<LunchOrder> orders = em.createQuery(query).getResultList();
        Set<LunchOrder> orderSet = new HashSet<LunchOrder>(ordres);

        return orderSet;
    }
    
}
