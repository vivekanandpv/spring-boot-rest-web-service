package in.athenaeum.springbootrestwebservice.controller;

import in.athenaeum.springbootrestwebservice.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {

    @GetMapping
    public List<Person> get() {
        return List.of(
                new Person("Vinayak", "Patil", "KE345"),
                new Person("Rajeev", "Armugam", "HJ7866"),
                new Person("Dheeraj", "K", "LK876"),
                new Person("Ramya", "L", "IU1457")
        );
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable int id) {
        return new Person("Vinayak", "Patil", "KE345");
    }

    @PostMapping
    public String post(@RequestBody Person person) {
        return "Success: POST " + person.getEmployeeCode();
    }

    @PutMapping
    public String update(@RequestBody Person person) {
        return "Success: PUT " + person.getFirstName();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return "Delete success: " + id;
    }
}
