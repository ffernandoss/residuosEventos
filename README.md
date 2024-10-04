Link al repositorio: https://github.com/ffernandoss/residuosEventos.git

Pagina 1 hecha por arturo lopez


Pagina 2 hecha por Rodirgo perez


Pagina 3 hecha por Roberto Quilez


Pagina 4 hecha por Fernando Santamaria


*Pagina 1 Pantalla de inicio*

*Pagina 2 Calendario*

*Pagina 3 Mapa*

Utilizas Jetpack Compose para mostrar una imagen de un mapa con los puntos de reciclaje de Madrid.

Importaciones: Se importan las librerías necesarias de Jetpack Compose para trabajar con imágenes, modificadores y vistas previas.

Función MapaReciclajeMadrid: Es una función composable que carga y muestra una imagen desde los recursos drawable del proyecto. La imagen se escala para llenar todo el tamaño disponible del contenedor.

Función MapaReciclajeMadridPreview: Es una función de vista previa que permite ver cómo se verá el composable MapaReciclajeMadrid en el editor de diseño de Android Studio.


Pagina 4 Graficas
pantalla compuesta por las clases AreaChart,BarChart,ColorPicker,DonutChart,HalfCircleChart,LineChart,PieChart,SegundaActividad

BarChart:
tiene una lista de valores, otra de colores y otra para colocar los nombres en el eje x, ademas tambien tiene una variable que será el nombre del eje Y, se encarga de dibujar el tamaño de las barras. Luego ademas tiene un Canvas el cual se encarga de dibujar los ejes, de poner los nombres de los valores en el eje x y el nombre del eje y, en esta grafica tambien lo que hace es ponerse los valores encima de cada una

ColorPicker:
tiene una funcion colorPicker, donde imprime las opciones de los colores disponibles, cuando se pulsa el boton de cambiar color aparecen las diferentes opciones de colores, cuando se vuelve a pulsar se cierra, el dropMenuItem se encarga de que aparezcan los colores y que al pulsar sobre el se llame a la funcion que recoge el color seleccionado

HalfCircleChart:
es igual que donutChart pero varia el angulo inicial que en vez de 360 grados es 180 grados

LineChart:
tiene la funcion DrawLineChart, tiene los mismos atributos q las demas funciones, una lista de valores,una de nombres, el nombre del ejeY y la lista de colores, contien un Canvas donde se encarga de dibujar ambos ejes, poner el nombre del eje Y, luego para dibujar la linea hace uso de Path, con forEachIndex calcula el valor de cada uno, luego con lineheight calcula cuanto de alto será cada linea y con lineX la coloca en el eje, si el primer valor lo ubica donde va a ir siempre el primer valor, y si no lo es hace una linea del valor anterior al nuevo, luego se hace uso de drawPath para pintarlo todo

PieChart:
tien la funcion DrawPieChart la cual tiene la lista de valores y la lista de colores. contiene un canvas el cual se encarga de dibujar el tamaño de la figura. luego se encarga de obtener cada valor por separado, lo divide entre el total de todos los valores juntos y lo multiplica por el tamaño de la figura, luego usa drawArc para para establecer el tamaño que ocupará cada valor

DonutChart:
es igual que pieChart pero la variable de usar el circulo la tiene en falso

AreaChart (es parecido al de barras pero es mas ancho):
tiene la funcion DrawAreaChart la cual tiene una lista de valores, otra de colores y otra para colocar los nombres en el eje x, ademas tambien tiene una variable que será el nombre del eje Y, tiene un Canvas el cual se encarga de crear el tamaño de la grafica, dibujar ambos ejes junto con sus nombres, luego usa DrawRect la cual se encarga de dibujar el area de la grafica, luego está la opcion de solo mostrar la grafica seleccionada


SegundaActividad:
Esta actividad hereda de componentActivity
está compuesto por la funcion BarChartScreen,DropMenuButton, BarchartScreen2,LineChartScreen,PieChartScreen,CircleChartScreen,HalfCircleChartScreen y AreaChartScreen

BarChartScreen:
primero tiene todas las funciones que se van a usar: las de los valores introducidos, los mensajes de error y las variables de los colores de cada funcion.
Se hace uso de una columna donde apareceran tanto los textField para introducir valores como las graficas y los demas botones, se usa vertical scroll para poder desplazarse por la pantalla
DropMenuButton:
tiene un boton que al ser pulsado hace que la variable expanded se convierta en true y aparezcan las diferentes opciones de graficas que hay,DropDownMenu hace que si se pulsa fuera de ninguna de las opciones, o si se pulsa una opcion que expanded vuelva a ser falsa, tambien controla los errores si hay algo incorrecto, luego se muestran los botones de mostrar todas las funciones o el desplegable, cuando se le da al boton de todas alas graficas aparece cada funcion con un texto indicando que funcion es y sus respectivos colores y los 3 botones para cambiar color

BarchartScreen2: proporciona los nombres que se añadiran a la lista de valores del eje X y el nombre del eje Y, llama a la funcion de DrawBarChart pero con el atributo de mostrar los valores encima de la grafica en false

LineChartScreen:
proporciona los nombres que se añadiran a la lista de valores del eje X y el nombre del eje Y, y llama a la funcion de DrawLineChart

PieChartScreen:
llama a la funcion de DrawPieChart

CircleChartScreen:
llama a la funcion de DrawDonutChart

HalfCircleChartScreen:
llama a la funcion DrawHalfCircleChart

AreaChartScreen
proporciona los nombres que se añadiran a la lista de valores del eje X y el nombre del eje Y, y llama a la funcion de DrawAreaChart

pagina1: es el inicio del programa y esta comformado por dos clases: Principio y slash.

la clase slash es una imagen de carga que se le enseña al usuario mientras carga el programa 

la clase Principio es la pantalla de bienvenida del programa contiene un mensaje de bienvenida al usuario y un botón que al pulsarlo te envía al mapa de residuos.
