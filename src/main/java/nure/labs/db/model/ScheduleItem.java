package nure.labs.db.model;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class ScheduleItem {
    private int id;
    private int aircraftId;
    private int routeId;
    private long date;

    public ScheduleItem() {
    }

    public ScheduleItem(int id, int aircraftId, int routeId, long date) {
        this.id = id;
        this.aircraftId = aircraftId;
        this.routeId = routeId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleItem that = (ScheduleItem) o;

        if (id != that.id) return false;
        if (aircraftId != that.aircraftId) return false;
        if (routeId != that.routeId) return false;
        return date == that.date;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + aircraftId;
        result = 31 * result + routeId;
        result = 31 * result + (int) (date ^ (date >>> 32));
        return result;
    }
}
