package id.ac.undip.ce.student.muhammadrizqi.footballclub.model

import com.google.gson.annotations.SerializedName

data class Team (
    @SerializedName("idTeam")
    var teamId : String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("StrTeamBadge")
    var teamBadge: String? =null,

    @SerializedName("intFormedYear")
    var teamFormedYear: String? = null,

    @SerializedName("strStadium")
    var teamStadium: String? = null,

    @SerializedName("strDescriptionEN")
    var teamDescription: String? = null
)
