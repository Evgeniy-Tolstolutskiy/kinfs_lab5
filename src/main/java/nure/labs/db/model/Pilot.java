package nure.labs.db.model;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class Pilot {
    private int id;
    private String name;
    private int age;
    private int aircraftId;

    public Pilot() {
    }

    public Pilot(int id, String name, int age, int aircraftId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.aircraftId = aircraftId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pilot pilot = (Pilot) o;

        if (id != pilot.id) return false;
        if (age != pilot.age) return false;
        if (aircraftId != pilot.aircraftId) return false;
        return name != null ? name.equals(pilot.name) : pilot.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + aircraftId;
        return result;
    }
}
