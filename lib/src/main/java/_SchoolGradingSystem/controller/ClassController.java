package _SchoolGradingSystem.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import _SchoolGradingSystem.dto.ClassDto;
import _SchoolGradingSystem.entity.BookEntity;
import _SchoolGradingSystem.entity.SchoolClassEntity;
import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.service.BookService;
import _SchoolGradingSystem.service.ClassService;

@Controller
public class ClassController {

	private static final ClassDto classDto = new ClassDto();
	private static final Set<UserEntity> students = new HashSet<>();
	private static final Set<BookEntity> books = new HashSet<>();
	private static final Logger log = Logger.getGlobal();
	
	private ClassService classService;
	private BookService bookService;

	public ClassController(
			ClassService classService,
			BookService bookService) {
		this.classService = classService;
		this.bookService = bookService;
	}
	
	@GetMapping("/class/create")
	public String classPageGet(Model model) {
		
		model.addAttribute("new_class", classDto);
		
		model.addAttribute("search_student", new ClassDto());
		
		model.addAttribute("search_book", new ClassDto());
		
		model.addAttribute("students", ClassController.students);
		
		model.addAttribute("books", ClassController.books);
		
		return "class";
	}
	
	@PostMapping("/class/create")
	public String classPagePost(@ModelAttribute("new_class") ClassDto classDto) {
		SchoolClassEntity classEntity = new SchoolClassEntity(classDto.getStudentClass());
		
		classEntity.setBooks(books);
		classEntity.setStudents(students);
		
		classService.saveClassEntity(classEntity);
		
		return "class";
	}
	
	@GetMapping("/class/add/student/{studentId}")
	public String classStudentPageGet(
			@PathVariable("studentId") long id,
			@ModelAttribute("search_student") ClassDto classDto,
			Model model) {
		UserEntity student = classService.findStudentById(classDto.getStudentId());
		
		ClassController.students.add(student);
		
		classDto.getStudents().add(student);
		
		model.addAttribute("students", ClassController.students);
		
		log.info("students: " + ClassController.students);
		
		return "redirect:/class/create";
	}
	
	@GetMapping("/class/add/book/{bookId}")
	public String classBookPageGet(
			@PathVariable("bookId") long id,
			@ModelAttribute("search_book") ClassDto classDto,
			Model model) {
		BookEntity book = classService.findBookById(classDto.getBookId());
		
		ClassController.books.add(book);
		
		classDto.getBooks().add(book);
		
		model.addAttribute("books", ClassController.books);
		
		return "redirect:/class/create";
	}
	
}