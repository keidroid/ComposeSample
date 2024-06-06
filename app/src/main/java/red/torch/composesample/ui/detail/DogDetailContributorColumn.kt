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
package red.torch.composesample.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import red.torch.composesample.R
import red.torch.composesample.data.repository.ContributorInfo
import red.torch.composesample.ui.theme.MyTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DogDetailContributorColumn(
    contributorInfo: ContributorInfo,
    thumbnailSize: Dp = 64.dp,
    errorIconSize: Dp = 24.dp,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        GlideImage(
            model = contributorInfo.thumbnailUrl,
            contentDescription = null,
            modifier =
                Modifier
                    .size(thumbnailSize)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop,
            transition = CrossFade,
// TODO:
//            loading = {
//                Box(contentAlignment = Alignment.Center) {
//                    CircularProgressIndicator(Modifier.align(Alignment.Center))
//                }
//            },
//            failure = {
//                Box(contentAlignment = Alignment.Center) {
//                    Image(
//                        painterResource(R.drawable.ic_baseline_no_photography_24),
//                        contentDescription = null,
//                        modifier = Modifier.size(errorIconSize),
//                    )
//                }
//            },
        )

        Spacer(Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp),
        ) {
            Text(
                stringResource(R.string.dog_detail_contributor_info_id, contributorInfo.id),
                style = typography.body2,
            )
            Text(
                contributorInfo.name,
                style = typography.subtitle1,
            )
        }
    }
}

@Preview("Dark Theme")
@Composable
fun DogDetailContributorColumnDarkPreview() {
    val contributorInfo =
        ContributorInfo(
            123,
            "thumbnailUrl",
            "name",
        )
    MyTheme(darkTheme = true) {
        DogDetailContributorColumn(contributorInfo)
    }
}

@Preview("Light Theme")
@Composable
fun DogDetailContributorColumnLightPreview() {
    val contributorInfo =
        ContributorInfo(
            123,
            "thumbnailUrl",
            "name",
        )
    MyTheme(darkTheme = false) {
        DogDetailContributorColumn(contributorInfo)
    }
}
