/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.core.configs

import android.app.Activity
import android.content.SharedPreferences
import androidx.annotation.Keep
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.telegram.messenger.ApplicationLoader
import uz.unnarsx.cherrygram.core.helpers.CGResourcesHelper
import uz.unnarsx.cherrygram.preferences.boolean
import uz.unnarsx.cherrygram.preferences.int
import uz.unnarsx.cherrygram.preferences.long
import uz.unnarsx.cherrygram.preferences.string

@Keep
object CherrygramFirebaseConfig: CoroutineScope by CoroutineScope(
    context = SupervisorJob() + Dispatchers.Default
) {

    private val sharedPreferences: SharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", Activity.MODE_PRIVATE)

    /** Misc start */
    var useBrailleSpoiler by sharedPreferences.boolean("CG_UseBrailleSpoiler", false)

    var allowSafeStars by sharedPreferences.boolean("CG_AllowSafeStarsUI1", false)
    var allowSafeSurf by sharedPreferences.boolean("CG_AllowSafeSurfUI", false)
    var showAdsRandomly by sharedPreferences.boolean("CG_ShowAdsRandomly", false)

    var lastRemoteConfigCheckTime by sharedPreferences.long("CG_LastRemoteConfigCheckTime", 0)

    var showProxyInSettings by sharedPreferences.boolean("CG_ShowProxyInSettings", false)
    var proxyURL by sharedPreferences.string("CP_ProxyURL", "")
    /** Misc finish */

    /** Deleted Gifts start */
    var showDeletedGifts by sharedPreferences.boolean("CG_ShowDeletedGifts", false)
    var deletedGiftsConfigURL by sharedPreferences.string("CG_DeletedGiftsConfigURL", "")
    var deletedGiftsStickerPackName by sharedPreferences.string("CG_DeletedGiftsStickerPackLink", "Opengram_HiddenGifts")
    var deletedGiftsStickerPackOffset by sharedPreferences.int("CG_DeletedGiftsStickerpackOffset", 0)
    /** Deleted Gifts finish */

    fun init() {
        launch {
            try {
                FirebaseApp.initializeApp(ApplicationLoader.applicationContext)
                FirebaseCrashlytics.getInstance().isCrashlyticsCollectionEnabled = true
                Firebase.analytics.setUserProperty("opengram_version", CGResourcesHelper.getCherryVersion())
                Firebase.analytics.setUserProperty("code_version", CGResourcesHelper.getCodeVersion())
                Firebase.analytics.setUserProperty("source_code_version", CGResourcesHelper.getSourceCodeVersion())
            } catch (e: Exception) {
                // Ignore initialization errors
            }
        }
    }

}
