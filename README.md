# Proyecto bancopreguntasweb

Plataforma web para la creacion de bancos de preguntas (opción múltiple)

## Requisitos mínimos

- MAVEN
- Java JDK o JSE < 1.8

## Ejecución del proyecto

### Intalación de las dependencias del proyecto

El siguiente comando de consola limpia el proyecto e instala las dependencias requeridas del proyecto, mediante el uso de maven.

```cmd
maven clean install
```

El comando anterior crea una carpeta llamada `target`, en la cual se localiza el archivo `.jar`.

### Ejecución del proyecto

Accedemos a la carpeta `target`.

```cmd
cd .\target\
```

Mediante el uso de Java ejecutamos el archivo `.jar`.

```cmd
java -jar .\bancopreguntasweb-0.0.1-SNAPSHOT.jar
```

Si la ejecución del proyecto es correcta, la terminal debe mostrar un mensaje parecido al siguiente:

```cmd
2021-08-05 22:19:55.537  INFO 9620 --- [nio-5000-exec-1] o.s.web.servlet.DispatcherServlet: Completed initialization in 2 ms
```

Este mensaje nos avisa que el proyecto se encuentra levantado y podemos acceder al mismo desde un navegador con la siguiente dirección web `http://localhost:5000`.

#### Nota

Las credenciales de acceso de administrador son las siguientes:

Usuario: admin
Password: admin