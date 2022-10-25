package jsonresponse

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.logging.LogLevel

private const val BOT_ANSWER_TIMEOUT = 30
private const val BOT_TOKEN = "5771800742:AAEcur8bzN-mJyqcvnU6PjEA2C9ejO-Hl40"

class ZscoreBot(private val repository: Repository) {

    private var _cahtId : ChatId? = null
    private val cahtId by lazy {    requireNotNull(_cahtId)}

    fun createBot() : Bot{
        return bot {
            timeout= BOT_ANSWER_TIMEOUT
            token = BOT_TOKEN
            logLevel = LogLevel.Error
            dispatch {
                text { setUpCommands() }
            }
        }
    }

    private fun Dispatcher.setUpCommands() {
        command("start"){
            _cahtId = ChatId.fromId(message.chat.id)
            bot.sendMessage(
                chatId = cahtId,
                text = "Hi there! \n for start"
            )
        }
    }
}