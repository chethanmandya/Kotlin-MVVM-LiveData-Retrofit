package com.chethan.demoproject


import retrofit2.Call
import retrofit2.http.GET

interface NetWorkApi{

    @GET("/")
    fun getProducts(): Call<List<ProductFamily>>

}