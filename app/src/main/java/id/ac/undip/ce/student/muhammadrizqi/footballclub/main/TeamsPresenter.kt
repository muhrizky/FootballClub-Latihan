package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import com.google.gson.Gson
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.ApiRepository
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.TeamResponse
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import id.ac.undip.ce.student.muhammadrizqi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter(
        private val view: TeamsView,
        private val apiRepository: ApiRepository,
        private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getteamList(league: String?){
        view.showLoading()

        async(context.main){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }
    }
}