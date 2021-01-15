package id.kalbenutritionals2021.ssmobile.repo

import android.annotation.SuppressLint
import com.google.gson.Gson
import id.kalbenutritionals2021.ssmobile.model.ReqCheckVersion
import id.kalbenutritionals2021.ssmobile.model.general.ObjRequestData
import id.kalbenutritionals2021.ssmobile.model.ReqLogin
import id.kalbenutritionals2021.ssmobile.model.general.clsGlobalAPI
import id.kalbenutritionals2021.ssmobile.network.AuthService
import id.kalbenutritionals2021.ssmobile.util.Constants
import id.kalbenutritionals2021.ssmobile.util.SharedPref
import id.kalbenutritionals2021.ssmobile.util.getDateTimeNow
import io.reactivex.Observable
import java.text.SimpleDateFormat

class AuthRepo(private val sharedPref: SharedPref, private val authService : AuthService)
{
    @SuppressLint("SimpleDateFormat")
    fun checkVersion() : Observable<clsGlobalAPI> {
        val postReq = clsGlobalAPI().CreateBlankclsGlobalAPI()
        postReq.txtProgramCode = Constants.ConfigTag.programCode
        postReq.txtFunction = Constants.EndPointTag.checkVersion
        postReq.txtToken = sharedPref.getString(Constants.AuthTag.tagToken)
        val deviceInfo = sharedPref.getDeviceInfo()
        val reqCheckVersion = ReqCheckVersion(
            intVersionApp = "",
            txtStatus = "1",
            txtTypeApp = Constants.ConfigTag.txtTypeApp,
            txtVersion = Constants.ConfigTag.txtVersion
        )

        // val sdf = SimpleDateFormat(Constants.ConfigTag.dateFormat3)
        postReq.ProgramDat.dtInserted = SimpleDateFormat(Constants.ConfigTag.dateFormat3).parse(
            getDateTimeNow()
        )
        postReq.ProgramDat.dtUpdated = SimpleDateFormat(Constants.ConfigTag.dateFormat3).parse(
            getDateTimeNow()
        )

        val objReqData = ObjRequestData(deviceInfo = deviceInfo, data = reqCheckVersion)
        postReq.objRequestData = objReqData
        postReq.objData = objReqData

        val gson = Gson()
        val stringGson = gson.toJson(postReq);

        return authService.checkVersion(postReq)
    }

    fun login(username: String, password: String): Observable<clsGlobalAPI> {
        val postReq = clsGlobalAPI().CreateBlankclsGlobalAPI()
        postReq.txtProgramCode = Constants.ConfigTag.programCode
        postReq.txtFunction = Constants.EndPointTag.login
        val deviceInfo = sharedPref.getDeviceInfo()
        val reqLogin = ReqLogin(
            txtOutletCode = null,
            txtTypeMobile = Constants.ConfigTag.txtTypeApp,
            txtUserName = username,
            txtPassword = password,
            txtVersion = Constants.ConfigTag.txtVersion,
            txtBranchCode = "",
            intRole = "121",
            txtOutletName = "",
            txtDomain = Constants.AuthTag.domain,
            txtImeiNumber = deviceInfo.getMeta()
        )
        val objRequestData = ObjRequestData(deviceInfo = deviceInfo, data = reqLogin)
        postReq.objRequestData = objRequestData
        postReq.objData = objRequestData
        postReq.txtToken = sharedPref.getString(Constants.AuthTag.tagToken)
        // return api.postData(postReq)

        val gson = Gson()
        val stringGson = gson.toJson(postReq);
        return authService.loginMobile(postReq)
    }
}