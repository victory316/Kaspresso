package com.kaspersky.kaspresso.foreign_process_tests.screen

import com.kaspersky.components.uiautomator_dsl.dsl.text.UiButton
import com.kaspersky.kaspresso.foreign_process_tests.common.UpgradeUiScreen

object MainScreen : UpgradeUiScreen<MainScreen>() {

    val upgradeButton = UiButton { withId(MAIN_APP_PACKAGE_ID, "activity_main_button_upgrade_scenario") }
}
