package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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

	@RequestMapping(path = "GetFilmInfo.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmByID(int id) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = new ArrayList<Film>();
		Film idFilm = accessor.getFilmById(id);
		if (idFilm != null) {
			filmList.add(accessor.getFilmById(id));
			mv.addObject(filmList);
		}
		mv.setViewName("display");
		return mv;
	}

	@RequestMapping(path = "GetFilmInfo.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = accessor.getFilmByKeyword(keyword);
		if (filmList != null) {
			mv.addObject(filmList);
		}
		mv.setViewName("display");
		return mv;
	}

	@RequestMapping(path = "addInfo.do", method = RequestMethod.POST)
	public ModelAndView addFilm(@Valid Film createdFilm, Errors errors, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
			List<Film> filmList = new ArrayList<Film>();
			createdFilm.setLanguage(accessor.getFilmsLanguage(createdFilm.getLanguageId()));
			Film f = accessor.addFilm(createdFilm);
			if (f != null) {
				filmList.add(f);
				redir.addFlashAttribute("filmList", filmList);
				mv.setViewName("redirect:filmAdded.do");
			}
			else {
				mv.setViewName("couldNotAddFilm");
			}
			return mv;
	}

	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView added() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		return mv;
	}
}
