package com.example.pasteleria.model

fun calcularBeneficios(edad: Int, correo: String, codigo: String): Pair<Int, List<String>> {
    var descuento = 0
    val beneficios = mutableListOf<String>()

    if (edad >= 50) {
        descuento = 50
        beneficios.add("50% de descuento por ser mayor de 50 años")
    }

    if (codigo.trim().uppercase() == "FELICES50") {
        descuento = maxOf(descuento, 10)
        beneficios.add("10% de descuento de por vida (FELICES50)")
    }

    if (correo.lowercase().endsWith("@duoc.cl")) {
        beneficios.add("Torta gratis en tu cumpleaños (correo DUOC)")
    }

    return Pair(descuento, beneficios)
}
