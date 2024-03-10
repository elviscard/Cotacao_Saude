package br.com.fiap.healthprice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.healthprice.ui.theme.HealthPriceTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthPriceTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    ScaffoldContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldContent() {
    var presses by remember { mutableStateOf(0) }
    var medicationName by remember { mutableStateOf("") }
    var medicationSpecifications by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Haelth Price")
                }
            )
        },
        bottomBar = {
            BottomAppBar() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    Olá usuário, obrigado por usar nosso aplicativo. Procura remédios mais baratos? 
                    Envie sua receita ou digite o nome do remédio e suas especificações no local 
                    abaixo e aguarde a resposta da farmácia.
                """.trimIndent(),
            )

            // Campo de texto para inserir o nome do medicamento
            OutlinedTextField(
                value = medicationName,
                onValueChange = { medicationName = it },
                label = { Text("Nome do medicamento") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo de texto para inserir as especificações do medicamento
            OutlinedTextField(
                value = medicationSpecifications,
                onValueChange = { medicationSpecifications = it },
                label = { Text("Especificações do medicamento") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botão para enviar a solicitação
            Button(
                onClick = {
                    // Aqui você pode adicionar a lógica para enviar a solicitação para a farmácia
                    // Por exemplo, você pode enviar as informações para um serviço web
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Enviar solicitação")
            }

            // Exemplo de cartão
            FilledCardExample()
        }
    }
}

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Exemplo de Card preenchido",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}
