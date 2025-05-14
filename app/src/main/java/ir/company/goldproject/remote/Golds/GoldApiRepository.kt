package ir.company.goldproject.remote.Golds

import ir.company.goldproject.remote.GoldModel.GoldModel
import ir.company.goldproject.remote.MainRetrofitService
import ir.company.goldproject.remote.Time.TimeRequest
import ir.company.goldproject.remote.dataModel.timeModel.DateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoldApiRepository private constructor(){

    companion object{
        private var apiRepository: GoldApiRepository? = null

        val instance: GoldApiRepository
            get(){
                if (apiRepository == null) apiRepository = GoldApiRepository()
                return apiRepository!!
            }
    }

    fun getGolds(
        request: GoldRequest
    ){

        MainRetrofitService.GoldApiService.getGolds().enqueue(

            object : Callback<GoldModel>{
                override fun onResponse(call: Call<GoldModel>, response: Response<GoldModel>) {

                    if(response.isSuccessful){
                        val data = response.body() as GoldModel
                        request.onSuccess(data)
                    }else{
                        request.onNotSuccess("Not success")
                    }

                }

                override fun onFailure(call: Call<GoldModel>, t: Throwable) {
                    request.onError("Error : ${t.message}")
                }

            }


        )


    }


}