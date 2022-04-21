package oslomet.webprog.ukeoppgaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;
import oslomet.webprog.ukeoppgaver.repository.VehicleRepository;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository repo;

    @PostMapping("/api/add")
    public void add(Registration registration){
        repo.addRegistrations(registration);
    }

    @PostMapping("api/changeOneRegistration")
    public void changeOneRegistration(Registration registration) {
        repo.changeOneRegistration(registration);
    }

    @GetMapping("/api/registrations")
    public List<Registration> getAllRegistrations(){
        return repo.getRegistrations();
    }

    @GetMapping("/api/cars")
    public List<Car> getAllCars(){
        return repo.getCars();
    }

    @GetMapping("/api/getOneRegistration")
    public Registration getOneRegistration(String id){
        return repo.getOneRegistration(id);
    }

    @GetMapping("/api/deleteSingleRegistration")
    public void deleteSingleRegistration(String id) {
        repo.deleteSingleRegistration(id);
    }

    @DeleteMapping("/api")
    public void deleteAll(){
        repo.deleteVehicles();
    }
}
