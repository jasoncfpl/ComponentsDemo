package com.example.testcomponentsapplication.router

import android.content.Context
import android.content.Intent

object SimpleRouter {


    private val routes = HashMap<String, Class<*>>()

    fun putRoute(path: String, clazzName: String) {
        routes[path] = Class.forName(clazzName)
    }

    fun getNavigationClass(path: String) :Class<*>? {
        return routes[path]
    }

    fun navigation(context: Context, path: String) {
        val clazz = routes[path]
        if (clazz != null) {
            val intent = Intent(context,clazz)
            context.startActivity(intent)
        }
    }


}