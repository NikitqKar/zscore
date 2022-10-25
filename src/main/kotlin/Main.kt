import jsonresponse.*
import retrofit2.Call
import retrofit2.Callback

fun main() {
    val retrofit = RetrofitClient().getRetrofit()
    val api = RetrofitClient().getResponseApi(retrofit)
    val repository = Repository(api)
    val bot = ZscoreBot(repository).createBot()
    bot.startPolling()
}
