package nure.labs.db.jdbc;

import nure.labs.db.model.Booking;

import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface BookingDao {
    List<Booking> selectBookings();

    boolean insertBooking(Booking booking);

    boolean updateBooking(int oldId, Booking booking);

    boolean deleteBooking(int id);
}
