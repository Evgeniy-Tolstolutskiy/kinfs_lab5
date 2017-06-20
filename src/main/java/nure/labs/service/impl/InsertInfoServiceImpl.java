package nure.labs.service.impl;

import nure.labs.db.model.*;
import nure.labs.service.InsertInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by Евгений on 02.11.2016.
 */
@Service
public class InsertInfoServiceImpl extends ApplicationService implements InsertInfoService {

    public boolean insertPriceListItem(int aircraftId, double classAPrice, double classBPrice,
                                       double classCPrice) {
        return priceListDao.insertPriceListItem(new PriceListItem(0, aircraftId, classAPrice, classBPrice, classCPrice));
    }

    public boolean insertAircraft(String model) {
        return aircraftDao.insertAircraft(new Aircraft(0, model));
    }

    public boolean insertBooking(int scheduleId, int seatNumber, double cost) {
        return bookingDao.insertBooking(new Booking(0, scheduleId, seatNumber, cost));
    }

    public boolean insertPilot(String name, int age, int aircraftId) {
        return pilotDao.insertPilot(new Pilot(0, name, age, aircraftId));
    }

    public boolean insertRoute(String from, String to) {
        return routeDao.insertRoute(new Route(0, from, to));
    }

    public boolean insertScheduleItem(int aircraftId, int routeId, long date) {
        return scheduleDao.insertScheduleItem(new ScheduleItem(0, aircraftId, routeId, date));
    }
}
