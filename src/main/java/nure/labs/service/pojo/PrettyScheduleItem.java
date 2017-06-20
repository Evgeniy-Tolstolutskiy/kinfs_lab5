package nure.labs.service.pojo;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class PrettyScheduleItem {
    private String aircraftName;
    private String pilotList;
    private String from;
    private String to;
    private long date;

    public PrettyScheduleItem() {
    }

    public PrettyScheduleItem(String aircraftName, String pilotList, String from, String to, long date) {
        this.aircraftName = aircraftName;
        this.pilotList = pilotList;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public String getPilotList() {
        return pilotList;
    }

    public void setPilotList(String pilotList) {
        this.pilotList = pilotList;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

        PrettyScheduleItem that = (PrettyScheduleItem) o;

        if (date != that.date) return false;
        if (aircraftName != null ? !aircraftName.equals(that.aircraftName) : that.aircraftName != null) return false;
        if (pilotList != null ? !pilotList.equals(that.pilotList) : that.pilotList != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;

    }

    @Override
    public int hashCode() {
        int result = aircraftName != null ? aircraftName.hashCode() : 0;
        result = 31 * result + (pilotList != null ? pilotList.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (int) (date ^ (date >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PrettyScheduleItem{" +
                "aircraftName='" + aircraftName + '\'' +
                ", pilotList='" + pilotList + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
}
