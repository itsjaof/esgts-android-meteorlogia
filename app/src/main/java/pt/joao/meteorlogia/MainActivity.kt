package pt.joao.meteorlogia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.joao.meteorlogia.ui.theme.MeteorlogiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteorlogiaTheme {
                TopBar()
            }
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun TopBar() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(15.dp, 25.dp),
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
}