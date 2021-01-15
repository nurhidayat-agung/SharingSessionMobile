package id.kalbenutritionals2021.ssmobile.util

object Constants {

    object EndPointTag {
        const val downloadData = "FPRS_SqlLiteGenerator"
        const val logout = "FPRS_logOutMobile"
        const val checkVersion = "FPRS_checkVersion"
        const val cekRole = "FPRS_checkRole"
        const val login = "FPRS_loginMobile"
        const val pushData = "FPRS_pushDataSPGMobile"
        const val getHistoryAbsent = "FPRS_getHistoryAbsent"
        const val getCustomerHistoryAbsent = "FPRS_getCustomerHistoryAbsent"
    }

    object AuthTag {
        const val client_grant_type = "client_credentials"
        const val loginSession = "loginSession"
        const val userRoleID = "userRoleID"
        const val userRole = "userRole"
        const val emplID = "emplID"
        const val domain = "KALBEFOOD.LOCAL"
        const val userLogin = "userLogin"
        const val isLogin = "isLogin"
        const val txtUserName = "txtUserName"
        const val grant_type = "password"
        const val usernameToken = "UDf9M7beWuu27RWZ6SC1/LYZwUsg=="
        const val passwordToken = "hbbWJp5EsnFizMpzE3RVfKIrT3wg=="
        const val tagToken = "tagToken"
        const val fireBaseToken = "fireBaseToken"
    }

    object DeviceTag
    {
        const val windowWidth = "windowWidth"
        const val deviceInfo = "deviceInfo"
    }

    object ConectionTag {
        const val timeOut = 300L // in second
        const val repeatPushDataService = 360000L // in milis 360000L
        // const val baseUrl = "http://appgwdev.kalbenutritionals.com/api/knglobal/"
        const val baseUrl = "https://apigw.kalbenutritionals.com/"
        // const val basePath = "t/kalbenutritionals.com/fprs/v1/"
        const val basePath = "t/kalbenutritionals.com/fprs/v2/"
    }

    object ConfigTag {
        const val LoginMsg = "LoginMsg"
        const val txtVersion = "Fennel 05.11.20"
        const val txtTypeApp = "FPRS Remastered"
        const val countTabAbsentHistoryData = 3
        const val serviceTag = "serviceTag"
        const val unLoginUser = "ghqp"
        const val onErrorReturn = "onErrorReturn"
        const val onErrorResumeNext = "onErrorResumeNext"
        const val roomDBName = "New_FPRS.database"
        const val AppName = "New_FPRS"
        const val dateFormat = "EEE, d MMM yyyy HH:mm:ss Z"
        const val dateFormat2 = "yyyy-MM-dd"
        const val dateFormat3 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        const val dateFormat4 = "dd - MMMM - yyyy"
        const val dateFormat5 = "dd/MM/yy"
        const val dateFormat6 = "yyyy-MM-dd HH:mm:ss"
        const val dateFormat7 = "HH:mm"
        const val dateFormat8 = "yyyy-MM-dd HH:mm:ss"
        const val programCode = "KNIS"
        // const val VersionApp = "AND.2018.003"
        // const val TxtTypeApp = "SPGMobile Native-Android-Enhance"
    }

}