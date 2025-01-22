# Conversor de Monedas

## Descripción

Conversor de Monedas es una aplicación desarrollada en Java que permite a los usuarios convertir cantidades de dinero entre diferentes monedas utilizando tasas de cambio actualizadas.

## Características

- Conversión de monedas en tiempo real
- Historial de conversiones
- Soporte para múltiples monedas

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- `src/ApiCliente.java`: Contiene la lógica para realizar solicitudes a la API de tasas de cambio y convertir monedas.
- `src/Historial.java`: Maneja el historial de conversiones, permitiendo agregar, mostrar, guardar y cargar registros.
- `src/Main.java`: Punto de entrada de la aplicación, maneja la interacción con el usuario.
- `src/NombreMoneda.java`: Proporciona un mapeo entre códigos de monedas y sus nombres.
- `src/TipoCambio.java`: Modelo de datos para las tasas de cambio obtenidas de la API.

## Requisitos

- Java 17 o superior
- Biblioteca Gson para el manejo de JSON

## Recursos Adicionales

- [Documentación de Java](https://docs.oracle.com/en/java/)
- [Documentación de Gson](https://github.com/google/gson)
- [API de tasas de cambio](https://www.exchangerate-api.com/)