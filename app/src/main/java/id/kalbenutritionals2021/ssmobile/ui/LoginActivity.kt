package id.kalbenutritionals2021.ssmobile.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.gson.Gson
import id.kalbenutritionals2021.ssmobile.R
import id.kalbenutritionals2021.ssmobile.model.general.DeviceInfo
import id.kalbenutritionals2021.ssmobile.repo.AuthRepo
import id.kalbenutritionals2021.ssmobile.util.Constants
import id.kalbenutritionals2021.ssmobile.util.SharedPref
import id.kalbenutritionals2021.ssmobile.viewmodel.AuthVM
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel



class LoginActivity : AppCompatActivity() {
    private val sharedPref = get<SharedPref>()
    lateinit var btnLogin : Button
    lateinit var edtUsername : EditText
    lateinit var edtPass : EditText
    private val vm by viewModel<AuthVM>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin = findViewById(R.id.btn_login)
        edtUsername = findViewById(R.id.edt_username)
        edtPass = findViewById(R.id.edt_pass)

        setDeviceInfo()

        btnLogin.setOnClickListener { view ->
            val username = edtUsername.text.toString()
            val pass = edtPass.text.toString()

            // offline
//            if (username == "user" && pass == "pass")
//            {
//                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
//                startActivity(intent)
//            }
//            else
//            {
//                Toast.makeText(this@LoginActivity,"login invalid",Toast.LENGTH_SHORT).show()
//            }


            // online
            vm.login(username, pass)

        }

        vm.resultCekversi.observe(this@LoginActivity, Observer {
            if (it.isNotBlank())
            {
                Toast.makeText(this@LoginActivity, it.toString(),Toast.LENGTH_SHORT).show()
            }
        })

        vm.validLogin.observe(this@LoginActivity, Observer {
            if (it ==true)
            {
                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                intent.putExtra(Constants.ConfigTag.LoginMsg,vm.resultLogin)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@LoginActivity,"invalid login",Toast.LENGTH_SHORT).show()
            }
        })

        vm.checkVersion()
    }


    private fun setDeviceInfo() {
        val manufacturer = Build.MANUFACTURER // samsungs
        val model = Build.MODEL // sm bla bla
        val version = Build.VERSION.SDK_INT // 29
        val versionRelease = Build.VERSION.RELEASE // 10
        val deviceInfo = DeviceInfo(
            product = manufacturer,
            versionSdk = version.toString(),
            osVersion = versionRelease.toString(),
            model = model,
            device = "$manufacturer-$model"
        )
        val gson = Gson()
        val deviceInfoString = gson.toJson(deviceInfo)
        sharedPref.putString(Constants.DeviceTag.deviceInfo, deviceInfoString)
    }
}