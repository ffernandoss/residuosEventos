LINk al repositorio
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

*Pagina 4 Graficas*
pantalla compuesta por las clases AreaChart,BarChart,ColorPicker,DonutChart,HalfCircleChart,LineChart,PieChart,SegundaActividad

AreaChart (es parecido al de barras pero es mas ancho):


BarChart:


ColorPicker:
tiene una funcion colorPicker, donde imprime las opciones de los colores disponibles, cuando se pulsa el boton de cambiar color aparecen las diferentes opciones de colores, cuando se vuelve a pulsar se cierra, el dropMenuItem se encarga de que aparezcan los colores y que al pulsar sobre el se llame a la funcion que recoge el color seleccionado

DonutChart:
Tiene la funcion DrawDonutChart con los valores que recibe al introducir el valor el usuario y una lista de colores, se crea un canvas con las proporciones de la grafica, luego se encarga de determinar cuanto ocupa cada valor y el tamaño del circulo interior

HalfCircleChart:
es igual que donutChart pero varia el angulo inicial que en vez de 360 grados es 180 grados

LineChart:


PieChart:


SegundaActividad:
