package com.kaspersky.kaspresso.kaspresso

import android.app.Activity
import android.net.Uri
import com.kaspersky.kaspresso.device.JvmUiDeviceConfig
import com.kaspersky.kaspresso.device.UiDeviceConfig
import com.kaspersky.kaspresso.device.accessibility.Accessibility
import com.kaspersky.kaspresso.device.activities.Activities
import com.kaspersky.kaspresso.device.apps.Apps
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.device.files.Files
import com.kaspersky.kaspresso.device.keyboard.Keyboard
import com.kaspersky.kaspresso.device.languages.Language
import com.kaspersky.kaspresso.device.location.Location
import com.kaspersky.kaspresso.device.logcat.Logcat
import com.kaspersky.kaspresso.device.logcat.LogcatBufferSize
import com.kaspersky.kaspresso.device.network.Network
import com.kaspersky.kaspresso.device.permissions.HackPermissions
import com.kaspersky.kaspresso.device.permissions.Permissions
import com.kaspersky.kaspresso.device.phone.Phone
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.device.server.AdbServer
import com.kaspersky.kaspresso.interceptors.behavior.DataBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.WebBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.impl.autoscroll.AutoScrollViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.impl.autoscroll.AutoScrollWebBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.impl.flakysafety.FlakySafeDataBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.impl.flakysafety.FlakySafeViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behavior.impl.flakysafety.FlakySafeWebBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.DeviceBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.ObjectBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.impl.autoscroll.AutoScrollObjectBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.impl.flakysafety.FlakySafeDeviceBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.impl.flakysafety.FlakySafeObjectBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.impl.loader.UiObjectLoaderBehaviorInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.params.FlakySafetyParams
import java.util.*

/**
 * Contains empty or default implementations of all those interfaces that require UiAutomator in order
 * to make it JVM compatible
 */
class KautomatorJvmConfig : KautomatorConfig {

    override val canRunOnJvm: Boolean
        get() = true

    override fun getUiDeviceConfig(): UiDeviceConfig = JvmUiDeviceConfig()

    override fun getAdbServer(libLogger: UiTestLogger): AdbServer = object : AdbServer {
        override fun performCmd(vararg commands: String): List<String> = emptyList()

        override fun performAdb(vararg commands: String): List<String> = emptyList()

        override fun performShell(vararg commands: String): List<String> = emptyList()

        override fun disconnectServer() {
            //no-op
        }
    }

    override fun getPermissions(libLogger: UiTestLogger): Permissions = object : Permissions {
        override fun allowViaDialog() {
            //no-op
        }

        override fun denyViaDialog() {
            //no-op
        }

        override fun isDialogVisible(): Boolean = false

        override fun clickOn(button: Permissions.Button) {
            //no-op
        }
    }

    override fun getNetwork(libLogger: UiTestLogger, adbServer: AdbServer): Network = object : Network {
        override fun enable() {
            //no-op
        }

        override fun disable() {
            //no-op
        }

        override fun toggleMobileData(enable: Boolean) {
            //no-op
        }

        override fun toggleWiFi(enable: Boolean) {
            //no-op
        }
    }

    override fun getApps(libLogger: UiTestLogger, adbServer: AdbServer): Apps =
        object : Apps {
            override val targetAppLauncherPackageName: String
                get() = "JVM launcher package name"
            override val targetAppPackageName: String
                get() = "JVM package name"

            override fun install(apkPath: String) {
                //no-op
            }

            override fun installIfNotExists(packageName: String, apkPath: String) {
                //no-op
            }

            override fun uninstall(packageName: String) {
                //no-op
            }

            override fun uninstallIfExists(packageName: String) {
                //no-op
            }

            override fun isInstalled(packageName: String): Boolean = false

            override fun waitForLauncher(timeout: Long, launcherPackageName: String) {
                //no-op
            }

            override fun waitForAppLaunchAndReady(timeout: Long, packageName: String) {
                //no-op
            }

            override fun openUrlInChrome(url: String) {
                //no-op
            }

            override fun launch(packageName: String, data: Uri?) {
                //no-op
            }

            override fun openRecent(contentDescription: String) {
                //no-op
            }

            override fun kill(packageName: String) {
                //no-op
            }
        }

    override fun getFiles(adbServer: AdbServer): Files = object : Files {
        override fun push(serverPath: String, devicePath: String) {
            //no-op
        }

        override fun remove(path: String) {
            //no-op
        }

        override fun pull(devicePath: String, serverPath: String) {
            //no-op
        }
    }

    override fun getActivities(libLogger: UiTestLogger): Activities = object : Activities {
        override fun getResumed(): Activity? = null

        override fun isCurrent(clazz: Class<out Activity>) {
            //no-op
        }
    }

    override fun getPhone(adbServer: AdbServer): Phone = object : Phone {
        override fun emulateCall(number: String) {
            //no-op
        }

        override fun cancelCall(number: String) {
            //no-op
        }

        override fun receiveSms(number: String, text: String) {
            //no-op
        }
    }

    override fun getLocation(adbServer: AdbServer): Location = object : Location {
        override fun enableGps() {
            //no-op
        }

        override fun disableGps() {
            //no-op
        }

        override fun setLocation(lat: Double, lon: Double) {
            //no-op
        }
    }

    override fun getKeyboard(adbServer: AdbServer): Keyboard = object : Keyboard {
        override fun typeText(text: String) {
            //no-op
        }

        override fun sendEvent(keyEvent: Int) {
            //no-op
        }
    }

    override fun getScreenshots(libLogger: UiTestLogger, activities: Activities): Screenshots = object : Screenshots {
        override fun take(tag: String) {
            //no-op
        }
    }

    override fun getAccessibility(): Accessibility = object : Accessibility {
        override fun enable(packageName: String, className: String) {
            //no-op
        }

        override fun disable() {
            //no-op
        }
    }

    override fun getHackPermissions(libLogger: UiTestLogger): HackPermissions = object : HackPermissions {
        override fun grant(packageName: String, permission: String): Boolean = false
    }

    override fun getExploit(adbServer: AdbServer, activities: Activities): Exploit = object : Exploit {
        override fun rotate() {
            //no-op
        }

        override fun setOrientation(deviceOrientation: Exploit.DeviceOrientation) {
            //no-op
        }

        override fun setAutoRotationEnabled(enabled: Boolean) {
            //no-op
        }

        override fun pressBack(failTestIfAppUnderTestClosed: Boolean) {
            //no-op
        }

        override fun pressHome(): Boolean = false
    }

    override fun getLanguage(libLogger: UiTestLogger): Language = object : Language {
        override fun switchInApp(locale: Locale) {
            //no-op
        }
    }

    override fun getLogcat(adbServer: AdbServer): Logcat = object : Logcat {
        override fun disableChatty() {
            //no-op
        }

        override fun setBufferSize(size: LogcatBufferSize) {
            //no-op
        }

        override fun setDefaultBufferSize() {
            //no-op
        }

        override fun clear(buffer: Logcat.Buffer) {
            //no-op
        }

        override fun readLogcatRows(
            excludePattern: String?,
            excludePatternIsIgnoreCase: Boolean,
            includePattern: String?,
            includePatternIsIgnoreCase: Boolean,
            buffer: Logcat.Buffer,
            rowLimit: Int?
        ): List<String> = emptyList()

        override fun readLogcatRows(
            excludePattern: String?,
            excludePatternIsIgnoreCase: Boolean,
            includePattern: String?,
            includePatternIsIgnoreCase: Boolean,
            buffer: Logcat.Buffer,
            rowLimit: Int?,
            readingBlock: (logcatRow: String) -> Boolean
        ): Boolean = false
    }

    override fun getObjectBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<ObjectBehaviorInterceptor> = mutableListOf(
        AutoScrollObjectBehaviorInterceptor(libLogger, autoScrollParams),
        UiObjectLoaderBehaviorInterceptor(libLogger),
        FlakySafeObjectBehaviorInterceptor(flakySafetyParams, libLogger)
    )

    override fun getDeviceBehaviourInterceptors(libLogger: UiTestLogger, adbServer: AdbServer, flakySafetyParams: FlakySafetyParams): MutableList<DeviceBehaviorInterceptor> =
        mutableListOf(
            FlakySafeDeviceBehaviorInterceptor(flakySafetyParams, libLogger)
        )

    override fun getViewBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<ViewBehaviorInterceptor> =
        mutableListOf(
            AutoScrollViewBehaviorInterceptor(autoScrollParams, libLogger),
            FlakySafeViewBehaviorInterceptor(flakySafetyParams, libLogger)
        )

    override fun getDataBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<DataBehaviorInterceptor> = mutableListOf(
        FlakySafeDataBehaviorInterceptor(flakySafetyParams, libLogger)
    )

    override fun getWebBehaviourInterceptors(
        libLogger: UiTestLogger,
        adbServer: AdbServer,
        autoScrollParams: AutoScrollParams,
        flakySafetyParams: FlakySafetyParams
    ): MutableList<WebBehaviorInterceptor> =
        mutableListOf(
            AutoScrollWebBehaviorInterceptor(autoScrollParams, libLogger),
            FlakySafeWebBehaviorInterceptor(flakySafetyParams, libLogger)
        )
}
