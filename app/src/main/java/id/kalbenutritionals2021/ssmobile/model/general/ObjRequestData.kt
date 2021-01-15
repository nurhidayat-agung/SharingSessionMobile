package id.kalbenutritionals2021.ssmobile.model.general

import com.google.gson.annotations.SerializedName
import id.kalbenutritionals2021.ssmobile.model.general.DeviceInfo
import java.io.Serializable

data class ObjRequestData(

        @field:SerializedName("device_info")
        var deviceInfo: DeviceInfo? = null,

        @field:SerializedName("data")
        var data: Any? = null
): Serializable