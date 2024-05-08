https://github.com/josejc05/CasoFinalDeLosFinalesIntegrador.git

Ejercicio 1:
1.	b
2.	b
3.	b
4.	a
5.	b

Ejercicio 2:
1.  c
2.  Tabla Hash:

Utiliza una función hash para mapear claves a valores.
Ofrece acceso rápido a los datos.
Bueno para aplicaciones con distribución uniforme de claves y necesidad de operaciones rápidas de búsqueda, inserción y eliminación.
Árbol:

Estructura jerárquica de nodos conectados.
Mantiene los datos ordenados.
Útil para operaciones eficientes de búsqueda, inserción y eliminación en conjuntos de datos grandes, especialmente cuando se necesita recorrer los datos en orden.
Cuándo usar cada uno:

Tabla Hash: Para acceso rápido y distribución uniforme de claves.
Árbol: Para mantener datos ordenados y operaciones eficientes en grandes conjuntos de datos, especialmente cuando se necesita recorrer los datos en orden.

3.  Pila:

Sigue el principio de "último en entrar, primero en salir" (LIFO).
Utilizada cuando se necesita procesar elementos en orden inverso al que fueron agregados.
Operaciones principales: Push (agregar) y Pop (eliminar).
Orden de complejidad computacional: O(1) para inserción y eliminación en promedio.
Cola:

Sigue el principio de "primero en entrar, primero en salir" (FIFO).
Utilizada cuando se necesita procesar elementos en el mismo orden en que fueron agregados.
Operaciones principales: Enqueue (agregar) y Dequeue (eliminar).
Orden de complejidad computacional: O(1) para inserción y eliminación en promedio.
Cuándo usar cada una:

Pila: Para procesar elementos en orden inverso al que fueron agregados.
Cola: Para procesar elementos en el mismo orden en que fueron agregados, como en gestión de tareas o procesamiento de datos en cola de espera.

4.  El método de ordenación por inserción funciona comparando elementos y colocándolos en su posición correcta uno por uno.

Iteraciones sobre el conjunto de datos:

Se inicia con el segundo elemento (20), se compara con el primero (50) y se intercambian si es necesario.
Se avanza al tercer elemento (84) y se compara con los anteriores, sin cambios.
Se sigue avanzando, comparando y moviendo elementos según sea necesario hasta que todos estén ordenados.

5. A partir de valores mayores o iguales a n=8, A es más eficiente que B.

Ejercicio 3:

a)  El código proporcionado ahora compilará correctamente. La función recursive está diseñada para calcular el resultado de la multiplicación de a por sí mismo b veces. Estos son algunos ejemplos de casos específicos:

Si b es igual a 0, la función devuelve 1.
Si a es igual a 0, la función devuelve 0.
De lo contrario, la función realiza la multiplicación a * recursive(a, b - 1).

b)  El cálculo que realiza esta función es una especie de exponenciación. Si a es la base y b es el exponente, entonces recursive(a, b) es equivalente a a^b.

Por ejemplo:
recursive(2, 3) devolverá 8 (2^3).
recursive(3, 4) devolverá 81 (3^4).

Ejercicio 4:

El tipo de recursividad que se está utilizando aquí es la recursividad lineal.  
La complejidad computacional de este algoritmo es O(n), donde n es el número de dígitos en el número. Esto se debe a que se está realizando una única operación (suma) para cada dígito en el número. El número de operaciones escala linealmente con el tamaño de la entrada, de ahí la complejidad de tiempo lineal.
(el código está en el archivo .java dentro del zip)

Ejercicio 5:

2.d) · No es necesario modificar los atributos timeline y tweets de la clase UserAccount para que contengan elementos de la clase hija Retweet. Esto se debe a que Retweet es una subclase de Tweet, por lo que un Retweet es un Tweet. En Java, una lista de una superclase puede contener objetos de cualquier subclase. Por lo tanto, una List<Tweet> puede contener objetos Tweet, Retweet y DirectMessage.  
· No es necesario modificar el método tweet(Tweet tweet1) de la clase UserAccount para que pueda enviar también objetos de tipo Retweet. Esto se debe a que Retweet es una subclase de Tweet, por lo que un Retweet es un Tweet. En Java, un método que acepta un objeto de una superclase también puede aceptar objetos de cualquier subclase. Por lo tanto, un método que acepta un Tweet también puede aceptar un Retweet y un DirectMessage.

