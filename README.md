# Pasteleria (Android Compose)

## Descripción general del proyecto

Aplicación Android (Kotlin + Jetpack Compose) llamada **Pasteleria**. Es una pequeña app de demostración para una pastelería que contiene una pantalla de inicio con descripción y portada, una pantalla de detalle de productos (lista de tortas/pasteles con precios y descripción) y una pantalla de registro de usuarios que valida datos y calcula beneficios/descuentos según reglas simples. Está estructurada como una app Compose moderna con navegación interna, temas y recursos (imágenes de productos).

Este proyecto fue realizado por: **Eliezer Obed Carrasco Lobos** y **Maria Jose Velazquez Gatica**

## Tecnologías utilizadas
- Kotlin
- Jetpack Compose
- Gradle Kotlin DSL
- Android SDK 24+
- Navegación con Jetpack Navigation

## Funcionalidades principales
- **Pantalla Inicio**: muestra información de la pastelería, portada e introducción.
- **Pantalla Detalle**: lista de productos (pasteles, tortas) con precios e imágenes.
- **Pantalla Registro**: formulario de registro con validaciones y cálculo de beneficios o descuentos según edad, correo o código promocional.
- **Lógica de negocio**: se calcula el beneficio según reglas como edad mayor a 50 años (50% descuento), código “FELICES50” (10%) o correo institucional “@duoc.cl” (beneficio especial).

## Estructura del proyecto
```
app/
 ├── src/main/java/com/example/pasteleria/
 │   ├── model/               # Modelos de dominio (Producto, Usuario, etc.)
 │   ├── screens/             # Pantallas principales (Inicio, Detalle, Registro)
 │   ├── navegation/          # Archivo AppNavigation con rutas Compose
 │   ├── MainActivity.kt      # Punto de entrada de la app
 ├── src/main/res/            # Imágenes, íconos y recursos visuales
 ├── build.gradle.kts         # Configuración Gradle del módulo
 ├── settings.gradle.kts      # Configuración del proyecto
```

## Pasos para ejecutar el proyecto

### Requisitos previos
- Android Studio (versión Flamingo o superior)
- SDK Android 36 instalado
- JDK 11 o superior

### Instrucciones
1. Abrir Android Studio → **File > Open** → seleccionar la carpeta `Pasteleria`.
2. Esperar la sincronización de Gradle e instalar dependencias necesarias.
3. Ejecutar la aplicación en un emulador o dispositivo Android.
4. Actividad principal: `MainActivity.kt`

### Alternativa por consola
```bash
./gradlew assembleDebug
./gradlew installDebug
```

## Notas
- La ruta `login` no está definida en la navegación actual. Se recomienda cambiar `navController.navigate("login")` por `navController.navigate("inicio")`.
- El proyecto no guarda datos de usuario de forma persistente (demo local).

## Autor
**Eliezer Obed Carrasco Lobos**

**Maria Jose Velazquez Gatica**

