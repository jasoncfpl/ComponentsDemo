package com.example.testcomponentsapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcomponentsapplication.router.Postcard
import com.example.testcomponentsapplication.router.SimpleRouter
import com.example.testcomponentsapplication.ui.theme.TestComponentsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComponentsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android")
                        routeButton()
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun routeButton() {
    val context= LocalContext.current
    Button(
        onClick = {
            Log.i("TAG", "Route: ")
            goLoginActivity(context)
       },
    ) {
        Text(
            text = "Button",
            modifier = Modifier
        )
    }
}

fun goLoginActivity(context: Context) {
    //根据路由跳转
    SimpleRouter.build("login")
        .withString("email","xxxxx@gmail.com")
        .navigation(context)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestComponentsApplicationTheme {
        Greeting("Android")
    }
}