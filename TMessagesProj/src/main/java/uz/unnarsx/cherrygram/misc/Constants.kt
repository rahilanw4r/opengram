/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.misc

import uz.unnarsx.cherrygram.core.configs.CherrygramCoreConfig

object Constants {

    @JvmField
    var CG_AUTHOR = "Opengram"

    /** CG Links start */
    @JvmField
    var CG_CHANNEL_USERNAME = ""
    @JvmField
    var CG_CHANNEL_URL = ""

    @JvmField
    var CG_APKS_CHANNEL_USERNAME = ""
    @JvmField
    var CG_APKS_CHANNEL_URL = ""

    @JvmField
    var CG_BETA_APKS_CHANNEL_USERNAME = ""
    @JvmField
    var CG_BETA_APKS_CHANNEL_URL = ""

    @JvmField
    var CG_CHAT_USERNAME = ""
    @JvmField
    var CG_CHAT_URL = ""

    @JvmField
    var CG_OFFTOPIC_CHAT_USERNAME = ""

    @JvmField
    var UPDATE_APP_URL = if (CherrygramCoreConfig.isPlayStoreBuild()) "https://play.google.com/store/apps/details?id=org.gram.messenger" else "https://github.com/rahilanw4r/opengram"

    @JvmField
    var CG_PRIVACY_URL = ""
    @JvmField
    var CG_DONATIONS_AND_TERMS_URL = ""

    @JvmField
    var CG_CROWDIN_URL = ""
    @JvmField
    var CG_GITHUB_URL = "https://github.com/rahilanw4r/opengram"
    /** CG Links finish */

    const val PACKAGE_NAME = "org.gram.messenger"

    /** CG Chats IDs start */
    const val Cherrygram_Channel = 0L
    const val Cherrygram_Support = 0L
    const val Cherrygram_APKs = 0L
    const val Cherrygram_Beta = 0L
    const val Cherrygram_Archive = 0L
    /** CG Chats IDs finish */

    /** Misc start */
    const val CHERRY_EMOJI_ID = 5220045200780458122L // Cherrygram logo
    const val CHERRY_EMOJI_ID_BRA = 5222458839256825177L // Cherrygram logo (bra)
    const val CHERRY_EMOJI_ID_VERIFIED = 5449476181864779205L // Cherrygram Verified adaptive logo
    const val CHERRY_EMOJI_ID_VERIFIED_BRA = 5451850156318181341L // Cherrygram Verified Bra adaptive logo
    const val CHERRY_EMOJI_ID_DONATE = 5411229175971322671L // Cherry emoji with eyeglasses
    const val CHERRY_EMOJI_ID_PREMIUM = 5393391313502609448L // Cherry emoji with stars
    const val CHERRY_EMOJI_ID_PREMIUM_MOON = 5370777017904011118L // Evil moon emoji
    const val PROFILE_BACKGROUND_COLOR_ID_GREEN_BLUE = 12 // Blue-Green gradient
    const val PROFILE_BACKGROUND_COLOR_ID_RED = 14 // Red-Pink gradient
    const val REPLY_BACKGROUND_COLOR_ID = 13 // Red-Pink gradient
    /** Misc finish */

}