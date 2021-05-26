package in.athenaeum.springbootrestwebservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {

    @GetMapping
    public String greet() {
        return "Good morning!";
    }

    @GetMapping("/{id}")
    public String getCounter(@PathVariable int id) {
        return "Counter = " + id;
    }

    @PostMapping
    public String post() {
        return "Success: POST";
    }

    @PutMapping
    public String update() {
        return "Success: PUT";
    }

    @PatchMapping
    public String patch() {
        return "Success: PATCH";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return "Delete success: " + id;
    }
}
