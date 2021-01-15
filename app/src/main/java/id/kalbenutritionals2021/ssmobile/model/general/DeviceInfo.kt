package id.kalbenutritionals2021.ssmobile.model.general

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DeviceInfo(

        @field:SerializedName("product")
        val product: String? = null,

        @field:SerializedName("version_sdk")
        val versionSdk: String? = null,

        @field:SerializedName("os_version")
        val osVersion: String? = null,

        @field:SerializedName("model")
        val model: String? = null,

        @field:SerializedName("device")
        val device: String? = null

): Serializable {
    fun getMeta():String
    {
        return product + "_" + model + "_" + versionSdk + "_" + osVersion
    }
}