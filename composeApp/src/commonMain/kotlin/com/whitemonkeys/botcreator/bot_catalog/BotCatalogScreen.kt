package com.whitemonkeys.botcreator.bot_catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.whitemonkeys.botcreator.uikit.black
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BotCatalogScreen() {

}

@Composable
private fun BotCatalogScreen(
    uiState: BotCatalogUiState,
    onEvent: (BotCatalogEvent) -> Unit
) {
    Column {
        Row {
            IconButton(
                onClick = { onEvent(BotCatalogEvent.OnBackClick) }
            ) {

            }
            Text("choode bot")
            IconButton(
                onClick = {  }
            ) {

            }
        }
        LazyRow {
            items(count = 5) {
                Button(
                    onClick = { onEvent(BotCatalogEvent.OnCategoryClick(id = 0)) }
                ) {
                    Text("ddhhd")
                }
            }
        }
        LazyColumn {
            items(count = 5) {
                BotElement()
            }
        }
    }
}

@Composable
private fun BotElement(
    modifier: Modifier = Modifier
) = Row {
    //Icon()
    Column {
        Text(
            text = "ddhd"
        )
        Text(
            text = "jdjjd"
        )
    }
    //Icon()
}

@Composable
@Preview
private fun BotCatalogScreenPreview() {
    val uiState = BotCatalogUiState(
        categories = emptyList(),
        botSamples = emptyList()
    )

    BotCatalogScreen(
        uiState = uiState,
        onEvent = { event ->

        }
    )
}