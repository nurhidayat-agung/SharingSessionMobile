package id.kalbenutritionals2021.ssmobile.model

import com.google.gson.annotations.SerializedName

data class RespCheckVersion(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("StatusDownload")
	val statusDownload: String? = null,

	@field:SerializedName("_pstrMessage")
	val pstrMessage: String? = null,

	@field:SerializedName("_pstrArgument")
	val pstrArgument: String? = null,

	@field:SerializedName("TxtTypeApp")
	val txtTypeApp: String? = null,

	@field:SerializedName("IntVersionApp")
	val intVersionApp: String? = null,

	@field:SerializedName("IntVersionAppLink")
	val intVersionAppLink: Any? = null,

	@field:SerializedName("_pstrMethodRequest")
	val pstrMethodRequest: String? = null,

	@field:SerializedName("TxtVersion")
	val txtVersion: String? = null,

	@field:SerializedName("_pboolValid")
	val pboolValid: Int? = null,

	@field:SerializedName("TxtLinkApp")
	val txtLinkApp: String? = null,

	@field:SerializedName("IntTotal")
	val intTotal: Any? = null
)
