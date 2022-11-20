package com.packagesmaster.ui.app

import android.app.Application
import com.packagesmaster.thememanager.ThemeManager

class AppController: Application() {

    override fun onCreate() {
        super.onCreate()
        ThemeManager()
    }
}