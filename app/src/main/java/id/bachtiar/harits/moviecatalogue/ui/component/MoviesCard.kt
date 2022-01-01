package id.bachtiar.harits.moviecatalogue.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import id.bachtiar.harits.moviecatalogue.ui.model.Movie
import id.bachtiar.harits.moviecatalogue.ui.theme.MovieCatalogueTheme

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = { /* Ignoring onClick */ })
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Surface(
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.cover.orEmpty(),
                    builder = {
                    }
                ),
                contentDescription = "Movies Cover",
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            title(text = movie.title.orEmpty())
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = movie.releaseDate.orEmpty(), style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = movie.description.orEmpty(),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun title(text: String) {
    Text(text, fontWeight = FontWeight.Bold, fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieCard() {
    MovieCatalogueTheme {
        MovieCard(Movie())
    }
}