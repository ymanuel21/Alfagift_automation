# Mobile Test Automation (Alfagift)

This repository contains mobile automation tests for the **Alfagift** application.  
It is built using **Java**, **Appium**, and **Maven**, following a clean Page Object Model (POM) structure.

---

## Project Structure

mobile-test/

mobile-test/
  pom.xml
    src/
      main/
        java/
          page objects, utils, drivers
      test/
          resources/features
    .git/

---

- **Java 8+**
- **Appium**
- **Selenium WebDriver**
- **Maven**
- **TestNG**
- **Android Emulator / Real Device**
---

## Requirements


Install the following before running the project:

1. Java JDK
Check version:

java -version

--- 

2. Maven
Check version:

mvn -version

---
3. Appium
Install via Node:

npm install -g appium
Verify:

appium -v

---
4. Appium Android Driver

appium driver install uiautomator2

5. Android SDK
Required for adb + emulator.
Check:

adb devices

---


## Installation

Clone this repository:
---------------------------
git clone https://github.com/ymanuel21/Alfagift_automation.git
---------------------------

Move into the project:
--------------------------
cd Alfagift_automation
--------------------------

Install all dependencies:
---------------------------
mvn clean install
---------------------------

## Running the Tests
1. Start Appium
---------------------------
appium
---------------------------

2. Start an emulator or connect a device
Check:
---------------------------
adb devices
---------------------------

3. Run all tests:
---------------------------
mvn test
---------------------------

4. Reports are generated at:
---------------------------
/mobile-test/target/cucumber-reports.html
---------------------------



Video Part 1
https://drive.google.com/file/d/11rYyZlCSeHtBJxB5XPkMu_zS9uuwaXf8/view?usp=sharing

Video Part 2
https://drive.google.com/file/d/1DGwmDybwUvvR6abGvsnq4BoA6g0_INfX/view?usp=sharing
