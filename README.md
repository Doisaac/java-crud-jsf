<a name="readme-top"></a>

# 📘 Guía de Inicialización del Proyecto Java CRUD con JSF

## 🛠️ Requisitos Previos
- **NetBeans** (versión recomendada: 12.5 o superior)
- **Payara Server** (versión: 6.2023.10)
- **PostgreSQL JDBC Driver** (versión: 42.6.0)
- **Java Development Kit (JDK)** (versión recomendada: 11 o superior)

## 📝 Pasos para Inicializar el Proyecto

### 1. 📂 Abrir el Proyecto en NetBeans
1. Abrir NetBeans.
2. Navegar a `File > Open Project`.
3. Seleccionar el proyecto y abrirlo.

### 2. 🌐 Crear un Servidor Payara
1. Ir a la pestaña de `Servicios`.
2. Seleccionar `Servers`.
3. Hacer clic en `Add Server`.
4. Seleccionar `Payara`.
5. Seleccionar la versión del servidor: `6.2023.10`.
6. Descargar y finalizar la configuración.

### 3. 🔧 Instalar PostgreSQL JDBC Driver
1. Descargar el archivo `postgresql-42.6.0.jar` desde el [sitio oficial](https://jdbc.postgresql.org/download/).
2. Almacenar el archivo en la ruta: `C:/Usuarios/[usuario]/servers/glassfish/domains/domain1/lib`.

### 4. 🖥️ Ejecutar el Servidor Payara
1. Iniciar el servidor Payara desde NetBeans.
2. Verificar el funcionamiento en `http://localhost:8080`.
3. Acceder al panel de control en `http://localhost:4848`.

### 5. 🗄️ Configurar el Pool de Conexiones JDBC
1. En el panel de control de Payara, navegar a `JDBC > JDBC Connection Pools`.
2. Agregar un nuevo pool con los siguientes detalles:
   - **Nombre**: `PoolWebApp`
   - **Resource Type**: `javax.sql.DataSource`
   - **Database Driver Vendor**: `Postgresql`
3. Agregar las siguientes propiedades:
   - **user**: `doisdb_owner`
   - **password**: `eXBkm8oxa0AL`
   - **serverName**: `ep-yellow-flower-a553c7ip-pooler.us-east-2.aws.neon.tech`
   - **databaseName**: `doisdb`
   - **useSSL**: `false`
4. Hacer un ping para validar la configuración.

### 6. 🌐 Crear el Recurso JDBC
1. En el panel de control de Payara, navegar a `JDBC > JDBC Resources`.
2. Agregar un nuevo recurso con los siguientes detalles:
   - **JNDI Name**: `jdbc/webApp`
   - **Pool Name**: `PoolWebApp`

### 7. 🔄 Reiniciar el Servidor Payara
1. En NetBeans, ir al servidor Payara.
2. Reiniciar el servidor.

### 8. 🧹  Limpiar, Compilar y Ejecutar el Proyecto
1. En NetBeans, seleccionar el proyecto.
2. Hacer clic en `Clean and Build`.
3. Hacer clic en `Run`.

### 9. 👁️ Verificar la Aplicación
1. Acceder a la aplicación en `http://localhost:8080/appweb`.
   

# 📘 Operaciones CRUD con Thunder Client

Antes de todo, asegúrate de tener instalado Thunder Client en Visual Studio Code y de que tu servidor esté en funcionamiento

## 📝 Operaciones CRUD

### 1. 📋 Obtener Alumnos (GET)
1. Abre Thunder Client en Visual Studio Code.
2. Haz clic en `New Request`.
3. Selecciona el método `GET`.
4. Ingresa la URL: `http://localhost:8080/appweb/api/alumnos`.
5. Haz clic en `Send`.

### 2. ➕ Agregar un Alumno (POST)
1. Abre Thunder Client en Visual Studio Code.
2. Haz clic en `New Request`.
3. Selecciona el método `POST`.
4. Ingresa la URL: `http://localhost:8080/appweb/api/alumnos`.
5. Ve a la pestaña `Body` y selecciona `JSON`.
6. Ingresa los datos del nuevo alumno en formato JSON, por ejemplo:
    ```json
    {
        "nombre": "Douglas Barrera",
        "carnet": "BM22025"
    }
    ```
7. Haz clic en `Send`.

### 3. 📝 Actualizar Información de un Alumno (PUT)
1. Abre Thunder Client en Visual Studio Code.
2. Haz clic en `New Request`.
3. Selecciona el método `PUT`.
4. Ingresa la URL: `http://localhost:8080/appweb/api/alumnos`
5. Ve a la pestaña `Body` y selecciona `JSON`.
6. Ingresa los datos actualizados del alumno en formato JSON, por ejemplo:
    ```json
    {
        "id": 1,
        "nombre": "Douglas Barrera",
        "carnet": "BM22026"
    }
    ```
7. Haz clic en `Send`.

### 4. ❌ Eliminar un Alumno (DELETE)
1. Abre Thunder Client en Visual Studio Code.
2. Haz clic en `New Request`.
3. Selecciona el método `DELETE`.
4. Ingresa la URL: `http://localhost:8080/appweb/api/alumnos/{id}` (reemplaza `{id}` con el ID del alumno que deseas eliminar).
5. Haz clic en `Send`.

> [!NOTE]  
> De manera similar, realiza las operaciones CRUD para las rutas de `materias` e `inscripciones` utilizando los mismos pasos detallados anteriormente, cambiando los datos según lo necesario.

## 📌 Notas
- Asegúrate de tener todos los componentes necesarios instalados y configurados correctamente.
- Si encuentras algún problema durante el proceso, revisa los logs del servidor para más detalles.


**¡Colaboradores que han hecho posible este proyecto!**

![Contributors](https://contrib.rocks/image?repo=Doisaac/java-crud-jsf)
 
<p align="right">(<a href="#readme-top">volver arriba</a>)</p>
