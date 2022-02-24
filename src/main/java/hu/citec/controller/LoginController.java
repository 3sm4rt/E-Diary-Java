package hu.citec.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.entity.Subject;
import hu.citec.entity.User;
import hu.citec.entity.UserRole;
import hu.citec.service.UserService;

@Controller
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserService userservice;

	@Autowired
	public LoginController(UserService userservice) {

		this.userservice = userservice;
	}

	@GetMapping("/connect")
	public String connect() {
		return "View/Connect";
	}

	@GetMapping("/deleteUser/{username}")
	public String deleteUser(@PathVariable(name = "username") String username) {
		userservice.deleteUser(username);
		System.out.println(username);
		return "redirect:/adminHome/";

		// Sajnos az update meg a delete későn jutott eszembe ezért csak idáig tudtam
		// eljutni vele
	}

	@GetMapping("/blockUser/{username}")
	public String blockUser(@PathVariable(name = "username") String username) {
		userservice.blockUser(username);
		System.out.println(username);
		return "redirect:/adminHome/";
	}

	@RequestMapping({ "/login", "/" })
	public String login() {
		return "View/login";
	}

	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "View/registration";
	}

	@PostMapping("/reg")
	public String reg(@ModelAttribute(value = "user") User user) {
		log.info("Uj user!");
		log.debug(user.getUsername());
		log.debug(user.getEmail());
		log.debug(user.getFullname());
		log.debug(user.getPassword());

		userservice.registrateUser(user);

		return "View/login";
	}

	@GetMapping("/userHome")
	public String userHome(Model model) {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();

		User findUser = userservice.findUser(aut.getName());
		List<Subject> findSubject = userservice.findSubject();

		model.addAttribute("Subjects", findSubject);
		model.addAttribute("Users", findUser);

		return "View/userHome";

	}

	@GetMapping("/showGrade/{subjectName}/{username}")
	public String UserGrade(@PathVariable(name = "subjectName") String subjectName,
			@PathVariable(name = "username") String username, Model model) {

		model.addAttribute("grades", userservice.grade(subjectName, username));
		return "view/gradeShow";
	}

	@GetMapping("/teacherHome")
	public String teacherHome(Model model) {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();

		User findUser = userservice.findUser(aut.getName());
		List<UserRole> findAllDiak = userservice.findAllDiak();
		model.addAttribute("Users", findUser);
		model.addAttribute("UserRole", findAllDiak);

		return "view/teacherHome";

	}

	@GetMapping("/show/{username}")
	public String ShowUser(@PathVariable(name = "username") String username, Model model) {
		System.out.println(username);
		model.addAttribute("username", userservice.findUser(username));
		return "redirect:/userHome";
	}

	@RequestMapping("/adminHome")
	public String adminHome(Model model) {
		List<UserRole> adminShow = userservice.adminShow();
		model.addAttribute("AdminShow", adminShow);
		return "view/adminHome";
	}

}
