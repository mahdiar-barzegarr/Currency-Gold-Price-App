package ir.company.goldproject.remote.Time

import ir.company.goldproject.remote.dataModel.timeModel.DateModel

interface TimeRequest {
    fun onSuccess(data: DateModel)

    fun onNotSuccess(message: String)

    fun onError(error: String)

}