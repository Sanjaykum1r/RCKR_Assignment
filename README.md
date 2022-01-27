# RCKR ASSIGNMENT

## In this Assignment I have made four Packages:

- Controller
- Model
- Service
- Util


### Controller
- In Controller package I have Create DistanceController class to handle user request with help of @RestController annotation and  Response json format.
- In this class I create a method getDistance. And this method return the sum of the length of all lines (in kms ) that can be drawn between co-ordinates of these countries.
- And theseCalculation done with help of DistanceCalculator Class.


### Model
- In Model Package I create Multiple Classes like: Country, Currency, Language, RegionalBloc, Translations.
- These Classes are Pojo class. which is Parse data from DataSet. 


### Service
- In Service Package create a DistanceCalculator Spring @Service annotation is used with classes that provide some business functionalities.
- Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
- I create multiple method to perform multiple business functionalities.
- In this Class I create getCountries method to get Countries name with distinct currency.
- After that I create Calculate_Distance method in this method I calculate distance based on population and number of counties. And return Round length of each line and final result to 2 decimal points.
- After that I create getDistance method in this method find the sum of the length of all lines (in kms) that can be drawn between co-ordinates(lon & lat) of these countries. And return distance between two countries.
- After that I create GetFinalCountryList method Find latitude and longitude of utmost 20 countries, ordered by population, with a population greater or equal to the population limit given below and have atleast one currency exclusively for themselves.
- In this method I have pass two requestParam variable first is population and second is maxVal(number of countries).
- In Distance method calculate difference between longitude and latitude with given earth ***Radius***.


### Util
- In this Package I have Create  Class Util.
- This Util class parse data from ***URI*** with help of ObjectMapper. 
- ObjectMapper provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model ( JsonNode ), as well as related functionality for performing conversions.





##Configuration

- @GetMapping("/getDistance?population=20792&maxInput=20)
  * This **API** Takes two data inputs population and number of country(maxInput) as url requestParam.
  * Return: The sum of the length of all lines (in kms) that can be drawn between co-ordinates of these countries.


## End Point table

<html>
 <table>
  <tr>
    <th>VERBS</th>
    <th>LINK</th>
    <th>REQUEST PARAM</th>
<th>Result</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>http://localhost:8080/getDistance?population=20792&maxInput=20</td>
    <td>Population : 20792
MaxInput : 20 </td>
<td>1825654.14</td>
  </tr>
</table>
</html>