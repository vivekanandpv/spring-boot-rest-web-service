package in.athenaeum.springbootrestwebservice.service;

import in.athenaeum.springbootrestwebservice.exception.RecordNotFoundException;
import in.athenaeum.springbootrestwebservice.model.Book;
import in.athenaeum.springbootrestwebservice.repository.BookRepository;
import in.athenaeum.springbootrestwebservice.viewmodel.BookViewModel;
import in.athenaeum.springbootrestwebservice.viewmodel.PublisherViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookViewModel> getAll() {
        return repository.findAll()
                .stream()
                .map(b -> {
                    BookViewModel viewModel = new BookViewModel();
                    BeanUtils.copyProperties(b, viewModel);
                    PublisherViewModel publisherViewModel = new PublisherViewModel();
                    BeanUtils.copyProperties(b.getPublisher(), publisherViewModel);
                    viewModel.setPublisher(publisherViewModel);
                    return viewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BookViewModel getById(int id) {
        Book bookDb = getBookEntity(id);
        BookViewModel viewModel = new BookViewModel();
        BeanUtils.copyProperties(bookDb, viewModel);
        return viewModel;
    }

    @Override
    public void create(BookViewModel viewModel) {
        //  Validate
        //  Throw DomainValidationException if validation fails

        //  If all is well, then
        Book newBook = new Book();
        BeanUtils.copyProperties(viewModel, newBook);
        repository.saveAndFlush(newBook);
    }

    @Override
    public void update(BookViewModel viewModel) {
        Book bookDb = getBookEntity(viewModel.getId());
        //  Validate
        //  Throw DomainValidationException if validation fails

        //  If all is well, then
        BeanUtils.copyProperties(viewModel, bookDb);
        repository.saveAndFlush(bookDb);
    }

    @Override
    public void delete(int id) {
        Book bookDb = getBookEntity(id);
        repository.delete(bookDb);
    }

    private Book getBookEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException());
    }
}
