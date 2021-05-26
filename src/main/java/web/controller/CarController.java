package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAO;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {

//    private final CarDAO carDAO;
//
//    @Autowired
//    public CarController(CarDAO carDAO) {
//        this.carDAO = carDAO;
//    }

    private List<Car> carListInner = new ArrayList<>();

    {
        Car c1 = new Car(1, "localЖигули", 1978);
        Car c2 = new Car(2, "localGolf", 23);
        Car c3 = new Car(3, "localMitsu", 234234);
        Car c4 = new Car(4, "localVAZ", 4566);
        Car c5 = new Car(5, "localJeep", 2235);

        carListInner.add(c1);
        carListInner.add(c2);
        carListInner.add(c3);
        carListInner.add(c4);
        carListInner.add(c5);
    }

    @GetMapping(value = "/cars")
    public String getAllCars(@RequestParam(required = false, name = "count") Integer id,
                             Model model) {
        model.addAttribute("carListFromController", carListInner);
        model.addAttribute("carObjById", carListInner.get(id - 1));

//        model.addAttribute("carListFromDao", carDAO.getCarList());
        if (id > 0 && id < 5) {
            return "showCar";
        } else
            return "cars";
    }

//    @GetMapping(value = "/cars")
//    public String getCarById(@RequestParam(name = "count") int id, Model model) {
//        if (id < 5) {
//            model.addAttribute("carObjById", carListInner.get(id));
//
////        model.addAttribute("carObjById", carDAO.getCarById(id));
//            return "showCar";
//
//        }
//        return "redirect:/cars";
//    }

}
