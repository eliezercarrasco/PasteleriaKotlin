package com.example.pasteleria.screens

import com.example.pasteleria.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pasteleria.components.Navbar
import com.example.pasteleria.components.h1Style
import com.example.pasteleria.components.pStyle
import com.example.pasteleria.model.ProductoDetalle
import java.text.NumberFormat
import java.util.*

@Composable
fun DetalleScreen(navController: NavController, modifier: Modifier = Modifier) {
    val productos = listOf(
        ProductoDetalle(
            "Torta Cuadrada de Chocolate", 45000,
            "Deliciosa torta de chocolate con capas de ganache y un toque de avellanas. Personalizable con mensajes especiales.",
            R.drawable.tc001
        ),
        ProductoDetalle(
            "Torta Cuadrada de Frutas", 50000,
            "Una mezcla de frutas frescas y crema chantilly sobre un suave bizcocho de vainilla, ideal para celebraciones.",
            R.drawable.tc002
        ),
        ProductoDetalle(
            "Torta Circular de Vainilla", 40000,
            "Bizcocho de vainilla clásico relleno con crema pastelera y cubierto con un glaseado dulce, perfecto para cualquier ocasión.",
            R.drawable.tt001
        ),
        ProductoDetalle(
            "Torta Circular de Manjar", 42000,
            "Torta tradicional chilena con manjar y nueces, un deleite para los amantes de los sabores dulces y clásicos.",
            R.drawable.tt002
        ),
        ProductoDetalle(
            "Mousse de Chocolate", 5000,
            "Postre individual cremoso y suave, hecho con chocolate de alta calidad, ideal para los amantes del chocolate.",
            R.drawable.pi001
        ),
        ProductoDetalle(
            "Tiramisú Clásico", 5500,
            "Un postre italiano individual con capas de café, mascarpone y cacao, perfecto para finalizar cualquier comida.",
            R.drawable.pi002
        )
    )

    Column(modifier = modifier.fillMaxSize()) {
        Navbar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.portada),
                contentDescription = "Logo Pastelería",
                modifier = Modifier
                    .size(200.dp)
                    .padding(vertical = 16.dp)
            )

            Text(text = "DETALLES DE PRODUCTOS", style = h1Style)
            Spacer(modifier = Modifier.height(16.dp))

            productos.forEach { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = producto.nombre,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = producto.nombre,
                            style = pStyle.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                        )
                        Text(
                            text = NumberFormat.getCurrencyInstance(Locale("es", "CL")).format(producto.precio),
                            style = pStyle.copy(color = MaterialTheme.colorScheme.secondary)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = producto.descripcion, style = pStyle)
                    }
                }
            }
        }
    }
}