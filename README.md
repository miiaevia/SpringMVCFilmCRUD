## Spring MVC Film C.R.U.D. Project

### Project Description 
* Users are able to search for a film in a database by keyword or film id. Users can also add a film to the DB. 
* Once a user has found or added a new film, they are given the option to delete or edit the new film. 
* Note: Users can only delete films they added themselves, which don't have child records.
* When a film is displayed, the list of actors and the film's category is displayed also. 

### Project Operation
* Home page displayes three options: Search by Id, Search by Keyword, and Create New Film
* Search by Id brings up a new page that allows the user to input the id. 
* Search by Keyword brings up a new search page to input the keyword. 
* Create new film brings up a page that allows users to input field information and submit.
* All three return the same results page, which will display one or more films if found or added. 
** These films have the option to be Edited or Deleted. 
** Deletion removes the film from the database.
** If the user chooses to edit the film, a new view is displayed that allows the user to edit the film information and submit. 
* If search, add film, deletion, or edit are successfully completed, the user is informed.
* If action is unsuccessful, the user is also informed.

### Technologies Used
* SpringMVC
* Apache Tomcat
* Amazon EC2
* MySQL
* Java
* HTML/JSP
* Gradle

### Lessons Learned
* Quotes matter
* The difference between using an html file vs a jsp file and how they work with the controller
* How to pass command objects
* Using a controller to get information from users into the DB and then display the results
* The importance of isolated, de-coupled code when working in groups
* The importance of communication to avoid merge conflicts, when working in groups
* Objects can have field attributes collected from multiple DB tables