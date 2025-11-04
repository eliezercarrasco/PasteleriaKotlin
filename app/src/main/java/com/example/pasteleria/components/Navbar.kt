package com.example.pasteleria.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pasteleria.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navbar(navController: NavController) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.icono),
                    contentDescription = "Logo Pastelería",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Pastelería Mil Sabores",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.error,
            titleContentColor = MaterialTheme.colorScheme.onError
        ),
        actions = {
            var expanded by remember { mutableStateOf(false) }

            Box {
                Text(
                    text = "Menú",
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.onError,
                    fontWeight = FontWeight.SemiBold
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Inicio") },
                        onClick = {
                            navController.navigate("inicio")
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Detalle") },
                        onClick = {
                            navController.navigate("detalle")
                            expanded = false
                        }
                    )
                         DropdownMenuItem(
                        text = { Text("Registro") },
                        onClick = {
                            navController.navigate("registro")
                            expanded = false
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
