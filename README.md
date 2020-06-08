# MortagePlan
This tool calculates fixed payments per month for provided list of customers.

## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Requirements
You need to have:
1. Java 1.8+
2. Maven

### Building
1. Clone/ download and extract project to some folder
2. `mvn clean install`

If build was successful you can find `mortageplan-1.0-SNAPSHOT.jar` in `target` folder.

## Running the tests
Just use command `mvn verify` and it will launch all tests.
These tests checking that calculations of loans payments are correct.

## Running the tool
1. Prepare some CSV file in a format: `Customer,Total loan,Interest,Years`.
The tool is skiping first line in a file.

    For example:
    ```
    Customer,Total loan,Interest,Years
    Tom,1000,5,2
    Jack,4356,1.27,6
    Marlin Manson,1300.55,8.67,2
    "Roger,Rabbit",2000,6,4
    ```

2. Set file path in `src/main/resources/application.properties` in `prospects.file.csv` property.
    
    For example:
    ```
    prospects.file.csv=prospects.txt
    ```
    This path can be relative to the root folder of the project.

3. Launch by command `java -jar target/mortageplan-1.0-SNAPSHOT.jar`

# Licence

Totally free to use