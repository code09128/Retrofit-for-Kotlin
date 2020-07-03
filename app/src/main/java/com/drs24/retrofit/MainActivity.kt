package com.drs24.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.drs24.retrofit.Data.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitClient: RetrofitClient = RetrofitClient()

//        retrofitClient.getService().login(LoginRequest("admin","000000")).enqueue(object :
//            Callback<LoginResponse>{
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//            }
//
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                val status:String = response.body()!!.Status
//                TOKEN = "bearer "+response.body()!!.Result.AuthorizationToken
//
//                Log.e("response",""+ response.code())
//                Log.e("status",""+ status)
//                Log.e("token",""+ TOKEN)
//            }
//        })

        button.setOnClickListener {
            retrofitClient.getService().downList(TOKEN,DownloadListRequest("all"))
                .enqueue(object : Callback<DownloadListResponse> {
                    override fun onFailure(call: Call<DownloadListResponse>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<DownloadListResponse>,response: Response<DownloadListResponse>) {
                        val status: String = response.body()!!.Status
                        val dataList = response.body()!!.Result

                        Log.e("response", "" + response.code())
                        Log.e("DownloadListStatus", "" + status)
                        Log.e("DownloadListResponse", "" + dataList)
                    }
                })
        }

//        retrofitClient.getService().hospitalID().enqueue(object : Callback<HospitalID>{
//            override fun onFailure(call: Call<HospitalID>, t: Throwable) {
//            }
//
//            override fun onResponse(call: Call<HospitalID>, response: Response<HospitalID>) {
//                val dataList = response.body()!!.result
//
//                Log.e("response", "" + response.code())
//                Log.e("hospitalID", "" + dataList)
//            }
//        })

        retrofitClient.getService().hospitalDepartment("CA").enqueue(object : Callback<HospitalDepartmentResponse>{
            override fun onFailure(call: Call<HospitalDepartmentResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<HospitalDepartmentResponse>,response: Response<HospitalDepartmentResponse>) {
                val dataList = response.body()!!.result
                val status: String = response.body()!!.status

                Log.e("response", "" + response.code())
                Log.e("HospitalDepartmentStatus", "" + status)
                Log.e("HospitalDepartmentResponse", "" + dataList)

            }
        })
    }
}