package id.kalbenutritionals2021.ssmobile.model.general;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class mProgram implements Serializable {
    @SerializedName("intProgramID")
    public int intProgramID;
    @SerializedName("txtProgramCode")
    public String txtProgramCode;
    @SerializedName("txtProgramName")
    public String txtProgramName;
    @SerializedName("txtSolutionName")
    public String txtSolutionName;
    @SerializedName("txtSourceRepository")
    public String txtSourceRepository;
    @SerializedName("txtDescription")
    public String txtDescription;
    @SerializedName("bitActive")
    public boolean bitActive;
    @SerializedName("intDevelopmentYear")
    public int intDevelopmentYear;
    @SerializedName("intGoLiveYear")
    public int intGoLiveYear;
    @SerializedName("txtInsertedBy")
    public String txtInsertedBy;
    @SerializedName("dtInserted")
    public Date dtInserted;
    @SerializedName("txtUpdatedBy")
    public String txtUpdatedBy;
    @SerializedName("dtUpdated")
    public Date dtUpdated;
    @SerializedName("txtGUID")
    public String txtGUID;

    public mProgram() {
    }

    public static mProgram createBlankProgram() {
        mProgram mProgram = new mProgram();
        mProgram.intProgramID = 0;
        mProgram.txtProgramName = "";
        mProgram.bitActive = false;
        mProgram.txtDescription = "";
        mProgram.txtProgramCode = "";
        mProgram.txtSolutionName = "";
        mProgram.txtSourceRepository = "";
        mProgram.intDevelopmentYear = 0;
        mProgram.intGoLiveYear = 0;
        mProgram.txtInsertedBy = "";
        mProgram.dtInserted = new Date();
        mProgram.txtUpdatedBy = "";
        mProgram.dtUpdated = new Date();
        mProgram.txtGUID = "";
        return mProgram;
    }
}
