<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty filmList}">
			<c:forEach var="film" items="${filmList}">
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
						<td><fmt:formatNumber value="${film.rentalRate}"
								type="currency" /></td>
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
					<tr>
						<td>Category:</td>
						<td>${film.category.categoryName}</td>
					</tr>
					<tr>
					<td>Cast:
						<table>
                        <c:forEach var="actor" items="${film.cast}">
                        <tr>
                        <td> Actor:</td>
                        <td>${actor.firstName} ${actor.lastName}</td>
                        </tr>
                        </c:forEach>
                        </table>
                        </tr>
                    </td> 
				<br>

				<form name="delete" method="post" action="delete.do">
					<input type="hidden" name="id" value="${film.id}">
					<input type="submit" name="delete" value="Delete Film">
				</form>

				<form name="editController" method="post" action="editController.do">
					<input type="hidden" name="id" value="${film.id}">
					<input type="hidden" name="title" value="${film.title}">
					<input type="hidden" name="description" value="${film.description}">
					<input type="hidden" name="releaseYear" value="${film.releaseYear}">
					<input type="hidden" name="languageId" value="${film.languageId}">
					<input type="hidden" name="language" value="${film.language}">
					<input type="hidden" name="rentalDuration" value="${film.rentalDuration}">
					<input type="hidden" name="rentalRate" value="${film.rentalRate}">
					<input type="hidden" name="length" value="${film.length}">
					<input type="hidden" name="replacementCost" value="${film.replacementCost}">
					<input type="hidden" name="rating" value="${film.rating}">
					<input type="hidden" name="specialFeatures" value="${film.specialFeatures}">
 					<input type="submit" name="edit" value="Edit Film">
				</form>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="index.html">Return home</a>
</body>
</html>