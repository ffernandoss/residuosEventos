Link al repositorio: https://github.com/ffernandoss/residuosEventos.git


---

# Página 1 - Pantalla de Inicio

**Autor: Arturo López**

Es el inicio del programa y está conformado por dos clases: `Principio` y `Slash`.

- **Clase `Slash`**: Muestra una imagen de carga al usuario mientras se inicializa el programa.
- **Clase `Principio`**: Pantalla de bienvenida que contiene un mensaje al usuario y un botón que, al ser pulsado, te envía a la siguiente página.

---

# Página 2 - Calendario

**Autor: Rodrigo Pérez**

La página de calendario consiste en la clase `Calendario`, la cual muestra:

- Un calendario con la programación de recogida de residuos.
- Un botón que te lleva a la siguiente página.

---

# Página 3 - Mapa

**Autor: Roberto Quílez**

Utiliza **Jetpack Compose** para mostrar un mapa con los puntos de reciclaje de Madrid.

- **Importaciones**: Se importan las librerías necesarias de Jetpack Compose para trabajar con imágenes, modificadores y vistas previas.
  
- **Función `MapaReciclajeMadrid`**: Es una función composable que carga y muestra una imagen del mapa desde los recursos `drawable` del proyecto. La imagen se ajusta para llenar el contenedor disponible.
  
- **Función `MapaReciclajeMadridPreview`**: Permite visualizar cómo se verá el composable `MapaReciclajeMadrid` en el editor de diseño de Android Studio.

---

# Página 4 - Gráficas

**Autor: Fernando Santamaría**

Pantalla compuesta por varias clases para mostrar diferentes tipos de gráficos:

- **BarChart**: 
  - Contiene listas para los valores, colores y nombres del eje X, además de una variable para el nombre del eje Y.
  - Dibuja las barras y usa un `Canvas` para representar los ejes y los valores.
  
- **ColorPicker**: 
  - Contiene una función `colorPicker` que permite seleccionar el color para las gráficas mediante un menú desplegable.
  
- **HalfCircleChart**: 
  - Similar a `DonutChart`, pero con un ángulo inicial de 180 grados en lugar de 360.
  
- **LineChart**: 
  - Usa la función `DrawLineChart` que dibuja una gráfica de líneas con una lista de valores y un `Canvas`.
  
- **PieChart**: 
  - Usa la función `DrawPieChart` que dibuja una gráfica circular basada en los valores proporcionados.
  
- **DonutChart**: 
  - Similar a `PieChart`, pero con un agujero en el centro.

- **AreaChart**: 
  - Similar a `BarChart`, pero más ancho. Dibuja un área utilizando la función `DrawAreaChart`.

## SegundaActividad

Hereda de `ComponentActivity` y está compuesta por varias funciones para mostrar las gráficas:

- **BarChartScreen**: Contiene los `TextField` para introducir valores y botones para interactuar con las gráficas.
  
- **DropMenuButton**: Controla un menú desplegable para seleccionar diferentes tipos de gráficas.
  
- **BarChartScreen2**: Proporciona los nombres para el eje X y Y y llama a `DrawBarChart` sin mostrar los valores sobre la gráfica.
  
- **LineChartScreen**: Proporciona los nombres para los ejes y llama a `DrawLineChart`.
  
- **PieChartScreen**: Llama a `DrawPieChart`.

- **CircleChartScreen**: Llama a `DrawDonutChart`.

- **HalfCircleChartScreen**: Llama a `DrawHalfCircleChart`.

- **AreaChartScreen**: Proporciona los nombres para los ejes y llama a `DrawAreaChart`.



