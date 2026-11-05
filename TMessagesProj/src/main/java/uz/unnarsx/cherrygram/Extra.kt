package uz.unnarsx.cherrygram

import android.app.Activity
import android.content.Context
import org.telegram.tgnet.TLRPC

object Extra {
    const val SMS_HASH: String = ""

    fun getAppID(): Int = 4
    fun getAppHash(): String = "014b35b6184100b085b0d0572f9b5103"

    val XName_Arr: Array<String> = arrayOf("")
    val XName_ArrTwo: Array<String> = arrayOf("")
    val Name_Arr: Array<String> = arrayOf("")
    val Name_Arr2: Array<String> = arrayOf("")
    val Name_Arr3: Array<String> = arrayOf("")
    val Name_ArrTwo: Array<String> = arrayOf("")

    val HASH_ARRAY: Array<String> = arrayOf("")
    val APP_ARRAY: Array<String> = arrayOf("")
    val SMS_ARRAY: Array<String> = arrayOf("")

    val Name_ArrTwo1: Array<String> = arrayOf("")
    val Name_ArrTwo2: Array<String> = arrayOf("")
    val Name_ArrTwo3: Array<String> = arrayOf("")
    val Name_ArrTwo4: Array<String> = arrayOf("")
    val Name_ArrTwo5: Array<String> = arrayOf("")
    val Name_ArrTwo6: Array<String> = arrayOf("")

    val FILE_NAME_HASH: Array<String> = arrayOf("")
    val GITLAB_RAW_URL_HASH: Array<String> = arrayOf("")
    val FILE_NAME_MARKETPLACE_HASH: Array<String> = arrayOf("")
    val GITLAB_RAW_URL_MARKETPLACE_HASH: Array<String> = arrayOf("")
    val FILE_NAME_BLOCKED_HASH: Array<String> = arrayOf("")
    val GITLAB_RAW_URL_BLOCKED_HASH: Array<String> = arrayOf("")
    val FILE_NAME_BADGE_COLORS_HASH: Array<String> = arrayOf("")
    val GITLAB_RAW_URL_BADGE_COLORS_HASH: Array<String> = arrayOf("")
    val FILE_NAME_TON_RATE_HASH: Array<String> = arrayOf("")

    val VERIF_LOG: Array<String> = arrayOf("")
    val TG_BLOCKED_URL: Array<String> = arrayOf("")

    @JvmStatic
    val INSTANCE: Extra = this

    fun getProfileDC(context: Any?, user: TLRPC.User?, chat: TLRPC.Chat?): StringBuilder {
        val dcId = when {
            user?.photo != null -> user.photo.dc_id
            chat?.photo != null -> chat.photo.dc_id
            else -> 0
        }
        return if (dcId > 0) StringBuilder("DC $dcId") else StringBuilder()
    }

    @JvmOverloads
    fun getCountryByPhone(fragment: Any?, user: TLRPC.User?, isUnknown: Boolean = false): String {
        return ""
    }

    fun addBirthdayToCalendar(activity: Activity?, userId: Long) {
    }

    @JvmOverloads
    fun getRegistrationDate(fragment: Any?, userId: Long, chatId: Long = 0L): CharSequence? {
        return null
    }
}

