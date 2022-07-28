package com.jeluchu.composefornewhorizons.core.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.jchucomponents.core.extensions.ints.isNotEmpty
import com.jeluchu.jchucomponents.core.extensions.strings.empty

@Composable
fun CustomDropdownMenuItem(
    showIcon: Boolean = false,
    @DrawableRes icon: Int = 0,
    title: String = String.empty(),
    onClick: () -> Unit = {}
) {

    DropdownMenuItem(onClick = onClick) {

        if (showIcon && icon.isNotEmpty())
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 10.dp),
                imageVector = ImageVector.vectorResource(id = icon),
                tint = cream,
                contentDescription = "Icon Menu"
            )

        Text(
            text = title,
            color = cream
        )

    }

}