package in.athenaeum.springbootrestwebservice.service;

import in.athenaeum.springbootrestwebservice.viewmodel.BookViewModel;

import java.util.List;

public interface IBookService {
    List<BookViewModel> getAll();
    BookViewModel getById(int id);
    void create(BookViewModel viewModel);
    void update(BookViewModel viewModel);
    void delete(int id);
}
