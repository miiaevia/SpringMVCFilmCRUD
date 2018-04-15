<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Film</title>
</head>
<body>
	<h2>Film Editor</h2>
	<br>
	<a href="index.html">Return home</a>
	<br>
	<h3>Film:</h3>
	<br>
	<table>
		<tr>
			<td>Film id:</td>
			<td>${film.id}</td>
		</tr>
		<tr>
			<td>Title:</td>
			<td>${film.title}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${film.description}</td>
		</tr>
		<tr>
			<td>Year Released:</td>
			<td>${film.releaseYear}</td>
		</tr>
		<tr>
			<td>Language:</td>
			<td>${film.language.name}</td>
		</tr>
		<tr>
			<td>Duration of rental:</td>
			<td>${film.rentalDuration}</td>
		</tr>
		<tr>
			<td>Rental rate:</td>
			<td><fmt:formatNumber value="${film.rentalRate}" type="currency" /></td>
		</tr>
		<tr>
			<td>Length of film:</td>
			<td>${film.length}</td>
		</tr>
		<tr>
			<td>Replacement Cost:</td>
			<td><fmt:formatNumber value="${film.replacementCost}"
					type="currency" /></td>
		</tr>
		<tr>
			<td>Rating:</td>
			<td>${film.rating}</td>
		</tr>
		<tr>
			<td>Special Features:</td>
			<td>${film.specialFeatures}</td>
		</tr>
	</table>
	<br>
	<form name="edit" method="POST" action="edit.do">
	 <input type="hidden" value="${film.id }" name="id">
		<label for="title">Title</label>
 		<input type="text" name="title" value=${film.title }><br>
 		<label for="description">Description</label>
		<input type="text" name="description" value=${film.description }><br>
 		<label for="releaseYear">Release Year</label>
		<input type="number" name="releaseYear" min="1901" max="2099" value=${film.releaseYear }><br>
 		<label for="rentalDuration">Rental Duration</label>
		<input type="number" name="rentalDuration" min="1" max="21" value=${film.rentalDuration }><br>
 		<label for="rentalRate">Rental Rate</label>
		<input type="number" name="rentalRate" step="0.05" min="0" max="10" value=${film.rentalRate }><br>
 		<label for="length">Length of Film</label>
		<input type="number" name="length" min="5" max="240" value=${film.length }><br>
 		<label for="replacementCost">Replacement Cost</label>
		<input type="number" name="replacementCost" step="1" min="0" max="100" value=${film.replacementCost }><br>
 		<label for="rating">Rating</label>
	 	<select name="rating">
 			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG13</option>
			<option value="R">R</option>
			<option value="NC17">NC17</option>
	 	</select>
	 	<br>
 		<label for="specialFeatures">Special Features</label>
		<select name="specialFeatures">
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind the Scenes">Behind the Scenes</option>
		</select> <br>
		
		<label for="language">Language</label>
		<select name="languageId">
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Mandarin</option>
			<option value="5">French</option>
			<option value="6">German</option>
		</select> <br>
 		<button type="submit" class="btn btn-primary" value ="send">Submit</button>
	</form>
</body>
</html>


