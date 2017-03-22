package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.LunchForm;
import models.LunchOrder;

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

//public class Application extends Controller {
//
//    public static Result index() {
//        return ok(index.render("hello, world", play.data.Form.form(models.LunchOrder.class)));
//    }
//    public static Result addLunchOrder() {
//        play.data.Form<models.LunchOrder> form = play.data.Form.form(models.LunchOrder.class).bindFromRequest();
//        if (form.hasErrors()) {
//            return badRequest(index.render("hello, world", form));
//        }
//        else {
//            models.LunchOrder order = form.get();
//            order.save();
//            return redirect(routes.Application.index());
//        }
//    }
//    public static Result getLunchOrders() {
//        java.util.List<models.LunchOrder> orders = new play.db.ebean.Model.Finder(String.class, models.LunchOrder.class).all();
//        return ok(play.libs.Json.toJson(orders));
//    }
//
//}
}
