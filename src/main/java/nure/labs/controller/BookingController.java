package nure.labs.controller;

import nure.labs.service.BookingService;
import nure.labs.service.pojo.PrettyScheduleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Yevhenii_Tolstolutsk on 11/1/2016.
 */
@Controller(value = "userBookingController")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(method = RequestMethod.POST, value = "/bookTicket")
    public String bookTicket(@RequestParam(value = "aircraftName") String aircraftName,
                             @RequestParam(value = "pilotList") String pilotList,
                             @RequestParam(value = "from") String from,
                             @RequestParam(value = "to") String to,
                             @RequestParam(value = "date") String date,
                             @RequestParam String seatClass, @RequestParam int seatNumber) {
        if (bookingService.bookTicket(new PrettyScheduleItem(aircraftName, pilotList,
                from, to, Long.valueOf(date)), seatClass, seatNumber)) {
            return "successfulBooking";
        }
        return "error";
    }
}
