# WEATHER PREDICTOR
Predict weather condition for an input date provided by user.

# Problem Statement
Create a toy weather simulation of the environment (taking into account things like atmosphere, topography, geography, oceanography, or similar) that evolves over time at various locations and times. 
Prerequisites
•	JDK 1.8 (JAVA_HOME and PATH set)
•	Apache Maven 3.3 or higher (MVN_HOME and PATH set)
•	Weather Reference data files from June 2016 to July 2017
•	To run in eclipse, paste the project in workspace
•	To run as a jar, copy the input directory to the location where the jar is running.

# Solution Approach
The Weather Predictor project forecasts the below conditions for the input date, 
1.	Climate conditions (Rain, Snow or Sunny)
2.	Temperature
3.	Pressure
4.	Humidity

Temperature, Pressure and Humidity: The Double values of temperature, humidity and pressure are passed as a double array to the ARIMA model. The Arima emits single values considering the history values of the various parameters over the predefined dates

Climate Condition:  Climate condition is predicted by analyzing the pattern of the temperature, pressure and humidity and categorizing them logically using range of values. 

The Arima model takes in to account the Auto Regression, Integration and Moving Average of a set of variables to predict future values.
Working of the application

# Input
The date value provided in the format yyyy-MM-dd by the user will be considered as the input argument for the code. The code will validate if the input date is a future value. 
Once the validation succeeds, the code will retrieve historic data two months prior to the respective input month, from the reference files available in the INPUT directory. The 60 days constant value is configurable. 

# Simulation
Say, the input date provided is 2018-01-05 and the period of history days considered is 60. In this case, the program accesses values from files for October, November, December and January for the respective locations. Once the dates are fetched, the code maps the date against the dates in the input files and fetches the respective temperature, pressure and humidity. The location, position and input future date are also fetched. The double arrays formed by the temperature, pressure and humidity of the dates between 2017-10-05 and 2018-01-05 are passed on to the Arima model for prediction. The model predicts the temperature, pressure and humidity. These three values are later used to classify the climate to Rainy, Sunny and Snowy.

# Output
The output will be available in the output directory with filename as “out_(input date provided).txt”. For example, if the input date provided is 2018-01-05, the output filename will be out_2018-01-05.txt

# How to run the application
# Input
User Input: The input from the user should be a date value in the format yyyy-MM-dd (eg. 2018-01-05). 
Note: The input has to be a future date. An exception message would be returned if the date provided is not one.

Input Directory: Weather reference data files in .csv format named after the number of the month. Data files for each location are stored in the corresponding location folder named according to the locations from where they were recorded. 
Source of input: History data files from The Bureau of Meteorology, Govt. of Australia, Wunderground
Steps to run the application

- Step 1 : Clone the repository.
- git clone https://github.com/bibinnahas/weather-predictor.git

- Step 2 : Build the project.
- Navigate to the root directory of the project and build the project using the below command:
  mvn clean install

- Step 3 : Copy the input directory and jar to a directory. Run the application and see the output directory in the same path for the     prediction data file
 
- Pattern : java -jar predictor-0.0.1-jar-with-dependencies.jar 2018-01-01

# Output
Each output record will be in the below format. There will be as many as records as the input locations for which the history data is available.
- Pattern: location|latitude,longitude,elevation|date|climate_conditions|temperature|pressure|humidity
- e.g., ADELAIDE|-34.92,138.60,7|2018-01-01|Rain|21.445465629879468|1010.9133082811322|62.640110650144635

