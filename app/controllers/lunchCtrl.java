package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.LunchForm;
import models.LunchOrder;
import models.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.inject.Inject;

import play.data.Form;
import play.mvc.Result;

import services.LunchService;
import services.RestaurantService;

import views.html.*;

@org.springframework.stereotype.Controller
public class lunchCtrl extends play.mvc.Controller {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Inject private LunchService lunchService;

    @Inject private RestaurantService restaurantService;

    public Result index() {
        return ok(index.render(Form.form(LunchForm.class)));
    }

    public Result addOrder() {
        Form<LunchForm> lunch = Form.form(LunchForm.class).bindFromRequest();

        if (lunch.hasErrors) {
            logger.debug(String.valueOf(lunch.errors()));
            lunch.reject("Lunch order has errors");
            return badRequest(index.render(Form.form(LunchForm.class)));
        }

        LunchForm lunchForm = lunch.get();
        LunchOrder lunchOrder = new LunchOrder();

        lunchOrder.setOrder(lunchForm.getOrder());
        lunchOrder.setPerson(lunchForm.getPerson());
        lunchOrder.setRestaurant(lunchForm.getRestaurant());
        lunchOrder.setSpecialRequest(lunchForm.getSpecialRequest());

        lunchService.save(lunchOrder);

        return ok(index.render(Form.form(LunchForm.class)));
    }
}
