package com.drs24.retrofit

import com.drs24.retrofit.Data.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by dustin0128 on 2020/7/1
 */
interface ApiInterface {
    @POST("api/User/GetAuthorizationToken")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    //    @Headers(
//        "Content-type:application/json",
//        "Authorization:bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjEiLCJBY2NvdW50TmFtZSI6IueuoeeQhuWToSIsInJvbGUiOiJBZG1pbiIsIkFjY291bnRIb3NwaXRhbENvZGUiOiIwMDAwMiIsIm5iZiI6MTU5MzU3NjAyOSwiZXhwIjoxNTkzOTM2MDI5LCJpYXQiOjE1OTM1NzYwMjl9.Mv8x1HGQysPV1n3bJotTKSrnwgMTCGLPoPz2F7xWZLrhPElI2syiKk-MYNuOxttj7CzpXCAuAguWYgzImdwpVA")
    @POST("api/CaseFile/GetListByCaseFile")
    fun downList(@Header("Authorization") authToken:String?,@Body downloadListRequest: DownloadListRequest): Call<DownloadListResponse>

    @GET("api/Account/GetHospID")
    fun hospitalID(): Call<HospitalID>

    @Headers(
        "Content-type:application/json",
        "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiIxMTM3MDIwNTExIiwiRXhwIjo2MzczMTg5MDQzNzc5NDgwNzJ9.6tAIg1FcXESLp2DFOkeUkd3Gmi4gOFPvwNpnzF2y50U"
    )
    @GET("api/Appointment/GetAllDepartment")
    fun hospitalDepartment(@Query("hospid") hospid:String):Call<HospitalDepartmentResponse>

}