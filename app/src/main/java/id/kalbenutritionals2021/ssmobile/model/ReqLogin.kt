package id.kalbenutritionals2021.ssmobile.model

import com.google.gson.annotations.SerializedName

data class ReqLogin(

	@field:SerializedName("txtOutletCode")
	val txtOutletCode: Any? = null,

	@field:SerializedName("txtTypeMobile")
	val txtTypeMobile: String? = null,

	@field:SerializedName("txtUserName")
	val txtUserName: String? = null,

	@field:SerializedName("txtOutletName")
	val txtOutletName: Any? = null,

	@field:SerializedName("txtBranchCode")
	val txtBranchCode: String? = null,

	@field:SerializedName("txtVersion")
	val txtVersion: String? = null,

	@field:SerializedName("intRole")
	val intRole: String? = null,

	@field:SerializedName("txtImeiNumber")
	val txtImeiNumber: String? = null,

	@field:SerializedName("txtDomain")
	val txtDomain: String? = null,

	@field:SerializedName("txtPassword")
	val txtPassword: String? = null
)
