package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.DAO.CarDAO;


@Controller
public class CarController {

    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "/cars")
    public String getAllCars(Model model) {
        model.addAttribute("carListFromDao", carDAO.getCarList());
        return "cars";
    }

    @GetMapping(value = "cars/count={count}")
    public String getCarById(@PathVariable(name = "count") int id, Model model) {
        if (id >= 5) {
            return "redirect:/cars";
        }
        model.addAttribute("carObjById", carDAO.getCarById(id));
        return "showCar";
    }

}
