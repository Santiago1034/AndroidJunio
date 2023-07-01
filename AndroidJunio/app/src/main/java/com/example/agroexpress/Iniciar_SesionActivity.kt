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
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.internal.ContextUtils.getActivity


class Iniciar_SesionActivity : AppCompatActivity() {

    companion object{
        private lateinit var ejemplo : String
    }
    private lateinit var textDocumento : EditText
    private lateinit var textContraseña : EditText
    private lateinit var btnIngresar : Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)



        val bntRegistar: Button = findViewById(R.id.btnTextoRegistrar)
        bntRegistar.setOnClickListener{
           val intent: Intent = Intent(this,RegistrarActivity :: class.java)
            startActivity(intent)
        }

            this.textDocumento = findViewById(R.id.ingresoDocumento)
            this.textContraseña = findViewById(R.id.ingresoContraseña)
            this.btnIngresar = findViewById(R.id.btnIniciarSecion)
        ejemplo = textDocumento.text.toString()




        btnIngresar.setOnClickListener {
            val url = "http://192.168.88.149:8080/Ingresar/textDocumento/textContraseña"
            val queue = Volley.newRequestQueue(this)
            val resultPost = object : StringRequest(Request.Method.GET,url,
                Response.Listener< String>{ response ->
                    Toast.makeText(this,"Ingreso Exitoso", Toast.LENGTH_LONG).show()
                }, Response.ErrorListener{ error->
                    Toast.makeText(this," $error", Toast.LENGTH_LONG).show()
                }
            ){



                override fun getParams(): MutableMap<String, String>? {
                    val parametros = HashMap<String,String>()


                    parametros.put("usu_Documento",textDocumento?.text.toString())
                    parametros.put("usu_Contrasena",textContraseña?.text.toString())



                    return parametros

                }

            }
            val intent2 = Intent(this,PruebaNavActivity::class.java).apply {  }
            startActivity(intent2)
            queue.add(resultPost)
        }
        }
    }



