package com.example.musicapp

/*import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview*/

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFCCFFFF)
                ) {
                    MusicPlayerScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MusicPlayerScreen() {
    var isPlaying by remember { mutableStateOf(false) }
    var volume by remember { mutableStateOf(70f) }
    var progress by remember { mutableStateOf(25f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.diska),
            contentDescription = "Disk Image",
            modifier = Modifier
                .size(330.dp)
                .padding(top = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Everybody",
                fontSize = 24.sp,
                color = Color(0xFF3F51B5),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Backstreet Boys",
                fontSize = 20.sp,
                color = Color(0xFF3F51B5) // kolore argixka
            )
        }

        Slider(
            value = progress,
            onValueChange = { progress = it },
            valueRange = 0f..100f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {  }) {
                Image(
                    painter = painterResource(id = R.drawable.aurrekoa),
                    contentDescription = "Previous",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.width(24.dp))

            IconButton(onClick = { isPlaying = !isPlaying }) {
                Image(
                    painter = painterResource(
                        id = if (isPlaying) R.drawable.pause else R.drawable.play
                    ),
                    contentDescription = if (isPlaying) "Pause" else "Play",
                    modifier = Modifier.size(64.dp)
                )
            }

            Spacer(modifier = Modifier.width(24.dp))

            IconButton(onClick = { /* Hurrengoa */ }) {
                Image(
                    painter = painterResource(id = R.drawable.hurrengoa),
                    contentDescription = "Next",
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {  }) {
                Image(
                    painter = painterResource(id = R.drawable.bolumena),
                    contentDescription = "Volume",
                    modifier = Modifier.size(36.dp)
                )
            }

            Slider(
                value = volume,
                onValueChange = { volume = it },
                valueRange = 0f..100f,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {  }) {
                Image(
                    painter = painterResource(id = R.drawable.elkarbanatu),
                    contentDescription = "Share",
                    modifier = Modifier.size(36.dp)
                )
            }

            IconButton(onClick = {  }) {
                Image(
                    painter = painterResource(id = R.drawable.letra),
                    contentDescription = "Lyrics",
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    }
}*/
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.theme.MusicAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Post(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Post(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    //val kolorea =

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCCFFFF))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.diska),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(330.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Everybody",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3F51B5),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Backstreet Boys",
                    color = Color(0xFF3F51B5),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SongProgressBar()
                PlayerControls()
                VolumeBar()
                ExtraButtons()
            }
        }

    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCCFFFF))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.diska),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(200.dp)
                    .size(330.dp)
                    .padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Everybody", color = Color(0xFF3F51B5),fontWeight = FontWeight.Bold)
            Text("Backstreet Boys", color = Color(0xFF3F51B5))

            SongProgressBar()
            PlayerControls()
            VolumeBar()
            ExtraButtons()
        }
    }
}

@Composable
fun PlayerControls() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.aurrekoa),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(5.dp)
                .clickable { }
        )

        Spacer(modifier = Modifier.width(30.dp))

        PlayPauseButton()

        Spacer(modifier = Modifier.width(30.dp))

        Image(
            painter = painterResource(R.drawable.hurrengoa),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(5.dp)
                .clickable { }
        )
    }
}

@Composable
fun ExtraButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.elkarbanatu),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(5.dp)
                .clickable { }
        )

        Spacer(modifier = Modifier.width(30.dp))

        Image(
            painter = painterResource(R.drawable.letra),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(5.dp)
                .clickable { }
        )

        Spacer(modifier = Modifier.width(30.dp))

        Image(
            painter = painterResource(R.drawable.letrabene),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(5.dp)
                .clickable { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostPreview() {
    MusicAppTheme {
        Post()
    }
}

@Composable
fun SongProgressBar() {
    val duration = 285_000f
    var position by remember { mutableStateOf(duration * 0.25f) }
    val progress = position / duration

    Column(Modifier.padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            // Tiempo transcurrido
            val minutesElapsed = (position / 60000).toInt()
            val secondsElapsed = ((position / 1000) % 60).toInt()
            Text(String.format("%d:%02d", minutesElapsed, secondsElapsed))

            // Duración total
            val minutesTotal = (duration / 60000).toInt()
            val secondsTotal = ((duration / 1000) % 60).toInt()
            Text(String.format("%d:%02d", minutesTotal, secondsTotal))
        }

        Slider(
            value = progress,
            onValueChange = { position = it * duration },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun VolumeBar() {
    var volume by remember { mutableStateOf(0.7f) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text(text = "${(volume * 100).toInt()}%", fontWeight = FontWeight.Bold)

        Slider(
            value = volume,
            onValueChange = { volume = it },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PlayPauseButton() {
    var isPlaying by remember { mutableStateOf(false) }

    Image(
        painter = painterResource(
            if (isPlaying) R.drawable.pause else R.drawable.play
        ),
        contentDescription = if (isPlaying) "Pause" else "Play",
        modifier = Modifier
            .size(45.dp)
            .padding(5.dp)
            .clickable {
                isPlaying = !isPlaying
            }
    )
}