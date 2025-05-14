package ir.company.goldproject.remote.Time

import ir.company.goldproject.remote.dataModel.timeModel.DateModel
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApiService {

    @GET("date/now")
    fun getTime(
        @Query("short") short:Boolean
    ): retrofit2.Call<DateModel>

}