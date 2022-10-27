package data.remote.bot

import data.remote.repository.ZscoreRepository
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.api.telegramBot
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.types.ChatId
import kotlinx.coroutines.Job

private const val BOT_TOKEN = "5771800742:AAEcur8bzN-mJyqcvnU6PjEA2C9ejO-Hl40"
private const val GIF_WAITING_URL = "https://tenor.com/view/albert-einstein-lol-think-be-smart-think-wise-gif-8735407"

class ZscoreBot(private val repository: ZscoreRepository) {
    private lateinit var chatId: ChatId

    suspend fun createBot(): Job {
        val bot = telegramBot(BOT_TOKEN)

        return bot.buildBehaviourWithLongPolling(
            defaultExceptionsHandler = { it.printStackTrace() }
        ) {
            onCommand("start") {
                chatId = it.chat.id
                bot.sendTextMessage(
                    chatId = chatId,
                    text = "Hi there! \n for start"
                )
            }
            onCommand("zscore") {
                val seqList = repository.getCurrentValue()

                bot.sendTextMessage(
                    chatId = chatId,
                    text = """ ${seqList}} """
                )
            }
        }
    }
}
