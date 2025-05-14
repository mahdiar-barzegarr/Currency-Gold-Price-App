package ir.company.goldproject.remote.Golds

import ir.company.goldproject.remote.GoldModel.GoldModel
import ir.company.goldproject.remote.dataModel.timeModel.DateModel
import retrofit2.http.GET

interface GoldsApiService {

    @GET("currencies")
    fun getGolds(): retrofit2.Call<GoldModel>

}