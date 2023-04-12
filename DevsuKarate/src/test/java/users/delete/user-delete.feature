Feature: delete  user on petstore
@delete
  Scenario:  delete file on  pet to the  store
     #se llama la url del servicio
    Given url "https://petstore.swagger.io/v2"+"/pet/999"
    #se declara metodo a enviar
    When method delete
    #se declara status a recibir
    Then status 200