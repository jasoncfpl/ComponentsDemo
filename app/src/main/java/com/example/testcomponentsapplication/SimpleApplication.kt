package com.example.testcomponentsapplication

import android.app.Application
import com.example.testcomponentsapplication.router.SimpleRouter


class SimpleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        SimpleRouter.putRoute("login","com.example.testcomponentsapplication.page.LoginActivity")
    }
}