# PetStore API TA Project

## Prerequisites

- Java 21 (please update all the PATHs if needed)
- Maven 3.11 (please update all the PATHs if needed)

## Setup

1. Clone the project:
   `git clone https://github.com/ihorrudakov-aqa/petstore-api.git`
2. Install all required dependencies `mvn clean install`.
3. Run tests `mvn clean test`.
4. You can specify additional parameters: `environment` and `baseUrl`. Example: `mvn clean test -Denvironment=dev -DbaseUrl=https://petstore.swagger.io`.
5. TA framework supports `dev` env only for now. If you try to run tests using `prod` or `stage` envs, it will cause an `NotImplementedException` error.

## Report

- After test execution please open:
   `./target/surefire-reports/index.html`

