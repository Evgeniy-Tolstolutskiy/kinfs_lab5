package nure.labs.controller;

import nure.labs.service.pojo.PrettyScheduleItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

/**
 * Created by Евгений on 02.11.2016.
 */
@Controller
public class PassengerInfoController {
    @RequestMapping(method = RequestMethod.GET, value = "/passengerInfo")
    @ResponseBody
    public ModelAndView passInfo(@RequestParam(value = "aircraftName") String aircraftName,
                                 @RequestParam(value = "pilotList") String pilotList,
                                 @RequestParam(value = "from") String from,
                                 @RequestParam(value = "to") String to,
                                 @RequestParam(value = "date") String date,
                                 @RequestParam(value = "seatClass") String seatClass) throws ParseException {
        ModelAndView model = new ModelAndView("passengerInfo");
        model.addObject("scheduleItem", new PrettyScheduleItem(aircraftName, pilotList,
                from, to, Long.valueOf(date)));
        model.addObject("seatClass", seatClass);
        return model;
    }
}
