package id.bachtiar.harits.moviecatalogue.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.bachtiar.harits.moviecatalogue.ui.theme.MovieCatalogueTheme

@Composable
fun Toolbar(title: String, isHaveStack: Boolean) {
    if (isHaveStack) {
        TopAppBar(
            title = {
                Text(text = title)
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "arrow to back")
                }
            }
        )
    } else {
        TopAppBar(
            title = {
                Text(text = title)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewToolbar() {
    MovieCatalogueTheme {
        Toolbar("Movie Catalogue", false)
    }
}