## App Geometría

- Fecha de entrega: November 10, 2021
- [Consigna Drive](https://docs.google.com/document/d/16QhDiEd8zZwztzrlzCJk57eg8UuqCTuNmFJiSBB6bI0/edit?usp=sharing)
- **[UML](https://drive.google.com/file/d/1JiV_bXJT99jo4M-Ij9N8cr0fDx_czt76/view?usp=sharing)**
- **[DatasetConExceptions.zip](https://drive.google.com/file/d/1W6hgHdpZUtAux7KwPnuf36UpckJd_08N/view?usp=sharing)**
- **[Github](https://github.com/MarianaM02/poo1-tpo-grupal-teoth)**

### Enunciado

Implementar un módulo para una aplicación de geometría plana. Nos piden que modelemos la clase *Figura* y además, como especializaciones de Figura, las clases Elipse, Círculo, Triángulo, Rectángulo y Cuadrado.

Cabe la aclaración que cada figura tiene sus características puntuales, a saber:

- Las **elipses** deben almacenar el centro (es un Punto) y la medida de los radios.
- Los **rectángulos** deben almacenar el **punto** de la esquina inferior izquierda y el **punto** de la esquina superior derecha.
- Los **triángulos** deben almacenar los tres vértices.
- Los **círculos son elipses** donde **ambos radios deben ser iguales** y los **cuadrados son rectángulos** donde **base y altura deben medir lo mismo**
- Los **cuadrados** deben almacenar su lado y el punto de la esquina inferior izquierda.
- Los **círculos** deben almacenar su radio y su centro.

También es necesario implementar la clase Segmento. Cada segmento está determinado por sus dos puntos extremos.

Las **figuras, los puntos y los segmentos** se deben poder desplazar tanto en el eje x como en el eje y.

Es posible comparar una **figura** con otra teniendo en cuenta su **área**, y un **segmento** con otro tomando en cuenta su **longitud**.

Se pide además que, dado un **segmento**, se pueda saber si es paralelo al eje x, si es paralelo al eje y,  y si dos segmentos son paralelos entre sí. En el caso de los **triángulos**, se debe poder responder si alguno de sus lados es paralelo a alguno de los ejes.

*Hacer diagrama UML con todas las clases interfaces y relaciones que describen su modelo de objetos.*

### Casos de prueba

Dispondremos de un archivo con muchas figuras y segmentos. En este caso, nos piden que a partir de ese archivo, generemos otro archivo `paralelos.out` con todos los segmentos y triángulos que son paralelos a alguno de los ejes y otro archivo `grandotes.out` donde registremos la figura (o figuras) más grande y el segmento (o segmentos) más largo.

También nos piden un archivo denominado `figuras.out`, que deberá contener un listado de todas las figuras.

La aplicación además deberá implementar un **adecuado manejo de excepciones**; las mismas se adjuntan en el enlace de descarga. En cada excepción se puede encontrar la situación ante la que la misma deberá lanzarse.

**Se deben implementar todos los Test Unitarios que comprueben el 100% de la funcionalidad de la App.**
