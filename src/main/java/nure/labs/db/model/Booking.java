package nure.labs.db.model;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class Booking {
    private int id;
    private int scheduleId;
    private int seatNumber;
    private double cost;

    public Booking() {
    }

    public Booking(int id, int scheduleId, int seatNumber, double cost) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.seatNumber = seatNumber;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (scheduleId != booking.scheduleId) return false;
        if (seatNumber != booking.seatNumber) return false;
        return Double.compare(booking.cost, cost) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + scheduleId;
        result = 31 * result + seatNumber;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
