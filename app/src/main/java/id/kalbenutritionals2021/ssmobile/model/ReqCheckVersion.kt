package id.kalbenutritionals2021.ssmobile.model

import com.google.gson.annotations.SerializedName

data class ReqCheckVersion(

	@field:SerializedName("txtTypeApp")
	val txtTypeApp: String? = null,

	@field:SerializedName("intVersionApp")
	val intVersionApp: String? = null,

	@field:SerializedName("txtStatus")
	val txtStatus: String? = null,

	@field:SerializedName("txtVersion")
	val txtVersion: String? = null
)
