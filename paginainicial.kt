package com.example.wslbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wslbook.ui.theme.WSLBookTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            WSLBookTheme {
                TelaBiblioteca()
            }
        }
    }
}



data class Livro(
    val titulo: String
)


@Composable
fun TelaBiblioteca() {

    val minhaBiblioteca = listOf(
        Livro("Nosso Segredo"),
        Livro("Mordida"),
        Livro("Borboletas de Vidro")
    )

    val catalogo = listOf(
        Livro("Flores e Reis das Sombras"),
        Livro("Livro 2"),
        Livro("Sea of Smoke"),
        Livro("Coração Proibido"),
        Livro("Powerless"),
        Livro("Blameless")
    )


    Scaffold(
        containerColor = Color(0xFF101010),

        bottomBar = {
            BarraDeNavegacao()
        }

    ) { paddingInterno ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(horizontal = 14.dp)
        ) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 3.dp,
                        color = Color(0xFFD9364F),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 14.dp
                    )
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Da sua biblioteca",
                        color = Color(0xFFFFF8E7),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(17.dp)
                    )


                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        items(minhaBiblioteca) { livro ->

                            CapaDoLivro(
                                livro = livro,
                                largura = 88.dp,
                                altura = 132.dp
                            )
                        }
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .border(
                        width = 3.dp,
                        color = Color(0xFFD9364F),
                        shape = RoundedCornerShape(35.dp)
                    ),

                contentAlignment = Alignment.CenterStart
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        horizontal = 18.dp
                    )
                ) {

                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Pesquisar",
                        tint = Color(0xFFFFF8E7),
                        modifier = Modifier.size(25.dp)
                    )


                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )


                    Text(
                        text = "Pesquisar livros...",
                        color = Color(0xFFFFF8E7),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(14.dp)
            )



            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Filtros",
                    tint = Color(0xFFD9364F),
                    modifier = Modifier.size(34.dp)
                )


                Filtro(
                    texto = "Terror"
                )


                Filtro(
                    texto = "Romance"
                )


                Filtro(
                    texto = "Fantasia"
                )
            }


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .border(
                        width = 3.dp,
                        color = Color(0xFFD9364F),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp
                    )
            ) {

                Column {

                    Text(
                        text = "Catálogo",
                        color = Color(0xFFFFF8E7),
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )


                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),

                        modifier = Modifier.fillMaxSize(),

                        horizontalArrangement =
                            Arrangement.SpaceEvenly,

                        verticalArrangement =
                            Arrangement.spacedBy(18.dp)
                    ) {

                        items(catalogo) { livro ->

                            CapaDoLivro(
                                livro = livro,
                                largura = 78.dp,
                                altura = 117.dp
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CapaDoLivro(
    livro: Livro,
    largura: Dp,
    altura: Dp
) {

    Image(
        painter = painterResource(
            id = R.drawable.capa
        ),

        contentDescription = livro.titulo,

        contentScale = ContentScale.Fit,

        modifier = Modifier
            .width(largura)
            .height(altura)
            .clip(
                RoundedCornerShape(6.dp)
            )
    )
}


@Composable
fun Filtro(
    texto: String
) {

    Surface(
        color = Color(0xFFD9364F),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.height(42.dp)
    ) {

        Box(
            contentAlignment = Alignment.Center,

            modifier = Modifier.padding(
                horizontal = 13.dp
            )
        ) {

            Text(
                text = texto,
                color = Color(0xFFFFF8E7),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Composable
fun BarraDeNavegacao() {

    NavigationBar(
        containerColor = Color(0xFF101010),
        modifier = Modifier.height(76.dp)
    ) {



        NavigationBarItem(

            selected = false,

            onClick = { },

            icon = {

                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Leitura",
                    tint = Color(0xFFFFF8E7),
                    modifier = Modifier.size(30.dp)
                )
            },

            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )



        NavigationBarItem(

            selected = false,

            onClick = { },

            icon = {

                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Início",
                    tint = Color(0xFFFFF8E7),
                    modifier = Modifier.size(30.dp)
                )
            },

            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )


        NavigationBarItem(

            selected = true,

            onClick = { },

            icon = {

                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Biblioteca",
                    tint = Color(0xFFD9364F),
                    modifier = Modifier.size(30.dp)
                )
            },

            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFFD9364F),
                indicatorColor = Color.Transparent
            )
        )


        NavigationBarItem(

            selected = false,

            onClick = { },

            icon = {

                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Perfil",
                    tint = Color(0xFFFFF8E7),
                    modifier = Modifier.size(30.dp)
                )
            },

            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
    }
}
