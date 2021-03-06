/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package red.torch.composesample.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composesample.R
import red.torch.composesample.ui.theme.MyTheme

@Composable
fun DogListHeaderSection(
    searchTarget: String,
    searchResultCount: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                stringResource(
                    id = R.string.dog_list_search_result,
                    searchTarget,
                    searchResultCount
                ),
                style = typography.body1,
                color = colors.onBackground
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                stringResource(id = R.string.dog_list_sort_created_date),
                style = typography.body1,
                color = colors.primary
            )
            Spacer(Modifier.width(8.dp))
            Text(
                stringResource(id = R.string.dog_list_sort_separator),
                style = typography.body1,
                color = colors.onBackground.copy(alpha = 0.25f)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                stringResource(id = R.string.dog_list_sort_name),
                style = typography.body1,
                color = colors.onBackground.copy(alpha = 0.25f)
            )
        }
    }
}

@Preview("Dark Theme")
@Composable
fun DogListHeaderSectionDarkPreview() {
    MyTheme(darkTheme = true) {
        DogListHeaderSection("東京都", 234)
    }
}

@Preview("Light Theme")
@Composable
fun DogListHeaderSectionLightPreview() {
    MyTheme(darkTheme = false) {
        DogListHeaderSection("東京都", 234)
    }
}
