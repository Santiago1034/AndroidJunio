package com.example.agroexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import com.example.agroexpress.Iniciar_SesionActivity.Companion.ejemplo

class HomeActivity : AppCompatActivity() {

    val ejemplo2 = ejemplo

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        screenSplash.setKeepOnScreenCondition{false}

       val bntRegistar:Button = findViewById(R.id.RegistarUsuario)
        bntRegistar.setOnClickListener{
            val intent: Intent = Intent(this,RegistrarActivity :: class.java)
            startActivity(intent)
        }

        val bntIniciarSesion:Button = findViewById(R.id.IniciarSesionHome)
        bntIniciarSesion.setOnClickListener{
            val intent: Intent = Intent(this,Iniciar_SesionActivity :: class.java)
            startActivity(intent)
        }




    }




}