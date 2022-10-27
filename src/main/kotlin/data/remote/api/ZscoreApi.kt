package data.remote.api

import data.remote.models.ResponseSubList
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ZscoreApi {
    @GET("hist?limit=20&sort=-1")
    fun getCurrentPrice(): Deferred<ResponseSubList>
}