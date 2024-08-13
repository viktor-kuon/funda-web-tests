# Funda Web Tests

## Project Summary

This project contains automated web tests for the Funda.nl website. The tests are designed using Java, Selenium WebDriver, JUnit, and Page Object Model (POM) design patterns.

## Project Structure

* src/main/java/nl/funda: Contains page object models used by the tests and helper classes.
* src/test/java/nl/funda/test: Contains the test classes.

## Prerequisites

Before running the tests, ensure you have the following installed on your system:

* Java Development Kit (JDK) 8 or higher
* Maven 3.x
* Chrome browser

## Setup

1. Clone the repository  
`git clone https://github.com/viktor-kuon/funda-web-tests.git`  
`cd funda-web-tests`
2. Install dependencies  
`mvn install -DskipTests`
3. Create a file named "config" at the root level. Write the following text in the file specifying your secret code to bypass Funda's robot detection  
`user_agent=<YOUR_SECRET_CODE>`

## Running the Tests

### Using IntelliJ IDEA

#### 1. Run Individual Tests:

You can run individual tests by clicking the green run icon next to each test method or class in IntelliJ IDEA.

#### 2. Run All Tests:

To run all tests from IntelliJ, right-click on the src/test/java directory and select "Run Tests in java".