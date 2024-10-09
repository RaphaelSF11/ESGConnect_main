package com.example.login_home2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign

class PrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrincipalScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrincipalScreen() {
    // fundo cinza claro
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ESG Connect") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF54D470), // Verde
                    titleContentColor = Color.White // cor do texto
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Texto inicial direto no fundo
            Text(
                text = "Bem-vindo à Plataforma ESG. Aqui você encontrará informações sobre práticas ambientais, sociais e de governança.",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // container expansível
            ExpandableContainer(
                title = "Impacto Ambiental",
                backgroundColor = Color(0xFF2196F3), // azul
                expandedContent = "Informações e projetos sobre impacto ambiental.",
            )

            // container expansível
            ExpandableContainer(
                title = "Responsabilidade Social",
                backgroundColor = Color(0xFFFF9800),
                expandedContent = "Informações e projetos sobre responsabilidade social.",
            )

            // container expansível
            ExpandableContainer(
                title = "Governança",
                backgroundColor = Color(0xFFCDDC39),
                expandedContent = "Informações e projetos de governança e transparência.",
            )

            // nova linha, 2 containers lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // container expansível
                ExpandableContainer(
                    title = "Economia Circular",
                    backgroundColor = Color(0xFF800080), // uva
                    expandedContent = "Informações e projetos de economia circular.",
                    modifier = Modifier.weight(1f)
                )

                // container expansível
                ExpandableContainer(
                    title = "Diversidade e Inclusão",
                    backgroundColor = Color(0xFFFF5E5B), // goiaba
                    expandedContent = "Informações e projetos de diversidade e inclusão.",
                    modifier = Modifier.weight(1f)
                )
            }

            // texto fechamento
            Text(
                text = "Conheça nossos projetos e participe! Tem alguma ideia? Vamos conversar!" +
                        " Juntos, vamos construir um futuro mais sustentável.",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // container expansível para créditos
            ExpandableContainer(
                title = "Clique para créditos",
                backgroundColor = Color.White,
                expandedContent = "Trabalho FIAP, Cap 9 - Ecossistema multimídia - " +
                        "Atividade 2 - Plataforma ESG. Grupo: Jayme Tavares Ferreira Lagatta, " +
                        "Igor Gabriel Martins Ramos e Raphael Soares Fernandes",
                contentColor = Color.Black
            )

            // linha com 5 botões bolinha
            Spacer(modifier = Modifier.weight(1f)) // empurra pra baixo se preciso

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CircularContainer(Color(0xFF2196F3)) // azul
                CircularContainer(Color(0xFFFF9800)) // laranja
                CircularContainer(Color(0xFFCDDC39)) // verde
                CircularContainer(Color(0xFF800080)) // uva
                CircularContainer(Color(0xFFFF5E5B)) // goiaba
            }
        }
    }
}

@Composable
fun CircularContainer(color: Color) {
    Box(
        modifier = Modifier
            .size(60.dp) // tamanho do círculo
            .clip(CircleShape) // forma
            .background(color)
    )
}

@Composable
fun ExpandableContainer(
    title: String,
    backgroundColor: Color,
    expandedContent: String,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.White
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Text(
            text = title,
            color = contentColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // exibe texto adicional se expandido
        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = expandedContent,
                color = contentColor,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrincipalScreenPreview() {
    PrincipalScreen()
}
