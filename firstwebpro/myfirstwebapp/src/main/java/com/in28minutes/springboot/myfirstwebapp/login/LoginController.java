package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			
			// Authentication
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid credentials");
		return "login";
		
	}
		
	
		// private Logger logger = LoggerFactory.getLogger(getClass());
	
		// view - jsp -> login.jsp
		// http://localhost:8080/login?name=john
		// Model
//		@RequestMapping("login")
//		public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//			model.put("name", name);
//			logger.debug("Request param is-------------- {}", name);
//			logger.info("Request param is-------------- {}", name);
//			//System.out.println("Request param is " + name); // not recommended for production code
//			return "login";
//		}
		
		

}
