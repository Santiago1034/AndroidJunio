package com.example.agroexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.internal.ContextUtils.getActivity
import org.json.JSONObject


class Iniciar_SesionActivity : AppCompatActivity() {

    companion object{
        private lateinit var ejemplo : String
    }
    private lateinit var textDocumento : EditText
    private lateinit var textContrasena : EditText
    private lateinit var btnIngresar : Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)


        textDocumento =findViewById(R.id.ingresoDocumento)
        textContrasena =findViewById(R.id.ingresoContrasena)
        btnIngresar=findViewById(R.id.btnIniciarSecion)

        btnIngresar.setOnClickListener {
            val username = textDocumento.text.toString()
            val password = textContrasena.text.toString()

            val url = "http://192.168.1.67:8080/Ingresar"

            val params = JSONObject()
            params.put("documento", username)
            params.put("contraseña", password)

            val jsonRequest = JsonObjectRequest(Request.Method.POST, url, params,
                Response.Listener { response ->

                    // Resto del código para manejar la respuesta JSON válida
                    val message = response.getString("message")
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                    if (message == "Login Exitoso") {
                        val intent = Intent(this, PruebaNavActivity::class.java)
                        startActivity(intent)
                    }
                },
                Response.ErrorListener { error ->

                    Log.e("error", "$error")
                    Toast.makeText(this, "$error", Toast.LENGTH_SHORT).show()

                })

            // Agregar la solicitud a la cola de solicitudes de Volley
            Volley.newRequestQueue(this@Iniciar_SesionActivity).add(jsonRequest)
        }
        }
    }






