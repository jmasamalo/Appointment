STEPS TO FOLLOW INSTALLATION
=============================
This is implemented using Spring MVC, using STS IDE (eclipse with embeded apache tomcat - 
Pivotal tc Server Developer Edition v3.2), you can also use Apache Tomcat. 
It is a Java maven project

1.) Install MySQL to you machine
	Make sure you for the MySQL username and password match the ones in 
	WEB-INF/config/applicationContext.xml
	Note: current set to user:root, password:root

2.) You can use MySQL Workbench to do the following (3, 4, 5)

3.) Create database: jlm

CREATE DATABASE jlm;

4.) Create table 
CREATE TABLE `jlm`.`appointment` (
  `id` INT(6) NOT NULL AUTO_INCREMENT,
	description TEXT NOT NULL,
	appointment_date TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'A table to hold appointments';

5.) Run the following queries, to start with

insert into jlm.appointment(description,appointment_date) values("Java interview", '2018-02-15 13:09:59');
insert into jlm.appointment(description,appointment_date) values("PHP interview", '2018-02-16 13:09:59');
insert into jlm.appointment(description,appointment_date) values("Screening", '2018-02-17 13:09:59');

6.) Have STS ready, import the Java project as maven project, by browsing to the folder containing the application.

7.) Build the project and run, while MySQL is already running as well
 

TESTING
===============
Kindly note DATE is saved well in DB but not displaying well in the page table (not formatted hence gives just a figure).
No date picker implemented
1.) Use past date as 2017-02-17 13:09:59 , wont be added to db and validation shows when you click new again
2.) Use future date as 2018-05-17 13:09:59, it will add if description is not empty
3.) Putting text under date field will show validation error, after clicking new


Lastly :
=============

I can work further to improve date issue (formatting and date picker).
Please, this is what I have accomplished for now. Thank you. 

By JOHN LUCAS MASAMALO

