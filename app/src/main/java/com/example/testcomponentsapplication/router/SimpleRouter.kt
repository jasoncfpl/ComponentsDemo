package com.example.testcomponentsapplication.router

object SimpleRouter {


    private val routes = HashMap<String, Class<*>>()

    fun putRoute(path: String, clazzName: String) {
        routes[path] = Class.forName(clazzName)
    }

    fun navigation(path: String) :Class<*>? {
        return routes[path]
    }


}