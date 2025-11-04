package com.example.pasteleria.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pasteleria.R
import com.example.pasteleria.components.Navbar
import com.example.pasteleria.components.h1Style
import com.example.pasteleria.components.pStyle
import com.example.pasteleria.model.Usuario
import com.example.pasteleria.utils.calcularBeneficios
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RegistroScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    var mostrarDialogo by remember { mutableStateOf(false) }

    fun handleRegister() {
        if (!nombre.matches(Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"))) {
            mensaje = "El nombre solo puede contener letras y espacios."
            mostrarDialogo = true
            return
        }
        if (password != confirmPassword) {
            mensaje = "Las contraseñas no coinciden."
            mostrarDialogo = true
            return
        }
        if (nombre.isBlank() || correo.isBlank() || direccion.isBlank() || password.isBlank()) {
            mensaje = "Todos los campos obligatorios deben completarse."
            mostrarDialogo = true
            return
        }

        val codigo = ""
        val (descuento, beneficios) = calcularBeneficios(edad.toIntOrNull() ?: 0, correo, codigo)

        val usuario = Usuario(
            nombre = nombre,
            correo = correo,
            password = password,
            telefono = if (telefono.isBlank()) null else telefono,
            direccion = direccion,
            edad = edad.toIntOrNull() ?: 0,
            descuento = descuento,
            beneficios = beneficios,
            fechaRegistro = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
        )

        mensaje = buildString {
            appendLine("Registro exitoso: ${usuario.nombre}")
            appendLine("Descuento aplicado: ${usuario.descuento}%")
            if (usuario.beneficios.isNotEmpty()) {
                appendLine("Beneficios:")
                usuario.beneficios.forEach { appendLine("- $it") }
            } else appendLine("Sin beneficios adicionales.")
        }

        mostrarDialogo = true

        nombre = ""
        correo = ""
        password = ""
        confirmPassword = ""
        telefono = ""
        direccion = ""
        edad = ""
    }

    Column(modifier = modifier.fillMaxSize()) {
        Navbar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.portada),
                contentDescription = "Logo Pastelería",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 32.dp, bottom = 16.dp)
            )

            Text(
                text = "Registro de Usuario",
                style = h1Style,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre Completo", style = pStyle) },
                        placeholder = { Text("Tu nombre", style = pStyle) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = correo,
                        onValueChange = { correo = it },
                        label = { Text("Correo Electrónico", style = pStyle) },
                        placeholder = { Text("ejemplo@correo.com", style = pStyle) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Contraseña", style = pStyle) },
                        placeholder = { Text("********", style = pStyle) },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirmar Contraseña", style = pStyle) },
                        placeholder = { Text("********", style = pStyle) },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = telefono,
                        onValueChange = { telefono = it },
                        label = { Text("Teléfono (opcional)", style = pStyle) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = direccion,
                        onValueChange = { direccion = it },
                        label = { Text("Dirección", style = pStyle) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        label = { Text("Edad", style = pStyle) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { handleRegister() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Text("Registrarse", color = MaterialTheme.colorScheme.onError, style = pStyle)
                    }
                }
            }

            if (mostrarDialogo) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogo = false },
                    confirmButton = {
                        TextButton(onClick = {
                            mostrarDialogo = false
                            if (mensaje.startsWith("✅")) navController.navigate("login")
                        }) {
                            Text("Aceptar", style = pStyle)
                        }
                    },
                    title = { Text("Resultado del Registro", style = h1Style) },
                    text = { Text(mensaje, style = pStyle) }
                )
            }
        }
    }
}
