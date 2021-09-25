package com.kaspersky.kaspresso_allure_support_sample.screen

import com.kaspersky.kaspresso_allure_support_sample.R
import com.kaspersky.kaspresso_sample_core.compose.ComplexComposeSampleActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton

object ComplexComposeScreen : KScreen<ComplexComposeScreen>() {

    override val layoutId: Int? = R.layout.activity_complex_compose
    override val viewClass: Class<*>? = ComplexComposeSampleActivity::class.java

    val startButton = KButton { withId(R.id.activity_compose_start) }
    val stage1Button = KButton { withId(R.id.activity_compose_stage_1) }
    val stage2Button = KButton { withId(R.id.activity_compose_stage_2) }
    val finishButton = KButton { withId(R.id.activity_compose_finish) }
}
