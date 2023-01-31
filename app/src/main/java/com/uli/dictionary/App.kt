package com.uli.dictionary

import android.app.Application
import com.uli.data.local.localmodule.roomModule
import com.uli.data.remote.module.networkModule
import com.uli.data.remote.module.repoModule
import com.uli.domain.module.domainModule
import com.uli.main.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(domainModule, repoModule, networkModule, viewModelModule, roomModule)
        }
    }
}