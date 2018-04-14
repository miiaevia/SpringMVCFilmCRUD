package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.database.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor accessor;

	public DatabaseAccessor getAccessor() {
		return accessor;
	}

	public void setAccessor(DatabaseAccessor accessor) {
		this.accessor = accessor;
	}
	
	@RequestMapping(path="GetFilmInfo.do", params="id", method = RequestMethod.GET)
	public ModelAndView getFilmByID(int id) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = new ArrayList<Film>();
		filmList.add(accessor.getFilmById(id));
		mv.addObject(filmList);
		mv.setViewName("display");
		return mv;
	}
}
