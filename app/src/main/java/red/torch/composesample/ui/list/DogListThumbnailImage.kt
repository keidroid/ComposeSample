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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import red.torch.composesample.ui.theme.MyTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DogListThumbnailImage(
    url: String,
    thumbnailSize: Dp = 120.dp,
    errorIconSize: Dp = 48.dp,
) {
    GlideImage(
        model = url,
        contentDescription = null,
        modifier =
            Modifier
                .size(thumbnailSize)
                .background(colors.background),
        contentScale = ContentScale.Crop,
        transition = CrossFade,
// TODO:
//        loading = {
//            Box(contentAlignment = Alignment.Center) {
//                CircularProgressIndicator(Modifier.align(Alignment.Center))
//            }
//        },
//        failure = {
//            Box(contentAlignment = Alignment.Center) {
//                Image(
//                    painterResource(R.drawable.ic_baseline_no_photography_24),
//                    contentDescription = null,
//                    modifier = Modifier.size(errorIconSize),
//                )
//            }
//        },
    )
}

@Preview("Dark Theme")
@Composable
fun DogListThumbnailImageDarkPreview() {
    MyTheme(darkTheme = true) {
        DogListThumbnailImage("")
    }
}

@Preview("Light Theme")
@Composable
fun DogListThumbnailImageLightPreview() {
    MyTheme(darkTheme = false) {
        DogListThumbnailImage("")
    }
}
