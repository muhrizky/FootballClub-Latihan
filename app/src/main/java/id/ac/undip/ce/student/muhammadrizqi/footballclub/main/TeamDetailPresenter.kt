package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import com.google.gson.Gson
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.ApiRepository
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.TheSportDBApi
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.TeamResponse
import id.ac.undip.ce.student.muhammadrizqi.footballclub.util.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson, private val contextPool: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()

        async(contextPool.main){
            val data = bg{
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                        TeamResponse::class.java
                )
            }

            view.showTeamDetail(data.await().teams)
            view.hideLoading()
        }
    }
}