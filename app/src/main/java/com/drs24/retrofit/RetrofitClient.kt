package com.drs24.retrofit

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import javax.net.ssl.*
import javax.security.cert.X509Certificate


/**
 * Created by dustin0128 on 2020/7/1
 */
class RetrofitClient {
    private val TwbaseUrl = "http://140.112.117.56/" //台大
    private val trans = "https://www.scmh.org.tw/APIs/TransAPI/"//轉診

    fun getService(context: Context): ApiInterface {
        val retrofit = Retrofit.Builder()
//            .client(getUnsafeOkHttpClient(context))
            .baseUrl(trans) //設定請求URL
            .addConverterFactory(GsonConverterFactory.create()) //設定解析工具，這裡使用Gson解析
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

    fun getUnsafeOkHttpClient(context: Context): OkHttpClient {
        val caFileInputStream: FileInputStream =
            context.assets.open("certificate.cer") as FileInputStream

        //從InputStream加載CA
        val cf: CertificateFactory = CertificateFactory.getInstance("X.509")
        val caInput: InputStream = BufferedInputStream(caFileInputStream)
        val ca: Certificate = caInput.use {
            cf.generateCertificate(it) as Certificate
        }

        //創建包含我們受信任的CA的密鑰庫
        val keyStoreType = KeyStore.getDefaultType()
        val keyStore = KeyStore.getInstance(keyStoreType).apply {
            load(null, null)
            setCertificateEntry("ca", ca)
        }

        val tmfAlgorithm: String = TrustManagerFactory.getDefaultAlgorithm()
        val tmf: TrustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm).apply {
            init(keyStore)
        }

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, tmf.trustManagers, null)

        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.socketFactory(sslContext.socketFactory)

        return httpClientBuilder.build()
    }
}