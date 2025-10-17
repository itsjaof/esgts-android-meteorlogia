package pt.joao.meteorlogia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.joao.meteorlogia.ui.theme.MeteorlogiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteorlogiaTheme {
                FullComponent()
            }
        }
    }

    var horizontal_padding = 15.dp;

    @Preview(showBackground = true)
    @Composable
    fun TopBar() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal_padding, 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Foto",
                )
            }

            Image(
                painter = painterResource(R.drawable.foto),
                contentDescription = "Foto",
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun FullComponent() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable._86449326_37c2256216_b),
                contentDescription = "Foto",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .alpha(0.5f)
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopBar()
                TextBlock("João", "Lisboa")
                WeatherCircle()
                WeatherRow()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextBlock(nome: String = "Pedro", localidade: String = "Vila Franca de Xira") {
        Column(modifier = Modifier.padding(horizontal_padding)) {
            Row() {
                Text("Olá", fontSize = 30.sp, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.size(10.dp))
                Text(nome, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            }
            Text("17 de Outubro de 2025",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.DarkGray
            )

            Text(localidade,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.DarkGray
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WeatherCircle() {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(top = 30.dp)) {
            Box(modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                .background(Color.White)
            ) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                    Image(
                        painter = painterResource(R.drawable.sun),
                        contentDescription = "Foto",
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text("23º",
                            fontWeight = FontWeight.Bold,
                            fontSize = 50.sp
                        )
                        Text("Limpo", modifier = Modifier.padding(top = 30.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20) { index ->
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text("Item $index")
            }
        }
    }
}
