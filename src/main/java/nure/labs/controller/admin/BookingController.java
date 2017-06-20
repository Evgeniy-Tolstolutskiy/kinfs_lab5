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
@Controller(value = "adminBookingController")
@RequestMapping(value = "/admin")
public class BookingController {
    @Autowired
    private GetInfoService getInfoService;
    @Autowired
    private InsertInfoService insertInfoService;
    @Autowired
    private DeleteInfoService deleteInfoService;
    @Autowired
    private UpdateInfoService updateInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/bookings")
    public ModelAndView getBookings() {
        ModelAndView model = new ModelAndView("admin/bookings");
        model.addObject("bookings", getInfoService.getBookings());
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookings/insert")
    public String addBooking(@RequestParam int scheduleId, @RequestParam int seatNumber,
                             @RequestParam double cost) {
        if (insertInfoService.insertBooking(scheduleId, seatNumber, cost)) {
            return ADMIN_BOOKINGS;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookings/delete")
    public String deleteBooking(@RequestParam int id) {
        if (deleteInfoService.deleteBooking(id)) {
            return ADMIN_BOOKINGS;
        }
        return ERROR;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookings/update")
    public String updateBooking(@RequestParam int oldId, @RequestParam int newId,
                                @RequestParam int scheduleId, @RequestParam int seatNumber,
                                @RequestParam double cost) {
        if (updateInfoService.updateBooking(oldId, newId, scheduleId, seatNumber, cost)) {
            return ADMIN_BOOKINGS;
        }
        return ERROR;
    }
}
