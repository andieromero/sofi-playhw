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

    public getId() {
        return id;
    }

    public getRestaurant() {
        return restaurant;
    }

    public getItemsLeft() {
        return itemsLeft;
    }

    public getMenuUrl() {
        return menuUrl;
    }

    public setId(Integer id) {
        this.id = id;
    }

    public setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public setItemsLeft(Integer itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}

