package data.remote.repository

import data.remote.api.ZscoreApi
import data.remote.models.Response
import data.remote.models.ResponseSubList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ZscoreRepository(private val api: ZscoreApi) {
    suspend fun getCurrentValue(): ResponseSubList {
        return withContext(Dispatchers.IO) {
            api.getCurrentPrice()
        }.await()

    }
}
