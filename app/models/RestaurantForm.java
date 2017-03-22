package models;

import play.data.validation.Constraints.Required;

public class RestaurantForm {

    @Required(message = "Please enter the restaurant name.")
    private String restaurant;

    @Required(message = "Please set the item limit.")
    private Integer itemsLeft;

    @Required(message = "Please include the restaurant menu url.")
    private String menuUrl;

    public String getRestaurant() {
        return restaurant;
    }

    public getItemsLeft() {
        return itemsLeft;
    }

    public getMenuUrl() {
        return menuUrl;
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
