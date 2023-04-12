Feature: Put user on petstore

  Scenario:  Edait name and estatus a pet to the  store
    Given url "https://petstore.swagger.io/v2"+"/pet"
    And request   { "id": 999,  "category": { "id": 100, "name": "DOG" }, "name": "violeta Updated",  "photoUrls": [ "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnJJsafLUMkDHldhF7u5-tuZjtN7844o-L0g&usqp=CAU" ], "tags": [ { "id": 100, "name": "french poodle" } ], "status": "sold" }
    When method put
    Then status 200
    And match $.id == 999
    And match $.status == 'sold'
    And match $.name == 'violeta Updated'