package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "lunch_order")
public class LunchOrder{

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "order", nullable = false)
    private String order;

    @Column(name = "person", nullable = false)
    private String person;

    @Column(name = "restaurant", nullable = false)
    private String restaurant;

    @Column(name = "special_request")
    private String specialRequest;

    public Integer getId() {
        return id;
    }

    public String getOrder() {
        return order;
    }

    public String getPerson() {
        return person;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}

