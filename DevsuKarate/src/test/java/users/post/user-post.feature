Feature: Post user on petstore
@post
  Scenario:  Add a new pet to the  store
  #se llama la url del servicio
    Given url "https://petstore.swagger.io/v2"+"/pet"
  #se envia body
    And request   { "id": 999,  "category": { "id": 99, "name": "DOG" }, "name": "Violeta",  "photoUrls": [ "https://www.dreamstime.com/stock-photo-poodle-dog-pooping-green-grass-park-making-poo-park-image95619005" ], "tags": [ { "id": 100, "name": "french poodle" } ], "status": "available" }
   #se declara metodo a enviar
    When method post
  #se declara status a recibir
    Then status 200
  #se almacena el id creado para luego usarlo en busquedas
    And def ContactId = $.id
    And match $.status == 'available'



