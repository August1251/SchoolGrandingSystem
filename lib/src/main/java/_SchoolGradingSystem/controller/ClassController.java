package _SchoolGradingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import _SchoolGradingSystem.entity.SchoolClassEntity;
import _SchoolGradingSystem.service.ClassService;

@Controller
public class ClassController {

	private ClassService classService;

	public ClassController(ClassService classService) {
		this.classService = classService;
	}
	
	@GetMapping("/class/add")
	public String classPageGet(Model model) {
		model.addAttribute("new_class", new SchoolClassEntity());
		
		return "class";
	}
	
	@PostMapping("/class/add")
	public String classPagePost(@ModelAttribute("new_class") SchoolClassEntity classEntity) {
		classService.saveClassEntity(classEntity);
		
		return "class";
	}
	
}