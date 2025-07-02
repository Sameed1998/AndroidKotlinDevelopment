package com.example.artwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.artwork.ui.theme.ArtWorkTheme

data class Artwork(
    val imageUrl: String,
    val title: String,
    val artist: String,
    val year: String
)

val dummyArtworks = listOf(
    Artwork(
        imageUrl = "https://developer.android.com/static/develop/ui/compose/images/graphics-sourceimageland.jpg",
        title = "Still Life of Blue Rose and Other Flowers",
        artist = "Owen Scott",
        year = "2021"
    ),
    Artwork(
        imageUrl = "https://images.unsplash.com/photo-1584395630827-860eee694d7b",
        title = "Sunset Overdrive",
        artist = "Jane Doe",
        year = "2020"
    ),
    Artwork(
        imageUrl = "https://ix-marketing.imgix.net/autocompress.png?auto=format,compress&w=3038",
        title = "The Color of Night",
        artist = "John Smith",
        year = "2019"
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtWorkTheme {
                Surface {
                    ArtworkScreen()
                }
            }
        }
    }
}

@Composable
fun ArtworkScreen(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    val currentArtwork = dummyArtworks[currentIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkImage(imageLink = currentArtwork.imageUrl)

        ArtworkTitleAndArtist(
            title = currentArtwork.title,
            artistName = currentArtwork.artist,
            year = currentArtwork.year
        )

        ArtworkButtons(
            onPreviousClick = {
                if (currentIndex > 0) currentIndex--
            },
            onNextClick = {
                if (currentIndex < dummyArtworks.size - 1) currentIndex++
            }
        )
    }
}

@Composable
fun ArtworkImage(imageLink: String, modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(3f / 4f)
    ) {
        AsyncImage(
            model = imageLink,
            contentDescription = "Artwork image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ArtworkTitleAndArtist(
    title: String,
    artistName: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFECEFF1), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text(
                text = artistName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "($year)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun ArtworkButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ActionButton(
            text = "Previous",
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp)) // Optional spacing
        ActionButton(
            text = "Next",
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
    ) {
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtworkPreview() {
    ArtWorkTheme {
        ArtworkScreen()
    }
}
