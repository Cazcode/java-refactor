# 📌 Proyecto “Refactor”

## 📖 Refactorización del SongProcessor
Este proyecto tiene como objetivo mejorar y refactorizar la clase SongProcessor para seguir mejores prácticas de desarrollo, principios SOLID, patrones de diseno

Este proyecto se divide en 2 objetivos:
1.  Resolver bugfix, identificar malas practicas y refactorizacion con buenas practicas e implementar un rediseno para implementar multiples servicios con la version de java 1.8.

2.  Una vez refactorizado, crear un nuevo branch implementando las mejoras de las versiones mas recientes de java.


# Parte 1
 **Bugfix**

# Documentación de Bugfixes

Este documento describe los errores encontrados durante la ejecución del proyecto, las soluciones implementadas y los pasos necesarios para replicar los arreglos.

## Tabla de Contenidos
- [Resumen](#resumen)
- [Bugfixes](#bugfixes)
    - [Bug 1: Error de No Main Attribute](#bug-1-error-de-no-main-attribute)
    - [Bug 2: Excepción de NoClassDefFoundError al ejecutar el proyecto](#bug-2-excepción-de-noclassdeffounderror-al-ejecutar-el-proyecto)
    - [Bug 3: Excepción de FileNotFoundException al ejecutar el proyecto](#bug-3-excepción-de-filenotfoundexception-al-ejecutar-el-proyecto)
- [Malas Prácticas y Violaciones a Principios de Diseño de Software](#malas-prácticas-y-violaciones-a-principios-de-diseño-de-software)
    - [Pilares POO](#pilares-poo)
    - [Violación al Principio SOLID](#violación-al-principio-solid)
- [Patrones De Diseño](#patrones-de-diseño)
- [Refactorizacion](#refactorizacion)
  - [Refactorizacion](#refactorizacion-parte-1)
  - [Refactorizacion](#refactorizacion-parte-2)

---

## Resumen

Al ser un proyecto basado en Maven se utilizan los comandos comunes para instalar, actualizar las dependencias además del empaquetado (.jar/.war) y su respectiva ejecucion con los comandos de java jar, esto con el fin de no depender de ningun IDE para la ejecucion y aegurando que su correcta eejcuion sea replicada en cualquier sistema.


---

## Bugfixes

### Bug 1: Error de No Main Attribute

**Descripción**:
Se ejecuta los comandos de maven clean, install y compile. Dando como resultado el empaquetado(.jar) del proyecto.
Al ejecutar el comando `java -jar .\master-interview-1.0-SNAPSHOT.jar`, se presenta un error.

**Mensaje de Error**:  
`no main manifest attribute, in .\master-interview-1.0-SNAPSHOT.jar`

**Causa**:  
El error se origina por la falta de definicion de una clase main que sea reconocida por maven en el archivo `MANIFEST.MF`.

**Solución**:
- Se agrega el plugin de compilacion de maven `maven-compiler-plugin`.
- Se agrega el plugin de maven `maven-jar-plugin` en el cual se define una clase main.

**Resultado**:  
La aplicación no presenta el error.

---

### Bug 2: Excepción de NoClassDefFoundError al ejecutar el proyecto

**Descripción**:
Se ejecuta los comandos de maven clean, install y compile. Dando como resultado el empaquetado(.jar) del proyecto.
Al ejecutar el comando `java -jar .\master-interview-1.0-SNAPSHOT.jar`, se presenta un error de tipo `NoClassDefFoundError`.

**Mensaje de Error**:  
`java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory at com.example.refactor.service.SongProcessor.<clinit>(SongProcessor.java:15)`

**Causa**:  
El problema ocurrió porque el empaquetado no accede a las dependencias en este caso la libreria de `logback-classic`


**Solución**:
- Se añadió el plugin `maven-shade-plugin` para generar un fat jar, el cual incluya las dependencias necesarias para la ejecución del proyecto.
- Se ejecutan los respectivos comandos de maven

**Resultado**:  
La aplicación no presenta el error.

---

### Bug 3: Excepción de FileNotFoundException al ejecutar el proyecto

**Descripción**:
Se ejecuta los comandos de maven clean, install y compile. Dando como resultado el empaquetado(.jar) del proyecto.
Al ejecutar el comando `java -jar .\master-interview-1.0-SNAPSHOT.jar`, se presenta un error de tipo `FileNotFoundException`.

**Mensaje de Error**:  
`java.io.FileNotFoundException: file:\<ubicacion-local>\java-refactor\target\master-interview-1.0-SNAPSHOT.jar!\playlist.json (The filename, directory name, or volume label syntax is incorrect)
        at java.base/java.io.FileInputStream.open0(Native Method)
        at java.base/java.io.FileInputStream.open(FileInputStream.java:213)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:152)
        at java.base/java.io.FileReader.<init>(FileReader.java:75)
        at com.example.refactor.service.ExampleFileUtils.getJsonFromFile(ExampleFileUtils.java:18)
        at com.example.refactor.service.SongProcessor.processSongs(SongProcessor.java:21)
        at com.example.refactor.Solution.main(Solution.java:8)
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.json.simple.JSONObject.get(Object)" because "playlist" is null
        at com.example.refactor.service.SongProcessor.processSongs(SongProcessor.java:24)
        at com.example.refactor.Solution.main(Solution.java:8)
`

**Causa**:  
El problema ocurrió porque al ejecutar el programa este encuentra que el archivo input `playlist` es null.


**Solución**:
- Implementacion de InputStream para leer archivos como bytes desde el JAR.
- Implementacion de un método de prueba `getJsonFromFileName` en la clase `ExampleFileUtils` para verificar la obtencion el recurso desde el JAR.

**Resultado**:  
La aplicación realiza un print logger con los datos de SongId, SongName, ArtistName, AlbumName del listado encontrado.
`22:51:39.770 [main] INFO com.example.refactor.service.SongProcessor -  - 7kyK2NSDfRE1612vdYuqIx - Javier El De Los Llanos - Calibre 50 - Corridos De Alto Calibre`


---


## Malas Prácticas y Violaciones a Principios de Diseño de Software

### Pilares POO

**Descripción**:  
El no implementa algunos principios de POO
1. **Abstraccion** se identifica que en la clase `SongProcessor` se puede aplicar abstaccion de una nueva clase de clase `Album`
2. **Herencia** al tener varios atributos compartidos entre clases se peude crear una `BaseDomain` como clase padre.
3. **Encapsulacion** se identifica que en la clase `SongProcessor` existe un atributo el cual es público
4. **Polimorfismo** existen casos en los cuales se puede compartir un comportamiento entre clases y metodos.

**Solución**:
- Se refactoriza el código para mejorar la estructura y la reutilización.
- Se introdujo una nueva clase `Album` para encapsular la lógica relacionada con los albumnes, implementando la abstracción.
- Se creó una clase padre `BaseDomain` para aplicar herencia y reutilizar métodos comunes entre las clases hijas.
- Se refactoriza el acceso a los atributos de la clase `Song`, cambiando el atributo `spotifyArtist` de público a privado y proporcionando un getter y setter para acceder a él.

**Resultado**:  
Codigo que implementa los principios POO 

---

### Violación al Principio SOLID

**Descripción**:  
El código viola varios principio como:
1. Principio de **Responsabilidad Única** (SRP) al tener cargar la clase `SongProcessor` con múltiples responsabilidades. 
Por tanto, la clase es demasiado compleja y difícil de mantener.
2. Principio de **Open/Closed**  (OCP) las calses estan disenadas de tal forma que no permite su extension sin la modificacion de clases, cualquier nueva funcionalidad implica un cambio que peude generar errores y dificil codififacion.
3. Principio de **Liskov substitution** (LSP) y **Interface Segregation**  (ISP) no exise el uso de interfaces, no existe abstraccion que separe las responsabilidad y funcionalidades.
4. Principio de **Dependency Inversion** (DIP) la instanciacion de las clases se hace de manera directa y dependiente en las clases que usan las funcioanlidades de calses externas.  


**Ejemplo**:  
En la clase `SongProcessor`, se encuentra el método de procesamiento de Song, pero también:
- La trasnformacion del contenido del archivo en un objeto Json.
- La lógica de obtencion de datos del json trasnformado.
- La lógica de la trasnformacion de datos a objetos especificos

**Solución**:
Aplicando principios SOLID refactorizar la clase permitiendo que la clase solo tenga una sola responsabilidad.


**Resultado**:  
El código ahora es más modular, más fácil de mantener y las clases tienen responsabilidades claras y bien definidas.

---

### Patrones de diseño
**Descripción**:  
Los patrones de diseno aplicados son los patrones de creacion y comport
1. **Factory Method**,
2. **Strategy**,

**Solución**:
- Se agrega la familia de servicios de streaming permitiendo el uso de interfaces, lo cual soluciona uno de los puntos en los lineamientos del proyecto
- Se implementa **Factory Method** para las familias de servicios `MusicStreamingService` como clase padre
  - Se crea un enum `SERVICETYPE` para la definicion del tipo de servicio que se desea crear.
- Se implementa el **Strategy** para la creacion de la clase `Mapper` para lac reacion de genericos que permitan facilitar el mapeo de objetos y sean intercambiables facilmente.
- Se implementa **inyeccion de dependecia** removiendo la responsabilidad de instanciar objetos en las respectivas clases.

**Resultado**:  
El código ahora es más modular, más fácil de mantener y las clases tienen responsabilidades claras y bien definidas.

---

### Refactorizacion

### Refactorizacion parte 1 
En la refactorizacion del programa se implementa la version 1.8 de java ademas de algunas funcionalidades:

1. **Stream API**,
2. **Generics**,
3. **Programacion funcional**,
4. **Collections**,
5. **Interfaces**,
6. **Java I/O**

**Solución**:
- Se modifica el método `getJsonFromFileName` en la clase `ExampleFileUtils` para separar las responsabilidades de obtencion del recurso y mappeo a un objeto Json y ahora solo mapea el objeto.
- Se crea el método `getStringJsonFromFile` en la clase `ExampleFileUtils` para la obtencion del recurso y lo retorna como un String Json.
- Se implementa **Stream API** en la clase `SongProcessor` asi como en `Solution`
---

### Refactorizacion parte 2
En la parte 2 del refactor se realiza las siguientes acciones:
1. Migracion de la version java 8 a la version java 23.
2. Se actualizan los pluguisn de maven:
   1. maven-compiler-plugin de la version 3.8.1 a la version 3.10.1
   2. maven-jar-plugin de la version 3.2.0 a la version 3.10.1
   3. maven-shade-plugin se modifica la configuracion.

En la clase mapper ArtitsMapper se crea nueva funcion para obtener un listado de Artist


1. **var**,
2. **switch expression**,
3. **Programacion funcional**,
4. **Collections**,
5. **Interfaces**,
6. **Pattern Matching**
7. **Stream API**
---
