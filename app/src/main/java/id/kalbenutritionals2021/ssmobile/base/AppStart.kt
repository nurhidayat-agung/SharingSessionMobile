package id.kalbenutritionals2021.ssmobile.base

import android.app.Application
import id.kalbenutritionals2021.ssmobile.context.kalbeApiModule
import id.kalbenutritionals2021.ssmobile.context.utilModule
import org.koin.android.ext.android.startKoin

class AppStart : Application() {
    override fun onCreate() {
        super.onCreate()

        // start koin
        startKoin(this@AppStart, listOf(kalbeApiModule, utilModule))
    }
}