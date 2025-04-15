
# 🏦 ParaBank Automation Testing Suite


This project automates testing for the **ParaBank** online banking web application using Selenium WebDriver and TestNG. It ensures the end-to-end integrity and usability of the platform with extensive UI validations.


## Tech Stack

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Jenkins** (CI/CD)
- **Ngrok**



## Features covered

- 🔐 Login / Registration  
- 💳 Open New Account  
- 💼 Account Overview  
- 💸 Funds Transfer  
- 🧾 Bill Payments  
- 📈 Transaction History  
- 📝 Update Contact Details  
- 🧮 Loan Requests  
- 🚪 Logout 


## Installation

1.	Install Eclipse IDE (or any preferred IDE).
2.	Install Java JDK (ensure JAVA_HOME is set).
3.	Clone this repository:
```bash
git clone https://github.com/your-username/your-repository-name.git
```
4.	Open the project in Eclipse.
5.	Make sure Maven is installed and configured.
6.	Update Maven dependencies (Right-click on project > Maven > Update Project).

    
## Running Tests
-	Run the testng.xml file to execute the complete suite.
-	Alternatively, right-click on any individual test class and select Run As > TestNG Test.
-	Test execution reports will be generated automatically.
-   The test can also be run using mvn from commad prompt by running the below code: 
```bash
run test
```


## Folder Structure
```
├───.settings
├───reports
├───src
│   ├───main
│   │   └───java
│   │       ├───StandardFramework
│   │       │   ├───Resources
│   │       │   └───ReusableComponents
│   │       └───StandaredFramework
│   │           └───PageObject
│   └───test
│       └───java
│           └───StandardFramework
│               ├───Data
│               ├───TestComponents
│               └───Tests
├───target
│   ├───classes
│   │   ├───META-INF
│   │   │   └───maven
│   │   │       └───StandardFramework
│   │   │           └───Framework
│   │   ├───StandardFramework
│   │   │   ├───Resources
│   │   │   └───ReusableComponents
│   │   └───StandaredFramework
│   │       └───PageObject
│   ├───generated-sources
│   │   └───annotations
│   ├───generated-test-sources
│   │   └───test-annotations
│   ├───maven-status
│   │   └───maven-compiler-plugin
│   │       ├───compile
│   │       │   └───default-compile
│   │       └───testCompile
│   │           └───default-testCompile
│   ├───surefire-reports
│   │   ├───junitreports
│   │   └───Suite
│   └───test-classes
│       └───StandardFramework
│           ├───Data
│           ├───TestComponents
│           └───Tests
└───test-output
    ├───Default suite
    ├───junitreports
    └───Suite
```
## Screenshots
- Extent Report Screenshot
![image](https://github.com/user-attachments/assets/802bd0e6-9719-4e2e-a847-fe6749b42ccd)
- Jenkins
![Successfull Build](https://github.com/user-attachments/assets/1095da89-282f-4616-9097-d130e3c8876a)
- webhook(for CI/CD)
![Webhook](https://github.com/user-attachments/assets/cc05d38b-fbb0-4496-a54e-e89f384e985e)
- ParaBank
![ParaBank UI](https://github.com/user-attachments/assets/b1e2f279-5a97-48a0-85fc-74bff7a74018)


  


