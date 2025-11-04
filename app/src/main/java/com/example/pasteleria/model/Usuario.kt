package com.example.pasteleria.model

data class Usuario(
    val nombre: String,
    val correo: String,
    val password: String,
    val telefono: String? = null,
    val direccion: String,
    val edad: Int,
    val descuento: Int = 0,
    val beneficios: List<String> = emptyList(),
    val fechaRegistro: String
)