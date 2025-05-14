package ir.company.goldproject.remote

import ir.company.goldproject.remote.Golds.GoldsApiService
import ir.company.goldproject.remote.Time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainRetrofitService {

    private const val url = "https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: TimeApiService = retrofit.create(TimeApiService::class.java)
    val GoldApiService: GoldsApiService = retrofit.create(GoldsApiService::class.java)

}