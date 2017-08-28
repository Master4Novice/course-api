package io.abhi.ctrlr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
		
		@RequestMapping("/hi")
		public String sayHello() {
			return "Hello !!";
		}
}
