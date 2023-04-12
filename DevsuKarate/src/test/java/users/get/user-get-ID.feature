Feature: Get   on petstore
@
  Scenario:  serch to  pet for ID
  # se llema al metodo que crea el registro el cual retorna el id de creación
    * call read("../post/user-post.feature@post")
  #se llama la url del servicio
    Given url "https://petstore.swagger.io/v2"+"/pet/" +ContactId
    #se declara metodo a enviar
    When method get
   #se declara status a recibir
    Then status 200
  #se realiza busqueda match en el response del servicio, assert para validar que el id de creación está en el response
    And match $.id == 999
    And match $.name =='Violeta'

  Scenario:  serch to  pet for status
    Given url "https://petstore.swagger.io/v2"+"/pet/findByStatus?status=sold"
    When method get
    Then status 200





