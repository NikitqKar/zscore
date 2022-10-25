package jsonresponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(
    private val api: RetrofitServices
) {
    suspend fun getCurrentValue(): Response {
        return withContext(Dispatchers.IO) {
            api.getList()
        }.await()

    }
}