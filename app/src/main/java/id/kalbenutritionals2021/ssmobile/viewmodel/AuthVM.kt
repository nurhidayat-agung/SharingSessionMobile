package id.kalbenutritionals2021.ssmobile.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import id.kalbenutritionals2021.ssmobile.model.RespCheckVersion
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

}