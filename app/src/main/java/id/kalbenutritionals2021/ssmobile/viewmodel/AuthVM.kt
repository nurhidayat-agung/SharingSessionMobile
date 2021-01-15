package id.kalbenutritionals2021.ssmobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.kalbenutritionals2021.ssmobile.model.RespCheckVersion
import id.kalbenutritionals2021.ssmobile.model.RespLogin
import id.kalbenutritionals2021.ssmobile.repo.AuthRepo
import id.kalbenutritionals2021.ssmobile.util.Constants
import id.kalbenutritionals2021.ssmobile.util.absoluteToJson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthVM(private val repo : AuthRepo) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val gson = Gson()
    val resultCekversi = MutableLiveData<String>()
    var resultLogin = ""
    val validLogin = MutableLiveData<Boolean>()

    fun checkVersion() {
        disposables.add(
            repo.checkVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {

                }.doOnComplete {

                }.doOnError {

                }.subscribe({
                    if (it.objData != null) {
                        val objData = absoluteToJson(it.objData)
                        val resCheckVersion =
                            gson.fromJson(absoluteToJson(it.objData), RespCheckVersion::class.java)
                        if (resCheckVersion != null) {
                            if (resCheckVersion.txtVersion?.equals(Constants.ConfigTag.txtVersion)!!)
                            {
                                // versi sama
                                resultCekversi.value = "version up to date"
                            }
                            else
                            {
                                // versi berbeda
                                resultCekversi.value = "version outdate"
                            }

                        } else {

                        }
                    } else {

                    }
                }, {

                })
        )
    }

    fun login(username: String, pass: String) {
        disposables.add(
            repo.login(username,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {

                }.doOnComplete {

                }.doOnError {

                }.subscribe({
                    if (it.objData != null) {
                        val objData = absoluteToJson(it.objData)
                        val respLogin: List<RespLogin?>? = gson.fromJson(
                            absoluteToJson(it.objData),
                            object : TypeToken<List<RespLogin?>?>() {}.type
                        )

                        if (respLogin?.isNotEmpty()!!)
                        {
                            resultLogin = respLogin.firstOrNull()?.pstrArgument.toString()
                            validLogin.value = respLogin.firstOrNull()?.pboolValid == 1
                        }

                    } else {

                    }
                }, {

                })
        )
    }

}