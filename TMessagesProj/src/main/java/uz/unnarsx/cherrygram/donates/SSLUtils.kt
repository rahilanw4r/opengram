/**
 * This is the source code of Opengram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 */
package uz.unnarsx.cherrygram.donates

import java.net.HttpURLConnection
import java.net.URL
import java.security.KeyStore
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

object SSLUtils {

    val socketFactory: SSLSocketFactory by lazy {
        val tmf = TrustManagerFactory.getInstance(
            TrustManagerFactory.getDefaultAlgorithm()
        )

        // null → system CA only
        tmf.init(null as KeyStore?)

        val trustManager = tmf.trustManagers
            .filterIsInstance<X509TrustManager>()
            .first()

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(trustManager), null)

        sslContext.socketFactory
    }

    fun openSecureConnection(url: URL): HttpURLConnection? {
        if (url.protocol != "https") {
            return null
        }

        val connection = url.openConnection() as HttpURLConnection

        if (connection is HttpsURLConnection) {
            connection.sslSocketFactory = socketFactory
        }

        connection.connectTimeout = 10000
        connection.readTimeout = 10000
//        connection.instanceFollowRedirects = false

        return connection
    }

}