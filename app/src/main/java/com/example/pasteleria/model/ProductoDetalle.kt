package com.example.pasteleria.model

import androidx.annotation.DrawableRes
data class ProductoDetalle(
    val nombre: String,
    val precio: Int,
    val descripcion: String,
    @DrawableRes val imagen: Int
)