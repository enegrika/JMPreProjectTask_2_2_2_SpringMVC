package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private int id;
    private String carModel;
    private int year;

    public Car() {
    }

    public Car(int id, String carModel, int year) {
        this.id = id;
        this.carModel = carModel;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", year=" + year +
                '}';
    }
}
