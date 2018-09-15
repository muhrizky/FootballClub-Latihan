package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.Team

interface TeamDetailView {
    fun  showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}