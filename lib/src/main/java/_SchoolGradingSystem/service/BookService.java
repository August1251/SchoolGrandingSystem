package _SchoolGradingSystem.service;

import org.springframework.stereotype.Service;

import _SchoolGradingSystem.entity.BookEntity;
import _SchoolGradingSystem.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public BookEntity saveBookEntity(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}
	
}