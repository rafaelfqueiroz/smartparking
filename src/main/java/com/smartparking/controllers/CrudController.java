package com.smartparking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smartparking.domain.Feed;
import com.smartparking.services.CrudService;

public abstract class CrudController<T extends Feed> {
	
	@Autowired
	protected CrudService<T> crudService;
	
	public Class<T> clazz;
	
	public String viewName;
	
	public CrudController(Class<T> clazz, String viewName) {
		this.clazz = clazz;
		this.viewName = viewName;
	}
	
	@GetMapping("/")
	public String form(Model model) throws InstantiationException, IllegalAccessException {
		T entity = clazz.newInstance();
		model.addAttribute(getViewName(), entity);
		return getViewPath("form");
	}
	
	@GetMapping("/{id}")
	public String edit(@PathVariable("id") Integer idEntity, Model model) {
		T entity = crudService.get(idEntity);
		System.out.println(entity.toString());
		model.addAttribute(getViewName(), entity);
		return getViewPath("form");
	}
	
	@GetMapping("/index")
	public String list(Model model) {
		model.addAttribute("entities", crudService.getAll());
		return getViewPath("index");
	}
	
	@PostMapping
	public ModelAndView save(T entity) {
		crudService.save(entity);
		return new ModelAndView("redirect:index");
	}
	
	@PutMapping
	public ModelAndView update(T entity) {
		crudService.save(entity);
		return new ModelAndView("redirect:index");
	}
	
	@DeleteMapping
	public ModelAndView remove(T entity) {
		crudService.remove(entity);
		return new ModelAndView("redirect:index");
	}

	public String getViewPath(String action) {
		return getViewName() + "/" + action;
	}
	
	public String getViewName() {
		return this.viewName;
	}
	
	
}
