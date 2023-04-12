# Examen Devsu post ejecucion

1. importar el proyecto como un proyecto de maven, no usar gradle ni otro, el proyecto se hizo con maven y selenium WD.

2. Para ejecutar en intellij idea, se debe en configuraciones realizar estas parametrias para que puedas ejecutar, ingresar desde select run y configurar de esta manera.

2.1. se realizan los reporte de pruebas con serenityReport 
por lo cual necesita de la siguiente configuración para ejecutar el proyecto
editar configuraciones y luego en add new darle click, luego elegir maven y run colocar el siguiente comando clean install serenity:aggregate, luego colocar un nombre y aplicar. y si quieres elegir la ruta desde el working directory lo puedes hacer. y luego para ejecutar desde select run le das ejecutar.

3. recomendación almacenar el proyecto en descargas o escritorio para facilitar las rutas de los archivos

## Getting started

 Se crean 5 escenarios de pruebas de acuerdo a la funcionalidad segun lo que se pidio en la prueba

	#  	Scenario: inicia sesion
	#	Scenario: agrega los productos al Carrito
	#	Scenario: muestra el carrito de compras
	#	Scenario: Completar formulario de compras
	#	Scenario: Finalizar proceso de  compras
	#   Scenario: Se cierra la sesion

 1. para todo lo relacionado con la lectura y escritura por consola del archivo, teniendo en cuentas las
 instrucciones dadas para la impresión por consola del mismo.

 2. se realiza la implementación de archivo plano mencionado con anterioridad, para darle uso en la 
pagina indicada para tomar los datos desde config elements.properties

 3.  los resultados se veran por consola o por la pagina cuando se generen de forma exitosa.