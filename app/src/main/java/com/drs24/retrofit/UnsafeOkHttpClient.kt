package com.drs24.retrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.io.InputStream
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 * Created by dustin0128 on 2020/7/8
 */
class UnsafeOkHttpClient {
    private var client: OkHttpClient = OkHttpClient()

    init {
        val trustManager = trustManagerForCertificates(trustedCertificatesInputStream())
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf<TrustManager>(trustManager!!), null)
        val sslSocketFactory = sslContext.socketFactory

        client = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustManager)
            .build()
    }

    /**
     * Returns an input stream containing one or more certificate PEM files. This implementation just
     * embeds the PEM files in Java strings; most applications will instead read this from a resource
     * file that gets bundled with the application.
     */
    private fun trustedCertificatesInputStream(): InputStream? {
        return null// Full source omitted. See sample.
    }

    private fun trustManagerForCertificates(inputStream: InputStream?): X509TrustManager? {
        return null// Full source omitted. See sample.
    }

}