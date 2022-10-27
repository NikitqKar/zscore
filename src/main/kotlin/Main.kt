import data.remote.RetrofitClient
import data.remote.bot.ZscoreBot
import data.remote.repository.ZscoreRepository

fun main() {
    val retrofit = RetrofitClient().getRetrofit()
    val api = RetrofitClient().getResponseApi(retrofit)
    val repository = ZscoreRepository(api)
    val bot = ZscoreBot(repository).createBot()
    bot.startPolling()
}
