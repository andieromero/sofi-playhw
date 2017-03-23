package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "restaurant", nullable = false)
    private String restaurant;

    @Column(name = "items_left", nullable = false)
    private Integer itemsLeft;

    @Column(name = "menu_url", nullable = false)
    private String menuUrl;

    public Integer getId() {
        return id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public Integer getItemsLeft() {
        return itemsLeft;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setItemsLeft(Integer itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}

