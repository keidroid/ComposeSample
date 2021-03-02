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
package red.torch.composesample.ui.common

import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import red.torch.composesample.R
import red.torch.composesample.ui.theme.MyTheme

@Composable
fun DogAdaptionTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontFamily = FontFamily(
                    Font(R.font.dosis_bold),
                )
            )
        },
        backgroundColor = colors.surface,
        contentColor = colors.onSurface,
    )
}

@Preview
@Composable
fun DogAdaptionTopAppBarLightPreview() {
    MyTheme(darkTheme = false) {
        DogAdaptionTopAppBar()
    }
}

@Preview
@Composable
fun DogAdaptionTopAppBarDarkPreview() {
    MyTheme(darkTheme = true) {
        DogAdaptionTopAppBar()
    }
}
