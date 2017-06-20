package nure.labs.controller.admin;

import nure.labs.service.DeleteInfoService;
import nure.labs.service.GetInfoService;
import nure.labs.service.InsertInfoService;
import nure.labs.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static nure.labs.constants.Constants.*;

/**
 * Created by Евгений on 03.11.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class RouteController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/routes")
    public ModelAndView getRoutes() {
        ModelAndView model = new ModelAndView("admin/routes");
        model.addObject("routes", getInfoService.getRoutes());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/routes/insert")
    public String addRoute(@RequestParam String from, @RequestParam String to) {
        if (insertInfoService.insertRoute(from, to)) {
            return ADMIN_ROUTES;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/routes/delete")
    public String deleteRoute(@RequestParam int id) {
        if (deleteInfoService.deleteRoute(id)) {
            return ADMIN_ROUTES;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/routes/update")
    public String updateRoute(@RequestParam int oldId, @RequestParam int newId,
                                      @RequestParam String from, @RequestParam String to) {
        if (updateInfoService.updateRoute(oldId, newId, from, to)) {
            return ADMIN_ROUTES;
        }
        return ERROR;
    }
}
