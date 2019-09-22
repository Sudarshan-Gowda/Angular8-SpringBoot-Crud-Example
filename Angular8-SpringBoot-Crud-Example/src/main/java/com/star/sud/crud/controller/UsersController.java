/**
 * 
 */
package com.star.sud.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.sud.crud.dao.UserDao;
import com.star.sud.crud.model.TUser;

/**
 * @author Sudarshan
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsersController {

	// Attributes
	///////////////////
	@Autowired
	private UserDao userDao;

	/**
	 * @return
	 */
	@GetMapping("/users")
	public List<TUser> getAllUsers() {
		return userDao.findAll();
	}

	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/users/{userId}")
	public ResponseEntity<TUser> getUserById(@PathVariable(value = "userId") Long userId) throws Exception {
		TUser user = userDao.findById(userId).orElseThrow(() -> new Exception("user not found for id - " + userId));
		return ResponseEntity.ok().body(user);
	}

	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public TUser createUsers(@Valid @RequestBody TUser user) {
		return userDao.save(user);

	}

	/**
	 * @param userId
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/users/{userId}")
	public ResponseEntity<TUser> updateUsers(@PathVariable(value = "userId") Long userId, @Valid @RequestBody TUser user)
			throws Exception {

		TUser entity = userDao.findById(userId).orElseThrow(() -> new Exception("No Record Found"));

		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setEmailId(user.getEmailId());
		entity.setPlace(user.getPlace());
		TUser updatedUser = userDao.save(entity);
		return ResponseEntity.ok(updatedUser);
	}

	/**
	 * @param id
	 */
	@DeleteMapping("/users/{userId}")
	public void deleteEmployee(@PathVariable("userId") Long id) {
		userDao.deleteById(id);
	}

}
