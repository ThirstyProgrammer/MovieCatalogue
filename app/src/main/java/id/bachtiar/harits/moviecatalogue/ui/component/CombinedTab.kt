package id.bachtiar.harits.moviecatalogue.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import id.bachtiar.harits.moviecatalogue.ui.model.Tab
import id.bachtiar.harits.moviecatalogue.ui.theme.MovieCatalogueTheme
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun CombinedTab(tabData: List<Tab>) {
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 1,
        infiniteLoop = false,
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            tabData.forEachIndexed { index, data ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = data.key.orEmpty())
                })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                val dataTab = tabData[index].value
                dataTab?.forEachIndexed { index, movie ->
                    item {
                        MovieCard(movie)
                        if (index < dataTab.size){
                            Spacer(modifier = Modifier.size(width = 8.dp, height = 8.dp))
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewCombinedTab() {
    MovieCatalogueTheme {
        CombinedTab(
            listOf(
                Tab(key = "Movie"),
                Tab(key = "TV Show"),
            )
        )
    }
}