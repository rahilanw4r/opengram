/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.core.configs

import android.app.Activity
import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.telegram.messenger.ApplicationLoader
import org.telegram.messenger.MessageObject
import org.telegram.messenger.SamsungDatastore
import org.telegram.messenger.UserConfig
import uz.unnarsx.cherrygram.Extra
import uz.unnarsx.cherrygram.core.CherrygramLogger
import uz.unnarsx.cherrygram.core.firebase.FirebaseAnalyticsHelper
import uz.unnarsx.cherrygram.core.helpers.MessageLoader
import uz.unnarsx.cherrygram.donates.DonatesManager
import uz.unnarsx.cherrygram.preferences.boolean

object CherrygramPrivacyConfig: CoroutineScope by CoroutineScope(
    context = SupervisorJob() + Dispatchers.Default
) {

    private val sharedPreferences: SharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", Activity.MODE_PRIVATE)

    /** Privacy start */
    var hideProxySponsor by sharedPreferences.boolean("SP_NoProxySponsor", true)
    var googleAnalytics by sharedPreferences.boolean("SP_GoogleAnalytics1", false)

    /** Ghost Mode & Stealth start */
    var stealthReadMessages by sharedPreferences.boolean("SP_StealthReadMessages", false)
    var hideTypingStatus by sharedPreferences.boolean("SP_HideTypingStatus", false)
    var hideStoryViews by sharedPreferences.boolean("SP_HideStoryViews", false)
    var allowScreenshotsAnywhere by sharedPreferences.boolean("SP_AllowScreenshotsAnywhere", true)
    var antiDeleteMessages by sharedPreferences.boolean("SP_AntiDeleteMessages", true)
    /** Ghost Mode & Stealth finish */
    /** Privacy finish */

    /** Passcode lock start */
    var hideArchiveFromChatsList by sharedPreferences.boolean("SP_HideArchiveFromChatsList", false)
    var askBiometricsToOpenArchive by sharedPreferences.boolean("SP_AskBiometricsToOpenArchive", false)
    var askBiometricsToOpenEncrypted by sharedPreferences.boolean("SP_AskBiometricsToOpenEncrypted", false)
    var askBiometricsToOpenChat by sharedPreferences.boolean("SP_AskBiometricsToOpenChat", false)
    var askPasscodeBeforeDelete by sharedPreferences.boolean("SP_AskPinBeforeDelete", false)
    var allowSystemPasscode by sharedPreferences.boolean("SP_AllowSystemPasscode", false)
    /** Passcode lock finish */

    /** Misc **/
    var hideArchivedStories by sharedPreferences.boolean("CP_HideArchivedStories", false)
    /** Misc **/

    fun init() {
        FirebaseAnalyticsHelper.trackEventWithEmptyBundle("cg_start")

        val account = UserConfig.selectedAccount
        if (!UserConfig.getInstance(account).isClientActivated) return
    }

}