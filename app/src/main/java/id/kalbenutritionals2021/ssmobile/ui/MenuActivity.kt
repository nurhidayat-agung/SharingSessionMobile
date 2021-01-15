package id.kalbenutritionals2021.ssmobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.kalbenutritionals2021.ssmobile.R
import id.kalbenutritionals2021.ssmobile.util.Constants

class MenuActivity : AppCompatActivity() {
    lateinit var tvLoginMsg : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tvLoginMsg = findViewById(R.id.tv_login_msg)

        val message = intent.getStringExtra(Constants.ConfigTag.LoginMsg)

        tvLoginMsg.text = message
    }
}