package jsonresponse

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("hist?limit=20&sort=-1")
    fun getList(): Deferred<Response>
}