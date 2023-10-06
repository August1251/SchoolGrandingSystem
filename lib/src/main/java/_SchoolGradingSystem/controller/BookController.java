package _SchoolGradingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import _SchoolGradingSystem.dto.BookDto;
import _SchoolGradingSystem.entity.BookEntity;
import _SchoolGradingSystem.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/book/create")
	public String bookPageGet(Model model) {
		model.addAttribute("book", new BookDto());
		
		return "book";
	}
	
	@PostMapping("/book/create")
	public String studentPagePost(@ModelAttribute("book") BookDto bookDto) {
		BookEntity bookEntity = new BookEntity(bookDto.getName());
		
		bookService.saveBookEntity(bookEntity);
		
		return "book";
	}
	
}