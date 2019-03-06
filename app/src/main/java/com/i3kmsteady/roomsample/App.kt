package com.i3kmsteady.roomsample

import android.app.Application
import com.facebook.stetho.Stetho

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(
                    Stetho.defaultDumperPluginsProvider(this)
                )
                .enableWebKitInspector(
                    Stetho.defaultInspectorModulesProvider(this)
                )
                .build()
        )
    }
}