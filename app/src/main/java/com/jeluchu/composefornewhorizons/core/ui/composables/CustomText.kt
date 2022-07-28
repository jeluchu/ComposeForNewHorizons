package com.jeluchu.composefornewhorizons.core.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.textColor
import com.jeluchu.jchucomponents.core.extensions.strings.empty
import com.jeluchu.jchucomponents.ui.modifier.cornerRadius

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    title: String = String.empty(),
    bgColor: Color = artichoke.copy(.2f),
    onClick: () -> Unit = {}
) {
    Text(
        text = title,
        modifier = modifier
            .fillMaxWidth()
            .clip(13.cornerRadius())
            .clickable { onClick() }
            .background(bgColor)
            .padding(8.dp),
        textAlign = TextAlign.Center,
        color = textColor
    )
}