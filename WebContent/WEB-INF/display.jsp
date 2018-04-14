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
				</table>
				<br>

				<form name="delete" method="post" action="delete.do">
				${film.id}
					<input type="hidden" name="id" value="${film.id}">
					<input type="submit" name="delete" value="Delete Film">
				</form>

				<form action="">
					<input type="submit" name="" value="Edit Film">
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