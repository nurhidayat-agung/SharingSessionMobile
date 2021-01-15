package id.kalbenutritionals2021.ssmobile.model.general;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class clsGlobalAPI implements Serializable {
    @SerializedName("txtToken")
    public String txtToken;
    @SerializedName("ProgramDat")
    public mProgram ProgramDat;
    @SerializedName("txtUsername")
    public String txtUsername;
    @SerializedName("txtLangID")
    public String txtLangID;
    @SerializedName("txtProgramCode")
    public String txtProgramCode;
    @SerializedName("txtFunction")
    public String txtFunction;
    @SerializedName("objRequestData")
    public Object objRequestData;
    @SerializedName("bitSuccess")
    public boolean bitSuccess;
    @SerializedName("objData")
    public Object objData;
    @SerializedName("txtMessage")
    public String txtMessage;
    @SerializedName("bitError")
    public boolean bitError;
    @SerializedName("txtErrorMessage")
    public String txtErrorMessage;
    @SerializedName("txtGUID")
    public String txtGUID;
    @SerializedName("txtStackTrace")
    public String txtStackTrace;

    public clsGlobalAPI() {
    }

    public clsGlobalAPI CreateBlankclsGlobalAPI() {
        clsGlobalAPI clsGlobalAPI = new clsGlobalAPI();
        clsGlobalAPI.txtToken = "";
        clsGlobalAPI.txtUsername = "";
        clsGlobalAPI.txtLangID = "";
        clsGlobalAPI.txtProgramCode = "";
        clsGlobalAPI.txtFunction = "";
        clsGlobalAPI.objRequestData = null;
        clsGlobalAPI.bitSuccess = false;
        clsGlobalAPI.objData = null;
        clsGlobalAPI.txtMessage = "";
        clsGlobalAPI.bitError = false;
        clsGlobalAPI.txtErrorMessage = "";
        clsGlobalAPI.txtStackTrace = "";
        clsGlobalAPI.txtGUID = "";
        clsGlobalAPI.ProgramDat = mProgram.createBlankProgram();
        return clsGlobalAPI;
    }
}
