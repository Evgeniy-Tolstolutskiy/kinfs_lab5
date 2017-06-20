package nure.labs.controller;

import nure.labs.service.impl.GetInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
@Controller(value = "userScheduleController")
public class ScheduleController {
    @Autowired
    private GetInfoServiceImpl getInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView getSchedule() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("schedule", getInfoService.getSchedule());
        model.addObject("oldestPilots", getInfoService.getOldestPilotsForAllModels());
        return model;
    }
}
