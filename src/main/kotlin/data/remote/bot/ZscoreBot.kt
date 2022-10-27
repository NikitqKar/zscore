package data.remote.bot

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatAction
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.logging.LogLevel
import data.remote.repository.ZscoreRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.pow

private const val BOT_ANSWER_TIMEOUT = 30
private const val BOT_TOKEN = "5771800742:AAEcur8bzN-mJyqcvnU6PjEA2C9ejO-Hl40"
private const val GIF_WAITING_URL = "https://tenor.com/view/albert-einstein-lol-think-be-smart-think-wise-gif-8735407"

class ZscoreBot(private val repository: ZscoreRepository) {
    private var _cahtId: ChatId? = null
    private val chatId by lazy { requireNotNull(_cahtId) }

    fun createBot(): Bot {
        return bot {
            timeout = BOT_ANSWER_TIMEOUT
            token = BOT_TOKEN
            logLevel = LogLevel.Error
            dispatch {
                text { setUpCommands() }
            }
        }
    }

    private fun Dispatcher.setUpCommands() {
        command("start") {
            _cahtId = ChatId.fromId(message.chat.id)
            bot.sendMessage(
                chatId = chatId,
                text = "Hi there! \n for start"
            )
        }
        command("zscore") {
            CoroutineScope(Dispatchers.IO).launch {
                val seqList =  repository.getCurrentValue()
                bot.sendMessage(chatId = chatId, text =""" ${seqList}} """)
            }
        }
    }
}