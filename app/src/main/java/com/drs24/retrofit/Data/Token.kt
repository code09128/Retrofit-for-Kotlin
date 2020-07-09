package com.drs24.retrofit.Data

import com.google.gson.annotations.SerializedName

/**
 * 我們將 Request & Response 所需送出或接收的資料製成 Data Class
 */

data class LoginRequest(val account: String, val password: String)
data class DownloadListRequest(val type: String)

data class HospitalID(val result: List<HospitalData>)
data class HospitalData(val areaName: String,val areaId: String)

data class HospitalDepartmentResponse(val result: List<DepartmentData>,val status:String)
data class DepartmentData(val departmentCode: String, val department: String ,val divisions: List<DivisionsData>)
data class DivisionsData(val dept: String, val dnam: String)

data class LoginResponse(val Status: String, val Result: ResultData)
data class ResultData(val AuthorizationToken: String)

data class DownloadListResponse(val Status: String, val Result: List<ListData>)

data class ListData(
    val Id: Int,
    val MedicalRecordNo: String,
    val Name: String,
    val DiseaseCategory: String,
    val MainNurseId: Int,
    val MainNurseName: String
)

var TOKEN: String = ""

//data class Token(
//    @SerializedName("status")
//    val status: Int,
//    @SerializedName("AuthorizationToken")
//    val token: String
//)