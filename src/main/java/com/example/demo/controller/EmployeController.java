package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployeRepository;


@Controller
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
	public String getAll()
	{
		return "home.html";
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
	
	@RequestMapping(path="/admin/index",method=RequestMethod.GET)
	public String index_Admin()
	{
		return "index_admin.jsp";
	}
	@RequestMapping(path="/user/index",method=RequestMethod.GET)
	public String index_User()
	{
		return "index.jsp";
	}

}
