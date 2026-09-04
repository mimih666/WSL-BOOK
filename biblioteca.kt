package com.example.wslbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wslbook.ui.theme.WSLBOOKTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            WSLBOOKTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF121212)
                ) { paddingValues ->

                    BibliotecaScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}


@Composable
fun BibliotecaScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(20.dp)
    ) {


        Text(
            text = "Biblioteca",
            color = Color(0xFFFFF8E7),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(55.dp)
        )


        Text(
            text = "Últimas leituras",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFF8E7),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )


        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "◀",
                color = Color.White,
                fontSize = 40.sp
            )


            Image(
                painter = painterResource(R.drawable.capa),
                contentDescription = "Livro recente",
                modifier = Modifier.size(75.dp, 115.dp),
                contentScale = ContentScale.Crop
            )


            Image(
                painter = painterResource(R.drawable.capa),
                contentDescription = "Livro recente",
                modifier = Modifier.size(75.dp, 115.dp),
                contentScale = ContentScale.Crop
            )


            Image(
                painter = painterResource(R.drawable.capa),
                contentDescription = "Livro recente",
                modifier = Modifier.size(75.dp, 115.dp),
                contentScale = ContentScale.Crop
            )


            Text(
                text = "▶",
                color = Color.White,
                fontSize = 40.sp
            )
        }


        Spacer(
            modifier = Modifier.height(45.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFFD9364F),
                    shape = RoundedCornerShape(25.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Pesquisar livros...",
                    color = Color(0xFFFFF8E7),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.height(40.dp)
        )



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Livro(
                status = "Quero ler"
            )

            Livro(
                status = "Lendo • 52%"
            )

            Livro(
                status = "Quero ler"
            )
        }


        Spacer(
            modifier = Modifier.height(15.dp)
        )



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Livro(
                status = "Lendo • 99%"
            )

            Livro(
                status = "Lido • 100%"
            )

            Livro(
                status = "Quero ler"
            )
        }


        Spacer(
            modifier = Modifier.weight(1f)
        )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Icon(
                Icons.Default.Menu,
                contentDescription = "Leitura",
                tint = Color.White
            )


            Icon(
                Icons.Default.Home,
                contentDescription = "Início",
                tint = Color.White
            )


            Icon(
                Icons.AutoMirrored.Filled.List,
                contentDescription = "Biblioteca",
                tint = Color(0xFFB03A3A)
            )


            Icon(
                Icons.Default.Person,
                contentDescription = "Perfil",
                tint = Color.White
            )
        }
    }
}




@Composable
fun Livro(status: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.capa),
            contentDescription = "Capa do livro",
            modifier = Modifier.size(90.dp, 135.dp),
            contentScale = ContentScale.Crop
        )


        Spacer(
            modifier = Modifier.height(5.dp)
        )


        Text(
            text = status,
            color = Color(0xFFFFF8E7),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
