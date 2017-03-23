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

    public Integer getItemsLeft() {
        return itemsLeft;
    }

    public String getMenuUrl() {
        return menuUrl;
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
