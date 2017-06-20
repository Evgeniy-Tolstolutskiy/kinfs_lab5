package nure.labs.service.impl;

import nure.labs.service.DeleteInfoService;
import org.springframework.stereotype.Component;

/**
 * Created by Евгений on 02.11.2016.
 */
@Component
public class DeleteInfoServiceImpl extends ApplicationService implements DeleteInfoService {

    public boolean deletePriceListItem(int id) {
        return priceListDao.deletePriceListItem(id);
    }

    public boolean deleteAircraft(int id) {
        return aircraftDao.deleteAircraft(id);
    }

    public boolean deleteBooking(int id) {
        return bookingDao.deleteBooking(id);
    }

    public boolean deletePilot(int id) {
        return pilotDao.deletePilot(id);
    }

    public boolean deleteRoute(int id) {
        return routeDao.deleteRoute(id);
    }

    public boolean deleteScheduleItem(int id) {
        return scheduleDao.deleteScheduleItem(id);
    }
}
