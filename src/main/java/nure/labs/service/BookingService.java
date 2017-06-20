package nure.labs.service;

import nure.labs.service.pojo.PrettyScheduleItem;

/**
 * Created by Евгений on 02.11.2016.
 */
public interface BookingService {
    boolean bookTicket(PrettyScheduleItem scheduleItem, String seatClass, int seatNumber);
}
