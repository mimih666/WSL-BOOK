package com.example.wslbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaPerfil()
        }
    }
}

@Composable
fun TelaPerfil() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121212)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {

          
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {

              
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Maria",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Adoro romance, darkromance e casos reias em livros",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(74.dp) 
                            .clip(CircleShape)
                            .background(Color(0xFFB03A3A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Foto de perfil",
                            tint = Color.White,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

        
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Localização",
                        tint = Color(0xFFB03A3A),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Paraná, Brasil", color = Color.White, fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

             
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "15", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = "Seguidores", color = Color.Gray, fontSize = 10.sp)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = "30", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(text = "seguindo", color = Color.Gray, fontSize = 10.sp)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB03A3A)),
                        shape = RoundedCornerShape(18.dp),
                        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp) 
                    ) {
                        Text(text = "Seguir", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

             
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFFB03A3A), RoundedCornerShape(10.dp))
                        .padding(8.dp)
                ) {
                    Text(text = "Favoritos", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        BookItem(titulo = "Colegas de quarto", nota = "4,5", modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(6.dp))
                        BookItem(titulo = "Moonlight", nota = "4,5", modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(6.dp))
                        BookItem(titulo = "Borboletas de Vidro", nota = "4,7", modifier = Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        BookItem(titulo = "Nosso Acordo Secreto", nota = "4,6", modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(6.dp))
                        BookItem(titulo = "Coração de Gelo", nota = "4,4", modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(6.dp))
                        BookItem(titulo = "Rosas Escarlate", nota = "4,9", modifier = Modifier.weight(1f))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

             
                Text(text = "Meta de leitura 2026", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Text(text = "18 / 30 livros", color = Color.Gray, fontSize = 11.sp)

                Spacer(modifier = Modifier.height(6.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    BookItem(titulo = "Flores e Sombras", nota = "4,2", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(6.dp))
                    BookItem(titulo = "Bridgerton", nota = "4,8", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(6.dp))
                    BookItem(titulo = "Love, Hate & Princes", nota = "4,3", modifier = Modifier.weight(1f))
                }
            }

            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = "Leitura", tint = Color.White)
                Icon(Icons.Default.Home, contentDescription = "Início", tint = Color.White)
                Icon(Icons.AutoMirrored.Filled.LibraryBooks, contentDescription = "Biblioteca", tint = Color.White)
                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color(0xFFB03A3A))
            }
        }
    }
}


@Composable
fun BookItem(titulo: String, nota: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.flor),
            contentDescription = "Capa do livro $titulo",
            contentScale = ContentScale.Fit, 
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f)
                .clip(RoundedCornerShape(6.dp))
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = titulo,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Text(text = "★ $nota", color = Color(0xFFB03A3A), fontSize = 9.sp)
    }
}
