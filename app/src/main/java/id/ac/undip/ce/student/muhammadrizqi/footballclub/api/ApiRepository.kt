package id.ac.undip.ce.student.muhammadrizqi.footballclub.api

import java.net.URL

class ApiRepository {
    fun doRequest(url:String): String{
        return URL(url).readText()
    }
}