package com.drs24.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by dustin0128 on 2020/7/1
 */
class RetrofitClient {
    private val TwbaseUrl = "http://140.112.117.56/" //台大
    private val trans = "https://www.scmh.org.tw/APIs/TransAPI/"//轉診

    fun getService():ApiInterface{
        val retrofit = Retrofit.Builder()
            .baseUrl(trans) //設定請求URL
            .addConverterFactory(GsonConverterFactory.create()) //設定解析工具，這裡使用Gson解析
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}