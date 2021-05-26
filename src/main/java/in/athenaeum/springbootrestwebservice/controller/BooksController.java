package in.athenaeum.springbootrestwebservice.controller;

import in.athenaeum.springbootrestwebservice.service.IBookService;
import in.athenaeum.springbootrestwebservice.viewmodel.BookViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {
    private final IBookService service;

    public BooksController(IBookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookViewModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(BookViewModel viewModel) {
        service.create(viewModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> update(BookViewModel viewModel) {
        service.update(viewModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
