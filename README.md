# Data Grid Generator and Comparator

A project that uses a simple strategy to generate a data grid (Facts: Gender, City, Dimension: Age, Height, and Weight) 
This also has a simple comparator that can compare two data grids to determine if they a equal. 

## Steps to set up and run locally:

*  Use IntelliJ or any suitable IDE of your choice.
*  Java 20 (min version : Java 8)
*  Maven 3
*  Import as maven project
*  mvn clean install

## Key objectives: 

* Demonstrates the use of Strategy, Builder and Singleton (Spring) design patterns.
* Demonstrates the use of SOLID principles. 
* Simple illustration of integrating with logback.
* Uses Test Frameworks like Junit, JunitParams, Mockito, SpringBoot Test.
* Key POJOs have been extracted to a separate module 'api', so that they can be easily re-used on other modules when project grows. If some are needed in projects which are on different repos, then 'api' can be pulled into a separate repo. 
* Integrated with Jacoco (Code Coverage)
* Checkstyle plugin has been integrated with some custom rules (checkstyle.xml) 
* Some basic examples of Java Streams API, collect, groupingBy, etc.
* Parameterizing environment specific values using spring profiles. 
* Integration with apache commons* libraries. 

## TODO / Next Steps:  

* Visualizing the flow, one of the good approach would be to use c4 (https://c4model.com), that way the flow is maintained and kept uptodate with the code.
* Integrate with Cucumber for biz scenario intesive use cases, to repeat IT tests for different scenarios.  
* Plugin in sonar, should be easy to do so if we have an enterprise sonarqube set up with stats being sent on every PR, plus master build.
* Parallelizing IT test cases execution. 
* Add additional input validations and project specific exceptions. 
* Build any retry mechanisms. 
* For large repos, the checkstyle, jacoco plugin configuration could be extracted to it's own module can be made to run for each module.  
