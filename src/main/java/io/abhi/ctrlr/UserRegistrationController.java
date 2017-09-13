package io.abhi.ctrlr;

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
import io.abhi.data.utils.Utility;

@RestController
public class UserRegistrationController {

	private static final String URL_CROSS = "*";

	@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return Utility.fetch();
	}

	@CrossOrigin(origins=URL_CROSS)
	@PostMapping("/user")
	public CustomResponse saveUserData(@RequestBody User newUser) {
		String message = "";
		if(Utility.isUserExist(newUser)){
			message = "User name already exists";
		}else{
			Utility.saveOrUpdate(newUser);
			message = "Successfully Registered";
		}
		return new CustomResponse(message);
	}

	@CrossOrigin(origins=URL_CROSS)
	@DeleteMapping("/user/{username}")
	public CustomResponse deleteUserData(@PathVariable String username) {
		String message = "";
		User user = new User();
		user.setUsername(username);
		if(Utility.isUserExist(user)){
			Utility.delete(username);
			message = "Successfully deleted";
		}else{			
			message = "User name does not exists";
		}
		return new CustomResponse(message);
		
	}

	@CrossOrigin(origins=URL_CROSS)
	@PutMapping("/user")
	public CustomResponse updateUserData(@RequestBody User user) {
		String message = "";
		if(Utility.isUserExist(user)){
			Utility.saveOrUpdate(user);
			message = "Successfully updated";
		}else{
			message = "User name does not exists";
		}
		return new CustomResponse(message);
	}
	
	@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/userTest")
	public CustomResponse getTest() {
		return new CustomResponse("Success");
	}
}