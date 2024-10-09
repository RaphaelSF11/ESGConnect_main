package com.example.login_home2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_home2.ui.theme.Login_home2Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_home2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()

                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current // Obtém o contexto do composable

    // Armazenar o texto do campo de entrada
    var username by remember { mutableStateOf(TextFieldValue("")) }

    // Fundo verde centralizado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF54D470)) // verde
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {

            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_esg),
                contentDescription = "Logo ESGConnect",
                modifier = Modifier.size(210.dp),
                contentScale = ContentScale.Crop,

            )

            // Texto centralizado
            Text(
                text = "ESGConnect",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Campo usuário
            BasicTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(10.dp)
                    ) {
                        if (username.text.isEmpty()) {
                            Text(
                                text = "Usuário",
                                color = Color.Gray,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Campo Senha
            BasicTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(10.dp)
                    ) {
                        if (username.text.isEmpty()) {
                            Text(
                                text = "Senha",
                                color = Color.Gray,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(40.dp))

            // Botão Branco
            Button(
                onClick = {
                    val intent = Intent(context, PrincipalActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF) // Branco
                )
            ) {
                Text(
                    text = "ENTRAR",
                    color = Color(0xFF54D470), // Verde
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_home2Theme {
        LoginScreen()
    }

}

