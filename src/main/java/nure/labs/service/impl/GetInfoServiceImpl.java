package nure.labs.service.impl;

import nure.labs.db.model.*;
import nure.labs.service.GetInfoService;
import nure.labs.service.pojo.PrettyScheduleItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
@Service
public class GetInfoServiceImpl extends ApplicationService implements GetInfoService {

    public List<PrettyScheduleItem> getSchedule() {
        return scheduleDao.selectPrettySchedule();
    }

    public List<PriceListItem> getPriceList() {
        return priceListDao.selectPriceList();
    }

    public List<Aircraft> getAircrafts() {
        return aircraftDao.selectAircrafts();
    }

    public List<Booking> getBookings() {
        return bookingDao.selectBookings();
    }

    public List<Pilot> getPilots() {
        return pilotDao.selectPilots();
    }

    public List<Route> getRoutes() {
        return routeDao.selectRoutes();
    }

    public List<ScheduleItem> getSimpleSchedule() {
        return scheduleDao.selectSchedule();
    }

    @Override
    public Map<String, Pilot> getOldestPilotsForAllModels() {
        List<Aircraft> aircrafts = getAircrafts();
        Map<String, Pilot> oldestPilots = new HashMap<>();
        for (Aircraft aircraft : aircrafts) {
            Pilot pilot = pilotDao.selectOldestPilotForModel(aircraft.getName());
            if (pilot != null) {
                oldestPilots.put(aircraft.getName(), pilot);
            }
        }
        return oldestPilots;
    }
}
