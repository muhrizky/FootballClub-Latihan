package id.ac.undip.ce.student.muhammadrizqi.footballclub.main

import com.google.gson.Gson
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.ApiRepository
import id.ac.undip.ce.student.muhammadrizqi.footballclub.api.TheSportDBApi
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.Team
import id.ac.undip.ce.student.muhammadrizqi.footballclub.model.TeamResponse
import id.ac.undip.ce.student.muhammadrizqi.footballclub.TestContextProvider
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class TeamsPresenterTest {
    @Mock
    private
    lateinit var view: TeamsView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamList() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getteamList(league)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showTeamList(teams)
        Mockito.verify(view).hideLoading()
    }

}