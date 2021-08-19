package yuri.dyachenko.materialrecycler01

import java.util.*
import kotlin.random.Random

class NoteGenerator {

    companion object {

        fun getDefValues() = listOf(
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle()),
            Note(genId(), Date(), genTitle())
        )

        private val titles = arrayOf(
            "Новая парадигма реальности: младая поросль матереет!",
            "Оказывается, коронованный герцог графства определил дальнейшее развитие",
            "Воистину радостный звук: глас грядущего поколения",
            "Да, кровь стынет в жилах",
            "Частотность поисковых запросов сделала своё дело",
            "Мелочь, а приятно: зима близко",
            "Цена вопроса не важна, когда объемы выросли",
            "На двадцатом съезде партии прозвучало поразительное заявление: сложившаяся структура организации станет частью наших традиций"
        )

        fun genTitle(): String {
            val rand = Random.nextInt(titles.size)
            return titles[rand]
        }

        fun genId() = UUID.randomUUID().toString()
    }
}