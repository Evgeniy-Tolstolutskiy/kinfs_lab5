package nure.labs.service.impl;

import nure.labs.db.model.Booking;
import nure.labs.db.model.PriceListItem;
import nure.labs.service.BookingService;
import nure.labs.service.pojo.PrettyScheduleItem;
import org.springframework.stereotype.Service;

/**
 * Created by Yevhenii_Tolstolutsk on 11/1/2016.
 */
@Service
public class BookingServiceImpl extends ApplicationService implements BookingService {

    public boolean bookTicket(PrettyScheduleItem scheduleItem, String seatClass, int seatNumber) {
        String pilotName = scheduleItem.getPilotList().split(",")[1];
        int aircraftId = aircraftDao.selectAircraftByNameAndPilot(scheduleItem.getAircraftName(), pilotName).getId();
        int routeId = routeDao.selectRouteByFromAndTo(scheduleItem.getFrom(), scheduleItem.getTo()).getId();
        PriceListItem priceListItem = priceListDao.selectPriceListByAircraftId(aircraftId);
        int scheduleId = scheduleDao.selectScheduleByAircraftIdAndRouteId(aircraftId, routeId).getId();
        double cost = 0;
        if (seatClass.equals("classA")) {
            cost = priceListItem.getClassAPrice();
        } else if (seatClass.equals("classB")) {
            cost = priceListItem.getClassBPrice();
        } else if (seatClass.equals("classC")) {
            cost = priceListItem.getClassCPrice();
        }
        if (bookingDao.insertBooking(new Booking(0, scheduleId, seatNumber, cost))) {
            return true;
        }
        return false;
    }
}
