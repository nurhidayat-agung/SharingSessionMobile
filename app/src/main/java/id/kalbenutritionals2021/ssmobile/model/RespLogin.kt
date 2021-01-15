package id.kalbenutritionals2021.ssmobile.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RespLogin(

    @field:SerializedName("ListOfMWebMenuAPI")
    val listOfMWebMenuAPI: List<ListOfMWebMenuAPIItem?>? = null,

    @field:SerializedName("DtLastLogin")
    val dtLastLogin: String? = null,

    @field:SerializedName("ListLOBSPG")
    val listLOBSPG: List<String?>? = null,

    @field:SerializedName("TxtBranchCode")
    val txtBranchCode: String? = null,

    @field:SerializedName("TxtUserName")
    val txtUserName: String? = null,

    @field:SerializedName("IntRadius")
    val intRadius: String? = null,

    @field:SerializedName("ListOftDownloadData_mobile")
    val listOftDownloadDataMobile: List<ListOftDownloadDataMobileItem?>? = null,

    @field:SerializedName("TxtSubmissonId")
    val txtSubmissonId: String? = null,

    @field:SerializedName("DtCheckOut")
    val dtCheckOut: Any? = null,

    @field:SerializedName("DtCheckIn")
    val dtCheckIn: Any? = null,

    @field:SerializedName("TxtOutletCode")
    val txtOutletCode: Any? = null,

    @field:SerializedName("txtNoPo")
    val txtNoPo: String? = null,

    @field:SerializedName("TxtUserId")
    val txtUserId: String? = null,

    @field:SerializedName("_pstrArgument")
    val pstrArgument: String? = null,

    @field:SerializedName("TxtEmpId")
    val txtEmpId: String? = null,

    @field:SerializedName("TxtPassword")
    val txtPassword: Any? = null,

    @field:SerializedName("ListOfmTypeSubmissionMobile")
    val listOfmTypeSubmissionMobile: Any? = null,

    @field:SerializedName("ListOfmEmployeeAreaCountConsumerMTD")
    val listOfmEmployeeAreaCountConsumerMTD: List<ListOfmEmployeeAreaCountConsumerMTDItem?>? = null,

    @field:SerializedName("txtNoSOH")
    val txtNoSOH: String? = null,

    @field:SerializedName("txtConsumerMTD")
    val txtConsumerMTD: Any? = null,

    @field:SerializedName("DatetimeNow")
    val datetimeNow: String? = null,

    @field:SerializedName("TDeviceInfoUser_mobile")
    val tDeviceInfoUserMobile: TDeviceInfoUserMobile? = null,

    @field:SerializedName("_pstrMessage")
    val pstrMessage: String? = null,

    @field:SerializedName("TxtName")
    val txtName: String? = null,

    @field:SerializedName("DtLogOut")
    val dtLogOut: Any? = null,

    @field:SerializedName("_pstrMethodRequest")
    val pstrMethodRequest: String? = null,

    @field:SerializedName("IntTrackingMobile")
    val intTrackingMobile: String? = null,

    @field:SerializedName("TxtEmail")
    val txtEmail: String? = null,

    @field:SerializedName("txtNoSo")
    val txtNoSo: String? = null,

    @field:SerializedName("VisitPlanCheckIN")
    val visitPlanCheckIN: String? = null,

    @field:SerializedName("TxtDeviceId")
    val txtDeviceId: String? = null,

    @field:SerializedName("TxtRoleId")
    val txtRoleId: String? = null,

    @field:SerializedName("TxtCab")
    val txtCab: String? = null,

    @field:SerializedName("txtNoSOUT")
    val txtNoSOUT: String? = null,

    @field:SerializedName("TxtOutletName")
    val txtOutletName: Any? = null,

    @field:SerializedName("TxtPathImage")
    val txtPathImage: String? = null,

    @field:SerializedName("txtNoQTS")
    val txtNoQTS: String? = null,

    @field:SerializedName("ListOftrackingLocation_mobile")
    val listOftrackingLocationMobile: List<TrackingLocationItem?>? = null,

    @field:SerializedName("_pboolValid")
    val pboolValid: Int? = null,

    @field:SerializedName("TxtRoleName")
    val txtRoleName: String? = null,

    @field:SerializedName("txtNoKRS")
    val txtNoKRS: String? = null,

    @field:SerializedName("txtNoOVS")
    val txtNoOVS: String? = null,

    @field:SerializedName("TxtDataId")
    val txtDataId: String? = null
) : Serializable

data class ListOfMWebMenuAPIItem(

    @field:SerializedName("_pstrArgument")
    val pstrArgument: String? = null,

    @field:SerializedName("_pstrMessage")
    val pstrMessage: String? = null,

    @field:SerializedName("TxtDescription")
    val txtDescription: String? = null,

    @field:SerializedName("IntMenuID")
    val intMenuID: Int? = null,

    @field:SerializedName("ListOfMWebMenu")
    val listOfMWebMenu: List<Any?>? = null,

    @field:SerializedName("_pstrMethodRequest")
    val pstrMethodRequest: String? = null,

    @field:SerializedName("IntParentID")
    val intParentID: Int? = null,

    @field:SerializedName("IntOrder")
    val intOrder: Int? = null,

    @field:SerializedName("_pboolValid")
    val pboolValid: Int? = null,

    @field:SerializedName("TxtLink")
    val txtLink: String? = null,

    @field:SerializedName("TxtMenuName")
    val txtMenuName: String? = null
) : Serializable

data class ListOfmEmployeeAreaCountConsumerMTDItem(

    @field:SerializedName("_txtOutletCode")
    val txtOutletCode: String? = null,

    @field:SerializedName("_txtBranchCode")
    val txtBranchCode: String? = null,

    @field:SerializedName("_jumlah")
    val jumlah: Int? = null,

    @field:SerializedName("_txtBranchName")
    val txtBranchName: String? = null,

    @field:SerializedName("_txtOutletName")
    val txtOutletName: String? = null,

    @field:SerializedName("_txtRegionName")
    val txtRegionName: String? = null
) : Serializable

data class ListOftDownloadDataMobileItem(

    @field:SerializedName("_bitActive")
    val bitActive: Any? = null,

    @field:SerializedName("_intVersionApp")
    val intVersionApp: String? = null,

    @field:SerializedName("_txtRoleName")
    val txtRoleName: Any? = null,

    @field:SerializedName("_intRoleId")
    val intRoleId: Any? = null,

    @field:SerializedName("_txtOder")
    val txtOder: String? = null,

    @field:SerializedName("_dtUpdated")
    val dtUpdated: Any? = null,

    @field:SerializedName("_txtVersion")
    val txtVersion: String? = null,

    @field:SerializedName("_intModule")
    val intModule: String? = null,

    @field:SerializedName("_txtInserted")
    val txtInserted: Any? = null,

    @field:SerializedName("_txtUpdated")
    val txtUpdated: Any? = null,

    @field:SerializedName("_txtModuleName")
    val txtModuleName: String? = null,

    @field:SerializedName("_txtMasterData")
    val txtMasterData: String? = null,

    @field:SerializedName("_dtInserted")
    val dtInserted: Any? = null,

    @field:SerializedName("_txtMasterDataName")
    val txtMasterDataName: String? = null,

    @field:SerializedName("_txtTypeApp")
    val txtTypeApp: String? = null,

    @field:SerializedName("_intID")
    val intID: String? = null
) : Serializable

data class TDeviceInfoUserMobile(

    @field:SerializedName("TxtDeviceId")
    val txtDeviceId: Any? = null,

    @field:SerializedName("TxtDevice")
    val txtDevice: Any? = null,

    @field:SerializedName("TxtUserId")
    val txtUserId: Any? = null,

    @field:SerializedName("_pstrArgument")
    val pstrArgument: String? = null,

    @field:SerializedName("_pstrMessage")
    val pstrMessage: String? = null,

    @field:SerializedName("IdData")
    val idData: Any? = null,

    @field:SerializedName("_pstrMethodRequest")
    val pstrMethodRequest: String? = null,

    @field:SerializedName("TxtModel")
    val txtModel: Any? = null,

    @field:SerializedName("TxtVersion")
    val txtVersion: Any? = null,

    @field:SerializedName("_pboolValid")
    val pboolValid: Int? = null
) : Serializable

data class TrackingLocationItem(
    @field:SerializedName("IntId")
    val IntId: String? = null,

    @field:SerializedName("TxtLongitude")
    val TxtLongitude: String? = null,

    @field:SerializedName("TxtLatitude")
    val TxtLatitude: String? = null,

    @field:SerializedName("TxtAccuracy")
    val TxtAccuracy: String? = null,

    @field:SerializedName("Time")
    val Time: String? = null,

    @field:SerializedName("TxtUserId")
    val TxtUserId: String? = null,

    @field:SerializedName("TxtUsername")
    val TxtUsername: String? = null,

    @field:SerializedName("TxtRoleId")
    val TxtRoleId: String? = null,

    @field:SerializedName("TxtDeviceId")
    val TxtDeviceId:String?= null,

    @field:SerializedName("TxtBranchCode")
    val TxtBranchCode: String? = null,

    @field:SerializedName("TxtOutletCode")
    val TxtOutletCode: String? = null,

    @field:SerializedName("TxtNIK")
    val TxtNIK: String? = null,

    @field:SerializedName("IntSequence")
    val IntSequence: String? = null
) : Serializable

data class ReqLogOut(
    @field:SerializedName("txtDataId")
    val txtDataId: String? = null
): Serializable


data class RespLogOut(
    @field:SerializedName("_pstrMessage")
    val pstrMessage: String? = null,

    @field:SerializedName("_pstrArgument")
    val pstrArgument: String? = null,

    @field:SerializedName("_pstrMethodRequest")
    val pstrMethodRequest: String? = null,

    @field:SerializedName("_pboolValid")
    val pboolValid: Int? = null
): Serializable