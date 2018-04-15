package com.skilldistillery.film.entities;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class Film {
	private int id;
	private String title;
	private String description;
	private Language language;
	private int releaseYear;
	private int languageId;
	private int categoryId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private Category category;
	private List <Actor> cast;
	
	public Film() {
		
	}
	

	
	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Language getLanguage() {
		return language;
	}



	public void setLanguage(Language language) {
		this.language = language;
	}



//	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
//			double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.releaseYear = releaseYear;
//		this.languageId = languageId;
//		this.rentalDuration = rentalDuration;
//		this.rentalRate = rentalRate;
//		this.length = length;
//		this.replacementCost = replacementCost;
//		this.rating = rating;
//		this.specialFeatures = specialFeatures;
//	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	public Film(int id, String title, String description, Language language, int releaseYear, int languageId,
		int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
		String specialFeatures, Category category, List<Actor> cast, int categoryId) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.language = language;
	this.releaseYear = releaseYear;
	this.languageId = languageId;
	this.rentalDuration = rentalDuration;
	this.rentalRate = rentalRate;
	this.length = length;
	this.replacementCost = replacementCost;
	this.rating = rating;
	this.specialFeatures = specialFeatures;
	this.category = category;
	this.cast = cast;
	this.categoryId = categoryId;
}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	public int getLanguageId() {
		return languageId;
	}


	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}


	public int getRentalDuration() {
		return rentalDuration;
	}


	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


	public double getRentalRate() {
		return rentalRate;
	}


	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public double getReplacementCost() {
		return replacementCost;
	}


	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}



	public String getSpecialFeatures() {
		return specialFeatures;
	}


	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}




	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", language=" + language
				+ ", releaseYear=" + releaseYear + ", languageId=" + languageId + ", categoryId=" + categoryId
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
				+ ", category=" + category + ", cast=" + cast + "]";
	}



	public List<Actor> getCast() {
		return cast;
	}


	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	
	
}


