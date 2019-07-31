# Submission Information

## Authors Information

* __Full Names:__ Michael Mazzone, Will Moore, Kiran Patel
* __UGA Emails:__ mike.mazzone@uga.edu, jwm18575@uga.edu, ksp86066@uga.edu
* __Course:__ CSCI 4730

## Application Overview  
  
Addressing the rubric:  
* What is New/Interesting: This is covered in the attached PowerPoint presentation.
* Technical Depth & Sophistication: This project was built using industry-standard project structure and technologies. We feel it is sufficiently sophisticated for the time allotted and shows good usage of JSP, JDBC, MySQL, Maven, Tomcat, and front-end libraries.  
* Running Demo and Completeness: The demo is fully functional and achieved everything we initially proposed.  
* UI Aspects/Front-end Quality: The demo shows that the UI is modern and well-designed, making the results of the queries the primary focus.  
* Data Set Quality: This is real-world data of a non-trivial size (160,000 tuples initially) that was carefully trimmed to only include what we need.  
* Normalization Process: 3NF is covered in the attached PowerPoint presentation.  
* UML Design: UML and reverse-engineering from MySQL Workbench is covered in the attached PowerPoint presentation.  

Queries successfully created:
* Query 1: List entity and total impressions

* Query 2: List entity and the ads they pay for

* Query 3: List ads by entity and the number of impressions per ad

* Query 4: List companies and their target audience

* Query 5: Show proportion of all ads an entity is responsible for

* Query 6: Rank entities by average proportion of political/not_political

* Query 7: List all ads within a date range

* Query 8: List well-known entities and compare their total impressions to average of all entities

* Query 9: List well-known entities and their market caps and compare their average impressions to the average impressions of all entities

## Contribution Guidelines 
**PLEASE FOLLOW CAREFULLY**:
 * Clone repo with: `git clone https://github.com/GitMazzone/db-term-project.git`
 * Work in a development branch (NOT in master) with: `git checkout -b "dev/your-branch-name-here"`

When you want to push your changes to  master, please ensure your code runs without errors or significant warnings. Follow these steps:

3. In your branch, pull the latest master branch code and resolve any merge conflicts with: `git pull origin master`
4. After resolving any conflicts, add your changes, commit, and push your branch: `git add [files]`, `git commit -m "description of changes"`, `git push`
5. Open [the repo](https://github.com/GitMazzone/db-term-project) in a browser and submit a pull request. Click the button shown below: 
<img src="https://i.imgur.com/gx3OWvM.png" alt="new pr" width="250"/>  
  
6. Make sure master is the base and your branch is the compared branch, then click create pull request.  
7. When your pull request is approved, your code will merge with master!

Be sure to comment any methods and classes you create, and add your name to the `@author` tag.  
  
NOTE: You will need to install Tomcat v9.0 and Maven (linked below) to be able to run this project.

## Resources Used
* ProPublica's data set can be found here: [Political Advertisements from Facebook](https://www.propublica.org/datastore/dataset/political-advertisements-from-facebook)
* Maven: [documentation](https://maven.apache.org/)
* JDBC: [documentation](https://www.oracle.com/technetwork/java/overview-141217.html)
* JSP: [documentation](https://docs.oracle.com/javaee/5/tutorial/doc/bnajo.html)
* Tomcat: [documentation](https://tomcat.apache.org/download-90.cgi)
