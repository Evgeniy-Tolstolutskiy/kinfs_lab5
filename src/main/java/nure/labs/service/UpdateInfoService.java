package nure.labs.service;

/**
 * Created by Yevhenii_Tolstolutsk on 11/3/2016.
 */
public interface UpdateInfoService {
    boolean updatePriceListItem(int oldId, int newId, int aircraftId, double classAPrice, double classBPrice,
                                double classCPrice);

    boolean updateAircraft(int oldId, int newId, String model);

    boolean updateBooking(int oldId, int newId, int scheduleId, int seatNumber, double cost);

    boolean updatePilot(int oldId, int newId, String name, int age, int aircraftId);

    boolean updateRoute(int oldId, int newId, String from, String to);

    boolean updateScheduleItem(int oldId, int newId, int aircraftId, int routeId, long date);
}
