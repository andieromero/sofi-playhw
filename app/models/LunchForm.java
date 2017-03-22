package models;

import play.data.validation.Constraints.Required;

public class LunchForm {

    @Required(message = "Please place an order.")
    private String order;

    @Required(message = "Please include your name.")
    private String person;

    @Required(message = "Please include the restaurant name.")
    private String restaurant;

    private String specialRequest;

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

    public void setOrder(String order){
        this.order = order;
    }
    
    public void setName(String person) {
        this.person = person;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}
