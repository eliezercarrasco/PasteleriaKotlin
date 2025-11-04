package com.example.pasteleria.model;

data class Usuario {
    val nombre: String,
    val correo: String,
    val password: String,
    val telefono: String?,
    val direccion: String,
    val edad: Int,
    val descuento: Int,
    val beneficios: List<String>,
    val fechaRegistro: String
)

