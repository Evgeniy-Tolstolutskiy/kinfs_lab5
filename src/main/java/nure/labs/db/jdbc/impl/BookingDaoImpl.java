package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.BookingDao;
import nure.labs.db.model.Booking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class BookingDaoImpl extends JdbcDao implements BookingDao {
    @Override
    public List<Booking> selectBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "select * from Bookings";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            int scheduleId = ((java.math.BigDecimal) row.get("scheduleId")).intValue();
            int seatNumber = ((java.math.BigDecimal) row.get("seatNumber")).intValue();
            double cost = (double) row.get("cost");
            bookings.add(new Booking(id, scheduleId, seatNumber, cost));
        }
        return bookings;
    }

    @Override
    public boolean insertBooking(Booking booking) {
        String sql = "call insert_booking(?, ?, ?)";
        jdbcTemplate.update(sql, booking.getScheduleId(), booking.getSeatNumber(), booking.getCost());
        return true;
    }

    @Override
    public boolean updateBooking(int oldId, Booking booking) {
        String sql = "update Bookings set id=?, scheduleId=?, seatNumber=?, cost=? where id=?";
        jdbcTemplate.update(sql, booking.getId(), booking.getScheduleId(), booking.getSeatNumber(), booking.getCost(), oldId);
        return true;
    }

    @Override
    public boolean deleteBooking(int id) {
        String sql = "delete from Bookings where id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
