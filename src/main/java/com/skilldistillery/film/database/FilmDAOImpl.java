package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;

public class FilmDAOImpl implements DatabaseAccessor {
	private static String user = "student";
	private static String pass = "student";
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		String sql = "select id, first_name, last_name from actor join film_actor"
				+ " on actor.id = film_actor.actor_id where film_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				Actor actor = new Actor(id, fn, ln);
				cast.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cast;
	}

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		String sql = "select id, title, description, release_year, language_id, rental_duration,"
				+ "rental_rate, length, replacement_cost, rating, special_features " + "from film where id = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);
				List<Actor> cast = getActorsByFilmId(id);
				Language language = getFilmsLanguage(languageId);
				Category category = getFilmsCategory(id);
				film = new Film(filmId, title, description, language, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, category, cast, 0);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return film;

	}

	public Actor getActorById(int actorId) {
		Actor actor = null;
		String sql = "select id, first_name, last_name from actor where id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		String sql = "SELECT id, title, description, release_year, language_id,"
				+ " rental_duration, rental_rate, length, replacement_cost, rating,"
				+ " special_features FROM film WHERE title like ? OR description LIKE ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				int languageId = rs.getInt(5);
				int rentalDuration = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replacementCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);
				List<Actor> cast = getActorsByFilmId(id);
				Language language = getFilmsLanguage(languageId);
				Category category = getFilmsCategory(id);

				// Film film = new Film(id, title, description, releaseYear, languageId,
				// rentalDuration, rentalRate,
				// length, replacementCost, rating, specialFeatures, cast, language);
				Film film = new Film(languageId, title, description, language, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, category, cast, 0);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	public Language getFilmsLanguage(int languageId) {
		Language language = null;
		String sql = "select language.name from language where language.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, languageId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				String name = rs.getString(1);
				language = new Language(name);

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;

	}

	public Category getFilmsCategory(int filmId) {
		Category category = null;
		String sql = "SELECT c.id, c.name FROM category c JOIN film_category fc ON c.id = fc.category_id JOIN film f ON f.id = fc.film_id WHERE f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				category = new Category(id, name);

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;

	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Film addFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "insert into film(title, description, release_year, language_id, rental_duration, "
					+ "rental_rate, length, replacement_cost, rating, special_features ) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					int newFilmId = generatedKeys.getInt(1);
					film.setId(newFilmId);
					addCategoryToDatabase(newFilmId, film.getCategoryId());
				}
			} else {
				film = null;
			}
			System.out.println(film);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error in rollback");
				}
				return null;
			}

			throw new RuntimeException("Unable to add film");
		}
		return film;
	}

	@Override
	public void addCategoryToDatabase(int filmId, int categoryId) {
		try {
			String sql = "INSERT INTO film_category(film_id, category_id) VALUES(?, ?)";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, filmId);
			stmt.setInt(2, categoryId);
			int updateCount = stmt.executeUpdate();
			if (updateCount != 0) {
				System.out.println("Input category success");
			} else {
				System.out.println("Input category fail");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean deleteFilm(Film film) {
		boolean deletion = false;

		try {
			String sql = "delete from film where id = ?";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount != 0) {
				System.out.println("Film deleted successfully");
				deletion = true;
			} else {
				System.out.println("Unable to delete film");
				deletion = false;
			}

			return deletion;
		} catch (SQLException e) {
			e.printStackTrace();
			deletion = false;
			return deletion;
		}
	}

	@Override
	public Film editFilm(Film film) {
		Connection conn = null;
		System.out.println(film);
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			String sql = "update film " + "set title = ?," + " description = ?, " + "release_year = ?, "
					+ "language_id = ?, " + "rental_duration = ?, " + "rental_rate = ?," + " length = ?, "
					+ "replacement_cost = ?, " + "rating = ?, " + "special_features = ? " + "where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			stmt.setInt(11, film.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error in rollback");
				}
			}

			throw new RuntimeException("Unable to edit film");
		}
		System.out.println(film);
		return film;
	}

}