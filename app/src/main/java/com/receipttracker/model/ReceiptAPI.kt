package com.receipttracker.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface MovieApi {

    @GET("location")

    fun getReceiptByBusiness(@Query("location")query:String, @Query("api_key")api_Key:String): Call<ReceiptOverview>



    class Factory {



        companion object {



         //   private const val BASE_URL = MovieConstants.BASE_URL



            fun create(): MovieApi {



                val logger = HttpLoggingInterceptor()

                logger.level = HttpLoggingInterceptor.Level.BASIC

                logger.level = HttpLoggingInterceptor.Level.BODY



                val okHttpClient = OkHttpClient.Builder()

                    .addInterceptor(logger)

                    .retryOnConnectionFailure(false)

                    .readTimeout(10, TimeUnit.SECONDS)

                    .connectTimeout(15, TimeUnit.SECONDS)

                    .build()



                val retrofit = Retrofit.Builder()

                    .client(okHttpClient)

        //            .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build()



                return retrofit.create(MovieApi::class.java)

            }

        }

    }



}