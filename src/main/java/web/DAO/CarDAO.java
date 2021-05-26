package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAO {

    private static int ID_COUNTER;

    private List<Car> carList;

    {
        carList = new ArrayList<>();

        Car c1 = new Car(++ID_COUNTER, "Жигули", 1978);
        Car c2 = new Car(++ID_COUNTER, "Golf", 23);
        Car c3 = new Car(++ID_COUNTER, "Mitsu", 234234);
        Car c4 = new Car(++ID_COUNTER, "VAZ", 4566);
        Car c5 = new Car(++ID_COUNTER, "Jeep", 2235);

        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);
        carList.add(c5);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getCarById(int id) {
        return carList.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }


}
