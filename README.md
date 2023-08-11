# conversor-de-moneda
Encriptador de Texto
Autor Diaz Damian
this proyect is a small change calculator of local currecy vs foregin currency prototype and it also includes a small temperature calculator.
the idea of the proyect is to practice of the making a visual program with the use of JOption class with a series of requeriments given for a programing course of alura.
Note: the names of the clases, functions and variables are written in spanish. the program was made just for a programing course in spanish. but it was noticed that english naming is a better practice.  
in the makin of this proyect the main class was only used for execution and the class ControladorDeVentanas (windowsController) was used to do the bulk of the program.
ControladorDeVentanas (windowsController) is composed of: 
-string variables for the program dialog : 
  'opciones' is used to chose the conversion of money or temperature.
  'operacionesConMonedas' is used to chose the money conversion operation. this is an pre ordered string it's order matters for the money conversion functions.
  'operacionesConTemperatura' is used to chose the temperature conversion operation.
  'dialogoConMonedas' is used for the chose the coin messages.
  'dialogoConTemperaturas' is used for the chose the temperature messages.
  'opcionSeleccionada' is used to store the chosen operation of the first window (money or temperature).
  'operacionSeleccionada' is used to store the chosen conversion operation of the second window (the chosen conversion).
-double varibles used :
  'cantidad' is used to store the amount imput in the third panel.
  'total' is used to store the total.
  'monedas' this array is used to store the change used to do the conversion. if noticed in the making of the program that the change value changes over time, but because is a small practice proyect a fixed value was used.
-javax swing variables used:
  'panelNuevo' is a JOptionPane variable used to be the base of the diferent windows construction.
  'frame' is used for the making some windows.
 -boolean variables used:
  'canceloLaOperacion' is used to check if the user use the cancel button to exit the program.
-functions used in the program:
 'convertirAMonedaExtrangera' it converts local currency into foregin currency values are taken from 'monedas'. it's uses the first half of 'operacionesConMonedas' to chose the currency
 'convertirAMonedaNacional' it converts foregin currency into local. it's uses the second half of 'operacionesConMonedas' to chose the currency
 'convertirAFahrenheit' it converts celcius to fahrenheit.
 'convertirAKelvin' it converts celcius to kelvin.
 'convertirACelsius' it converts fahrenheit or kelvin to celcius.
 'primerPanel' it makes the first windows to chose the conversion of money or temperature.
 'segundoPanel' it makes the second windows to chose the operation.
 'tercerPanel' it makes the third windows where an input of quantity is asked. also only allows numbers.
 'cuartoPanel' it makes the fourth windows where it shows the result.
 'quintoPanel' it makes the fifth windows where is shows a message asking if you wish to continue operating.
 'programaFinalizadoPanel' it makes the program ended windows.
 'soloIngreseNumeros' it makes the windows that ask for only input numbers.
 'redondearResultado' it round the result.
 'realizarConversion' it calls the conversion functions.
 'programa' it is used to call the main program functions in order.

