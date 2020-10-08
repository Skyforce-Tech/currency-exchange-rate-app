# currency-exchange-rate-app
Demo Application - JPA Repository Usage &amp; H2 database &amp; API calls using Rest Template

exchange-rate-api : https://ratesapi.io/documentation/

currency-exchange-rate-app calls exchange-rate-api to save the last twelve months exhange rates for few currencies to the H2 in memory database.
The base currency for this app to compare the rates saved is EURO.
We can get rate for a specific currency for a specified date from our application.

Swagger documentation: http://localhost:8080/swagger-ui.html (Used Open api for our application)
<br>
Actuator health: http://localhost:8080/actuator/health
<br>
HAL Browser: http://localhost:8080/browser/index.html
<br>
Note: HAL(Hypertext Application Language) browser searches for APIs and identifies the links. It shows the link on the screen so that we can easily browse through the API.
<br>

Response Snapshots:
<br><br>
![SAVE_RATES](https://github.com/Skyforce-Tech/currency-exchange-rate-app/blob/master/docs/images/saveRates.PNG?raw=true)
![SAVE_RATES_H2](https://github.com/Skyforce-Tech/currency-exchange-rate-app/blob/master/docs/images/saveRates_H2_DB.PNG?raw=true)
![GetRatesForSpecificDate](https://github.com/Skyforce-Tech/currency-exchange-rate-app/blob/master/docs/images/getRatesForSpecificDate.PNG?raw=true)
