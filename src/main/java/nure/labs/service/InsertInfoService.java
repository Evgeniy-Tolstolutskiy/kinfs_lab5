package nure.labs.service;

/**
 * Created by Евгений on 02.11.2016.
 */
public interface InsertInfoService {
    boolean insertPriceListItem(int aircraftId, double classAPrice, double classBPrice,
                                double classCPrice);

    boolean insertAircraft(String model);

    boolean insertBooking(int scheduleId, int seatNumber, double cost);

    boolean insertPilot(String name, int age, int aircraftId);

    boolean insertRoute(String from, String to);

    boolean insertScheduleItem(int aircraftId, int routeId, long date);
}
