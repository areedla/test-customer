# Simple customer adding and modifying app - for learning purposes only

Install and deploy
*   Get source from Git. Latest source is in dev bransh.
*   Build and generate war with Maven
		mvn clean package
*	Deploy war to server (Jetty, Tomcat, ..)
	Tested with Jetty(latest) and Tomcat 7 and with java 1.7 and java 1.8
* Go to url serverurl/Customer
* For loging use username: user or admin and password: 123 (user are static and nothing jet to do with customers)

Technologies used: Maven, Spring MVC, Hibernate, jQuery
Database: H2 in memory

TODO: list is long..
Add more tests and rewrite input forms for better validation, use same customers as user who can, login(1-2day work), better UI ...