package data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import data.remote.api.ZscoreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api-pub.bitfinex.com/v2/candles/trade:1h:tBTCUSD/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    fun getResponseApi(retrofit: Retrofit) : ZscoreApi {
        return retrofit.create(ZscoreApi::class.java)
    }
}