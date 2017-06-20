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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static nure.labs.constants.Constants.*;

/**
 * Created by Евгений on 03.11.2016.
 */
@Controller(value = "adminScheduleController")
@RequestMapping(value = "/admin")
public class ScheduleController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/schedule")
    public ModelAndView getSchedule() {
        ModelAndView model = new ModelAndView("admin/schedule");
        model.addObject("schedule", getInfoService.getSimpleSchedule());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedule/insert")
    public String addScheduleItem(@RequestParam int aircraftId, @RequestParam int routeId, @RequestParam String date) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        if (insertInfoService.insertScheduleItem(aircraftId, routeId, df.parse(date).getTime())) {
            return ADMIN_SCHEDULE;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedule/delete")
    public String deleteScheduleItem(@RequestParam int id) {
        if (deleteInfoService.deleteScheduleItem(id)) {
            return ADMIN_SCHEDULE;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedule/update")
    public String updateScheduleItem(@RequestParam int oldId, @RequestParam int newId,
                                             @RequestParam int aircraftId, @RequestParam int routeId, @RequestParam String date) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        if (updateInfoService.updateScheduleItem(oldId, newId, aircraftId, routeId, df.parse(date).getTime())) {
            return ADMIN_SCHEDULE;
        }
        return ERROR;
    }
}
