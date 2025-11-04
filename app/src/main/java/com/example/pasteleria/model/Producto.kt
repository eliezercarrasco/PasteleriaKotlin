package com.example.pasteleria.model

import androidx.annotation.DrawableRes

data class Producto(
    val nombre: String,
    val precio: Int,
    var cantidad: Int = 1,
    @DrawableRes val imagen: Int

)