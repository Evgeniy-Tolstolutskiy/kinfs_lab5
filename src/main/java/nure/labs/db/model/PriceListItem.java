package nure.labs.db.model;

/**
 * Created by Yevhenii_Tolstolutsk on 10/31/2016.
 */
public class PriceListItem {
    private int id;
    private int aircraftId;
    private double classAPrice;
    private double classBPrice;
    private double classCPrice;

    public PriceListItem() {
    }

    public PriceListItem(int id, int aircraftId, double classAPrice, double classBPrice, double classCPrice) {
        this.id = id;
        this.aircraftId = aircraftId;
        this.classAPrice = classAPrice;
        this.classBPrice = classBPrice;
        this.classCPrice = classCPrice;
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

    public double getClassAPrice() {
        return classAPrice;
    }

    public void setClassAPrice(double classAPrice) {
        this.classAPrice = classAPrice;
    }

    public double getClassBPrice() {
        return classBPrice;
    }

    public void setClassBPrice(double classBPrice) {
        this.classBPrice = classBPrice;
    }

    public double getClassCPrice() {
        return classCPrice;
    }

    public void setClassCPrice(double classCPrice) {
        this.classCPrice = classCPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceListItem priceListItem = (PriceListItem) o;

        if (id != priceListItem.id) return false;
        if (aircraftId != priceListItem.aircraftId) return false;
        if (Double.compare(priceListItem.classAPrice, classAPrice) != 0) return false;
        if (Double.compare(priceListItem.classBPrice, classBPrice) != 0) return false;
        return Double.compare(priceListItem.classCPrice, classCPrice) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + aircraftId;
        temp = Double.doubleToLongBits(classAPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(classBPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(classCPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
