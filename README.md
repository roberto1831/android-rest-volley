# 📱 Android REST API Client – Ejercicio RT2

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![Volley](https://img.shields.io/badge/Volley-HTTP-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Material Design](https://img.shields.io/badge/Material_Design-757575?style=for-the-badge&logo=materialdesign&logoColor=white)

> Aplicación Android en **Java** que implementa operaciones **CRUD completas** contra una API REST usando la librería **Volley**, consumiendo el servicio de prueba JSONPlaceholder.

---

## 🎯 Objetivo

Demostrar el consumo de una API REST desde Android implementando los cuatro métodos HTTP principales:

| Método | Operación | Endpoint |
|---|---|---|
| `GET` | Obtener datos | `/posts/1` |
| `POST` | Crear registro | `/posts` |
| `PUT` | Actualizar registro | `/posts/1` |
| `DELETE` | Eliminar registro | `/posts/1` |

**API utilizada:** [JSONPlaceholder](https://jsonplaceholder.typicode.com) — API REST de prueba gratuita.

---

## 🏗️ Arquitectura

```
MainActivity.java
     │
     ├── obtenerRest()    → GET  /posts/1
     ├── crearRest()      → POST /posts
     ├── actualizarRest() → PUT  /posts/1
     └── eliminarRest()   → DELETE /posts/1
           │
           ▼
    Volley RequestQueue
           │
           ▼
  JSONPlaceholder API
  jsonplaceholder.typicode.com
```

---

## 📁 Estructura del Proyecto

```
Ejercicio_rt2/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/ejercicio_rt2/
│           │   └── MainActivity.java      # Lógica principal + llamadas REST
│           ├── res/
│           │   ├── layout/                # XMLs de interfaz
│           │   └── mipmap-*/              # Íconos en múltiples densidades
│           └── AndroidManifest.xml
├── gradle/
│   └── libs.versions.toml                 # Catálogo de versiones
└── build.gradle.kts
```

---

## 🛠️ Tecnologías y Dependencias

| Tecnología | Versión | Uso |
|---|---|---|
| Android Gradle Plugin | 8.7.2 | Build system |
| Java | 8+ | Lenguaje principal |
| Volley | 1.2.0 | Peticiones HTTP |
| AppCompat | 1.7.0 | Compatibilidad |
| Material Design | 1.12.0 | Componentes UI |
| ConstraintLayout | 2.2.0 | Layouts responsive |
| JUnit | 4.13.2 | Pruebas unitarias |
| Espresso | 3.6.1 | Pruebas de UI |

---

## 📨 Ejemplos de Uso

### GET – Obtener post
```java
String url = "https://jsonplaceholder.typicode.com/posts/1";
JsonObjectRequest getRequest = new JsonObjectRequest(
    Request.Method.GET, url, null,
    response -> Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show(),
    error -> Log.e("Error", error.getMessage())
);
Volley.newRequestQueue(this).add(getRequest);
```

### POST – Crear post
```json
{
  "title": "Mi título",
  "body": "Contenido del post",
  "userid": "1"
}
```

### PUT – Actualizar post
```json
{
  "title": "Título actualizado",
  "body": "Nuevo contenido",
  "userid": "1"
}
```

### DELETE – Eliminar post
```
DELETE https://jsonplaceholder.typicode.com/posts/1
→ Respuesta: {} (objeto vacío)
```

---

## ⚙️ Requisitos

- Android Studio Hedgehog o superior
- JDK 8+
- Dispositivo físico o emulador (API 21+)
- Conexión a internet

---

## 🚀 Instalación y Ejecución

### Opción 1: Desde Android Studio

```bash
# 1. Clonar el repositorio
git clone https://github.com/roberto1831/android-rest-volley.git
cd android-rest-volley

# 2. Abrir en Android Studio
# File → Open → seleccionar carpeta del proyecto

# 3. Sincronizar Gradle
# Tools → Gradle → Sync Project with Gradle Files

# 4. Ejecutar
# Run → Run 'app' (Shift + F10)
```

### Opción 2: Instalar APK directamente

El APK de debug está disponible en:
```
app/build/outputs/apk/debug/app-debug.apk
```

---

## 🧪 Pruebas

```bash
# Pruebas unitarias
./gradlew test

# Pruebas de instrumentación (requiere dispositivo/emulador)
./gradlew connectedAndroidTest
```

---

## 👤 Autor

**Ing. Roberto Toapanta**  
📍 Quito, Ecuador  
🔗 [GitHub](https://github.com/roberto1831) · [LinkedIn](https://linkedin.com/in/roberto1831)

---

## 📄 Licencia

Uso académico / demostrativo.
