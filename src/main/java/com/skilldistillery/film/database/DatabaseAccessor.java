package com.skilldistillery.film.database;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;

public interface DatabaseAccessor {
	public Film getFilmById(int filmId);

	public Actor getActorById(int actorId);

	public List<Actor> getActorsByFilmId(int filmId);

	public List<Film> getFilmByKeyword(String keyword);
	
	public Language getFilmsLanguage(int languageId);
	
	public Film addFilm (Film film);
	
	public boolean deleteFilm (Film film);
	
	public Film editFilm (Film film);
	
	public void addCategoryToDatabase (int filmId, int categoryId);
	
	public Category getFilmsCategory(int filmId);
}
