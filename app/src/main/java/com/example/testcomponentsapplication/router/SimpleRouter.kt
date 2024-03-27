package com.example.testcomponentsapplication.router

import android.app.Activity
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

    fun navigation(context: Context, postcard: Postcard, requestCode: Int = -1) {
        val destination = routes[postcard.path]
        if (destination != null) {
            val intent = Intent(context, destination).putExtras(postcard.bundle)
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            if (requestCode >= 0) {
                if (context is Activity) {
                    context.startActivityForResult(intent, requestCode)
                }
            } else {
                context.startActivity(intent)
            }
        }
    }


    fun build(path: String): Postcard {
        return Postcard(path)
    }


}