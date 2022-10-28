package it.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.project.dao.UserDao;
import it.project.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao dao;
	
	@GetMapping
	public String user_home() {
		return "Home page User!";
	}
	
	@GetMapping("/all")
	public List<User> getAll(){
		return dao.findAll();
	}
	
	@PostMapping
	public void create(@RequestBody User u) {
		dao.persist(u);
	}
	
	@DeleteMapping
	public void delete(@RequestBody User u) {
		dao.remove(u);
	}
	
	@PutMapping
	public void update(@RequestBody User u) {
		dao.merge(u);
	}
}
