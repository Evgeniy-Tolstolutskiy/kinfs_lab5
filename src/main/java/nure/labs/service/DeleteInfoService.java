package nure.labs.service;

/**
 * Created by Евгений on 02.11.2016.
 */
public interface DeleteInfoService {
    boolean deletePriceListItem(int id);

    boolean deleteAircraft(int id);

    boolean deleteBooking(int id);

    boolean deletePilot(int id);

    boolean deleteRoute(int id);

    boolean deleteScheduleItem(int id);
}
