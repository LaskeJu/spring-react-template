package laskeju.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

	@GetMapping("/api/users")
	List<User> list() {
		List<User> users = new ArrayList<User>();
		users.add(User.create("Max", "Mustermann"));
		users.add(User.create("Karl", "Mustermann"));
		return users;
	}

}
