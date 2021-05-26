package in.athenaeum.springbootrestwebservice.controller;

import in.athenaeum.springbootrestwebservice.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        return ResponseEntity.ok(List.of(
                new Person("Vinayak", "Patil", "KE345"),
                new Person("Rajeev", "Armugam", "HJ7866"),
                new Person("Dheeraj", "K", "LK876"),
                new Person("Ramya", "L", "IU1457")
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        if (id % 2 != 0) {
            return ResponseEntity.ok(new Person("Vinayak", "Patil", "KE345"));
            // return new ResponseEntity<>(new Person("Vinayak", "Patil", "KE345"), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Person person) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Person person) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}
