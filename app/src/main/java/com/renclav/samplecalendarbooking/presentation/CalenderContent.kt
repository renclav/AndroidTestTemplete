package com.renclav.samplecalendarbooking.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CalenderContent(
    modifier: Modifier,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(7), contentPadding = PaddingValues(8.dp)) {
            items(31) {
                Day(day = it + 1)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Day(day: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        onClick = {},
    ) {

        Text(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            text = day.toString(),
            style = MaterialTheme.typography.caption
        )
    }
}