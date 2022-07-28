package com.jeluchu.composefornewhorizons.features.bugs.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeluchu.composefornewhorizons.R
import com.jeluchu.composefornewhorizons.core.ui.composables.CustomDropdownMenuItem
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.jchucomponents.ui.images.NetworkImage
import com.jeluchu.jchucomponents.ui.modifier.cornerRadius

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomItem(
    id: String,
    name: String,
    image: String,
    onItemClick: () -> Unit = {}
) {

    val isDropdownMenuExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .height(150.dp)
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp
            )
            .clip(RoundedCornerShape(16.dp))
            .combinedClickable(
                onClick = onItemClick,
                onLongClick = { isDropdownMenuExpanded.value = true }
            )
            .background(artichoke.copy(.15f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // NetworkImage is a custom component I have made that extends
        // the Composable made in the Coil library
        // (https://coil-kt.github.io/coil/compose/)
        // compatible with Compose, and 100% in Kotlin with
        // Coroutines compatibility
        NetworkImage(
            modifier = Modifier
                .size(80.dp)
                .clip(16.cornerRadius())
                .background(artichoke.copy(.3f)),
            url = image
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = name,
            textAlign = TextAlign.Center,
            maxLines = 1
        )

        // MaterialTheme for DropdownMenu is completely optional
        // but serves to apply the Material Design styles
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = 16.cornerRadius())) {

            // With DropdownMenu we configure the base of the dropdown menu
            // we want to show, and inside it we will include the different
            // available options we will give to the user
            DropdownMenu(
                expanded = isDropdownMenuExpanded.value,
                onDismissRequest = { isDropdownMenuExpanded.value = false },
                modifier = Modifier.background(artichoke)
            ) {

                // To include items inside our DropdownMenuItem we will include
                // DropdownMenuItem for each option we want to include,
                // inside the item design we can include either only text options,
                // or also for example options with icon and text

                CustomDropdownMenuItem(
                    title = "ID: $id"
                ) { isDropdownMenuExpanded.value = false }

                CustomDropdownMenuItem(
                    title = "Wild World"
                ) { isDropdownMenuExpanded.value = false }

                CustomDropdownMenuItem(
                    title = "City Folk"
                ) { isDropdownMenuExpanded.value = false }

                CustomDropdownMenuItem(
                    title = "New Leaf"
                ) { isDropdownMenuExpanded.value = false }

                CustomDropdownMenuItem(
                    title = "New Horizons",
                    showIcon = true,
                    icon = R.drawable.ic_deco_leaf
                ) { isDropdownMenuExpanded.value = false }

            }

        }

    }

}

// Here you can see the preview of a specific composable
// and adjust the necessary settings we want for our preview
@Preview(
    name = "A bug preview",
    showBackground = true,
    backgroundColor = 0xFFFEE0,
    device = Devices.PIXEL_XL,
    showSystemUi = true
)
@Composable
fun CustomItemPreview() {
    CustomItem(
        id = "bug",
        name = "The bug is a vampire!",
        image = "https://acnhapi.com/v1/icons/bugs/1"
    )
}