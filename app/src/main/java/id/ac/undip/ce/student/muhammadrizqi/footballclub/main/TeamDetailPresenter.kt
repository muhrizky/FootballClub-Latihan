package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import com.google.gson.Gson
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.ApiRepository
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.TheSportDBApi
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailActivity, private val apiRepository: ApiRepository, private val gson: Gson) {
    fun getTeamDetail(teamId: String){
        view.showLoading()
        doAsync {
            val data= gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeamDetail(teamId)),
            TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }

}