package id.bachtiar.harits.moviecatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import id.bachtiar.harits.moviecatalogue.ui.component.CombinedTab
import id.bachtiar.harits.moviecatalogue.ui.component.Toolbar
import id.bachtiar.harits.moviecatalogue.ui.model.Data
import id.bachtiar.harits.moviecatalogue.ui.theme.MovieCatalogueTheme
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    private val json = Json { ignoreUnknownKeys = true }

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieCatalogueTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = { Toolbar(title = "Movie Catalogue", isHaveStack = false) },
                        content = {
                            CombinedTab(getData().data ?: listOf())
                        }
                    )
                }
            }
        }
    }

    private fun getData(): Data {
        val jsonString = this.assets.open("data.json").bufferedReader().use { it.readText() }
        return json.decodeFromString(jsonString)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieCatalogueTheme {
        Greeting("Android")
    }
}