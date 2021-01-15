package id.kalbenutritionals2021.ssmobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import id.kalbenutritionals2021.ssmobile.R
import id.kalbenutritionals2021.ssmobile.repo.AuthRepo
import id.kalbenutritionals2021.ssmobile.util.SharedPref
import id.kalbenutritionals2021.ssmobile.viewmodel.AuthVM
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel



class LoginActivity : AppCompatActivity() {
    // private val sharedPref = get<SharedPref>()
    lateinit var btnLogin : Button
    lateinit var edtUsername : EditText
    lateinit var edtPass : EditText
    lateinit var sharedPref : SharedPref
    private val vm by viewModel<AuthVM>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin = findViewById(R.id.btn_login)
        edtUsername = findViewById(R.id.edt_username)
        edtPass = findViewById(R.id.edt_pass)



        btnLogin.setOnClickListener { view ->
            val username = edtUsername.text.toString()
            val pass = edtPass.text.toString()
            if (username == "user" && pass == "pass")
            {
                val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@LoginActivity,"login invalid",Toast.LENGTH_SHORT).show()
            }
        }
    }
}