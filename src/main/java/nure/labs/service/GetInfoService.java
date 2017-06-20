package nure.labs.service;

import nure.labs.db.model.*;
import nure.labs.service.pojo.PrettyScheduleItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 02.11.2016.
 */
public interface GetInfoService {
    List<PrettyScheduleItem> getSchedule();

    List<PriceListItem> getPriceList();

    List<Aircraft> getAircrafts();

    List<Booking> getBookings();

    List<Pilot> getPilots();

    List<Route> getRoutes();

    List<ScheduleItem> getSimpleSchedule();

    Map<String, Pilot> getOldestPilotsForAllModels();
}
