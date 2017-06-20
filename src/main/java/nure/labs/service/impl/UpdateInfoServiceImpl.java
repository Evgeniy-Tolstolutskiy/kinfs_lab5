package nure.labs.service.impl;

import nure.labs.db.model.*;
import nure.labs.service.UpdateInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by Yevhenii_Tolstolutsk on 11/3/2016.
 */
@Service
public class UpdateInfoServiceImpl extends ApplicationService implements UpdateInfoService {

    public boolean updatePriceListItem(int oldId, int newId, int aircraftId, double classAPrice, double classBPrice, double classCPrice) {
        return priceListDao.updatePriceListItem(oldId, new PriceListItem(newId, aircraftId, classAPrice, classBPrice, classCPrice));
    }

    public boolean updateAircraft(int oldId, int newId, String model) {
        return aircraftDao.updateAircraft(oldId, new Aircraft(newId, model));
    }

    public boolean updateBooking(int oldId, int newId, int scheduleId, int seatNumber, double cost) {
        return bookingDao.updateBooking(oldId, new Booking(newId, scheduleId, seatNumber, cost));
    }

    public boolean updatePilot(int oldId, int newId, String name, int age, int aircraftId) {
        return pilotDao.updatePilot(oldId, new Pilot(newId, name, age, aircraftId));
    }

    public boolean updateRoute(int oldId, int newId, String from, String to) {
        return routeDao.updateRoute(oldId, new Route(newId, from, to));
    }

    public boolean updateScheduleItem(int oldId, int newId, int aircraftId, int routeId, long date) {
        return scheduleDao.updateScheduleItem(oldId, new ScheduleItem(newId, aircraftId, routeId, date));
    }
}
