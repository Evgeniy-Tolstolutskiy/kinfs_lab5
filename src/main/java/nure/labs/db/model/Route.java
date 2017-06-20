package nure.labs.db.model;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class Route {
    private int id;
    private String from;
    private String to;

    public Route() {
    }

    public Route(int id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (!from.equals(route.from)) return false;
        return to.equals(route.to);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
