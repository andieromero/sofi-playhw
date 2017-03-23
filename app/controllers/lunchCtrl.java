package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.LunchForm;
import models.LunchOrder;
import models.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import play.data.Form;
import play.mvc.Result;

import services.LunchService;
//import services.RestaurantService;

import views.html.*;
import java.util.List;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Controller
public class lunchCtrl extends play.mvc.Controller {
    private static final Logger logger = LoggerFactory.getLogger(lunchCtrl.class);

    @Inject private LunchService lunchService;

    public Result index() {
        List<LunchOrder> orderSet = lunchService.getAllLunchOrders();
        return ok(index.render(Form.form(LunchForm.class), orderSet));
    }

    public Result addOrder() {
        Form<LunchForm> lunch = Form.form(LunchForm.class).bindFromRequest();
        List<LunchOrder> orderSet = lunchService.getAllLunchOrders();
        if (lunch.hasErrors()) {
            System.out.println(String.valueOf(lunch.errors()));
            lunch.reject("Lunch order has errors");
            return badRequest(index.render(Form.form(LunchForm.class), orderSet));
        }

        LunchForm lunchForm = lunch.get();
        LunchOrder lunchOrder = new LunchOrder();

        lunchOrder.setOrder(lunchForm.getOrder());
        lunchOrder.setPerson(lunchForm.getPerson());
        lunchOrder.setRestaurant(lunchForm.getRestaurant());
        lunchOrder.setSpecialRequest(lunchForm.getSpecialRequest());

        lunchService.save(lunchOrder);
        orderSet = lunchService.getAllLunchOrders();
        return ok(index.render(Form.form(LunchForm.class), orderSet));
    }
    public Result getOrders() {
        List<LunchOrder> orderSet = lunchService.getAllLunchOrders();
        return ok(play.libs.Json.toJson(orderSet));
    }
    public Result clearOrders() {
        lunchService.clearAllLunchOrders();
        List<LunchOrder> orderSet = lunchService.getAllLunchOrders();
        return ok(index.render(Form.form(LunchForm.class), orderSet));
    }
}
