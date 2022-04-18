package com.jeluchu.composefornewhorizons.features.bugs.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jeluchu.composefornewhorizons.R
import com.jeluchu.composefornewhorizons.core.ui.theme.artichoke
import com.jeluchu.composefornewhorizons.core.ui.theme.cream
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.jchucomponentscompose.ui.images.NetworkImage
import com.jeluchu.jchucomponentscompose.ui.modifier.cornerRadius


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BugItem(
    bug: BugsItem,
    onItemClick: () -> Unit
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
            url = bug.imageUri
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = bug.name.nameEUen,
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
                DropdownMenuItem(
                    onClick = { isDropdownMenuExpanded.value = false }) {
                    Text(
                        text = "ID: ${bug.fileName}",
                        color = cream
                    )
                }

                DropdownMenuItem(
                    onClick = { isDropdownMenuExpanded.value = false }) {
                    Text(
                        text = "Wild World",
                        color = cream
                    )
                }

                DropdownMenuItem(
                    onClick = { isDropdownMenuExpanded.value = false }) {
                    Text(
                        text = "City Folk",
                        color = cream
                    )
                }

                DropdownMenuItem(
                    onClick = { isDropdownMenuExpanded.value = false }) {
                    Text(
                        text = "New Leaf",
                        color = cream
                    )
                }

                DropdownMenuItem(
                    onClick = { isDropdownMenuExpanded.value = false }) {
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 10.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_deco_leaf),
                        tint = cream,
                        contentDescription = "Leaf"
                    )
                    Text(
                        text = "New Horizons",
                        color = cream
                    )
                }

            }

        }

    }

}