package ir.company.goldproject.remote.Golds

import ir.company.goldproject.remote.GoldModel.GoldModel

interface GoldRequest {
    fun onSuccess(data: GoldModel)

    fun onNotSuccess(message: String)

    fun onError(error: String)

}