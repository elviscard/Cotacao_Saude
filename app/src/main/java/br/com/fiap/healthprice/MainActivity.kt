
package br.com.fiap.healthprice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import br.com.fiap.healthprice.ui.theme.HealthPriceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthPriceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Variável de estado para armazenar o texto digitado pelo usuário
    var textFieldValue by remember { mutableStateOf("") }
    // Variável de estado para armazenar os nomes digitados pelo usuário
    var names by remember { mutableStateOf(listOf<String>()) }

    // Definições de estilo de texto subtitle1 e body1
    val subtitle1 = TextStyle(
        fontSize = 18.sp,
        // Outras propriedades de estilo, se desejar
    )

    val body1 = TextStyle(
        fontSize = 16.sp,
        // Outras propriedades de estilo, se desejar
    )

    // Define o tema do aplicativo
    HealthPriceTheme {
        val typography = Typography(
            headlineLarge = subtitle1, // Define o estilo subtitle1
            bodyLarge = body1 // Define o estilo body1
        )

        MaterialTheme(typography = typography) { // Aplica a tipografia definida ao MaterialTheme
            Column(
                modifier = modifier.padding(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        OutlinedTextField(
                            value = textFieldValue,
                            onValueChange = {
                                // Atualize o valor da variável de estado com o novo texto digitado pelo usuário
                                textFieldValue = it
                            },
                            label = { Text("Digite algo...") }
                        )
                    }
                }

                // Botão para enviar o texto digitado
                Button(
                    onClick = {
                        // Adiciona o nome digitado à lista de nomes
                        names = names + textFieldValue
                        // Limpa o texto digitado para o próximo nome
                        textFieldValue = ""
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Enviar")
                }

                // Exibe cada nome em um Card separado
                names.forEach { name ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nome:",
                                style = MaterialTheme.typography.headlineLarge // Utiliza o estilo subtitle1 do MaterialTheme
                            )
                            Text(
                                text = name,
                                style = MaterialTheme.typography.bodyLarge // Utiliza o estilo body1 do MaterialTheme
                            )
                        }
                    }
                }

                Text(
                    text = "Hello $name!",
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HealthPriceTheme {
        Greeting("Android")
    }
}

