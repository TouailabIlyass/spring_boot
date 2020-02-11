package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployeRepository;


@RestController
public class EmployeController {
	
	@Autowired EmployeRepository repo;
	
	
	@RequestMapping(path="/save",method = RequestMethod.POST)
    public Employe save(Employe e) 
    {
		if(e!=null)
		repo.save(e);
		return e;
    }
	
	@RequestMapping(path="/home")
	public String home()
	{
		return "home.html";
	}
	
	@RequestMapping(path="/")
	public List<Employe> getAll()
	{
		return repo.findAll();
	}
	
	@RequestMapping(path="/employe/{id}",method=RequestMethod.GET)
	public Optional<Employe> getOne(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@RequestMapping(path="/employe/delete/{id}",method=RequestMethod.GET)
	public void deleteEmploye(@PathVariable("id") int id)
	{
		repo.deleteById(id);
	}

}
