/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.donates

import android.content.Context
import android.util.Base64
import kotlinx.coroutines.coroutineScope

object DonatesManager {

    val verifiedUserIds = mutableSetOf<Long>()
    val verifiedUserIdsMarketplace = mutableSetOf<Long>()

    suspend fun startAutoRefresh(context: Context, force: Boolean, fromIntegrityChecker: Boolean) = coroutineScope {
        // No-op in Opengram: privacy-friendly, zero external tracker/donates pings.
    }

    fun checkAllDonatedAccounts(): Boolean = true

    fun didUserDonate(userId: Long): Boolean = false

    fun didUserDonate2(userId: Long): Boolean = false

    fun didUserDonateForFeature(): Boolean = true

    fun checkAllDonatedAccountsForMarketplace(): Boolean = true

    fun didUserDonateForMarketplace(userId: Long): Boolean = false

    fun isUserBlocked(userId: Long): Boolean = false

    fun loadLocalTonUsdtRateSync(context: Context) {}

    suspend fun updateTonUsdtRate(context: Context) {}

    fun getTonUsdtRate(context: Context): Double = 0.0

    fun getTonAmountForUsd(context: Context, usdPrice: Double, marketplace: Boolean): Double = 0.0

    fun roundTo(value: Double, decimals: Int): Double = value

    fun donatesCounter(type: Int): Int = 0

    fun decodeBase64Array(parts: Array<String>): String {
        return try {
            val joined = parts.joinToString("")
            val decodedBytes = Base64.decode(joined, Base64.DEFAULT)
            String(decodedBytes)
        } catch (e: Exception) {
            ""
        }
    }
}
