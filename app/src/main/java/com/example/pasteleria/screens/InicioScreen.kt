package com.example.pasteleria.screens

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
import com.example.pasteleria.R
import com.example.pasteleria.components.h1Style
import com.example.pasteleria.components.pStyle

@Composable
fun InicioScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Navbar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.portada),
                contentDescription = "Logo Pastelería",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .heightIn(min = 150.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Pastelería Mil Sabores",
                style = h1Style
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Pastelería Mil Sabores celebra su 50 aniversario como un referente en la repostería chilena. " +
                        "Famosa por su participación en un récord Guinness en 1995, cuando colaboró en la creación de la " +
                        "torta más grande del mundo, la pastelería busca renovar su sistema de ventas online para ofrecer " +
                        "una experiencia de compra moderna y accesible para sus clientes.",
                style = pStyle
            )
        }
    }
}