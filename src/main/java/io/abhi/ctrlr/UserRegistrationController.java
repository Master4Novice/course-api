package io.abhi.ctrlr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.abhi.data.CustomResponse;
import io.abhi.data.User;

@RestController
public class UserRegistrationController {

	private static final String URL_CROSS = "*";

	@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return Arrays.asList(new User("abhi", "userabhi", "userpss", "abhi@test.com", 2323454),
				new User("ihba", "abhiuser", "pssuser", "test@abhi.com", 2323478));
	}

	@CrossOrigin(origins=URL_CROSS)
	@PostMapping("/user")
	public CustomResponse saveUserData(@RequestBody User newUser) {
		System.out.println("---------------------------------");
		System.out.println("New user name:" + newUser.getName());
		System.out.println("New user username:" + newUser.getUsername());
		System.out.println("New user password:" + newUser.getPassword());
		System.out.println("New user email:" + newUser.getEmailId());
		System.out.println("New user contact:" + newUser.getContactNumber());
		System.out.println("---------------------------------");
		return new CustomResponse("Successfully Registered");
	}

	@CrossOrigin(origins=URL_CROSS)
	@DeleteMapping("/user/{username}")
	public CustomResponse deleteUserData(@PathVariable String username) {
		System.out.println("---------------------------------");
		System.out.println("Deleted :" + username);
		System.out.println("---------------------------------");
		return new CustomResponse("Successfully deleted");
	}

	@CrossOrigin(origins=URL_CROSS)
	@PutMapping("/user")
	public CustomResponse updateUserData(@RequestBody User user) {
		System.out.println("---------------------------------");
		System.out.println("Updated user name:" + user.getName());
		System.out.println("Updated user username:" + user.getUsername());
		System.out.println("Updated user password:" + user.getPassword());
		System.out.println("Updated user email:" + user.getEmailId());
		System.out.println("Updated user contact:" + user.getContactNumber());
		System.out.println("---------------------------------");
		return new CustomResponse("Successfully updated");
	}
	
	@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/test")
	public CustomResponse getTest() {
		return new CustomResponse("Success");
	}
}