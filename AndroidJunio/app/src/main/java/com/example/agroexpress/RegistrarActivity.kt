package com.example.agroexpress

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.agroexpress.Adaptador.ProductoAdaptador
import com.example.agroexpress.databinding.ActivityMainBinding
import com.google.android.material.internal.ContextUtils.getActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.Arrays


class RegistrarActivity : AdapterView.OnItemSelectedListener, AppCompatActivity() {


    private  lateinit var texNombre : EditText
    private lateinit var textApellido : EditText
    private lateinit var textDocumento : EditText
    private lateinit var textTelefono : EditText
    private lateinit var textCelular : EditText
    private lateinit var textDireccion : EditText
    private lateinit var textCorreo : EditText
    private lateinit var textContraseña : EditText
    private lateinit var btnRegistar : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Spinner spinerDepartamento =   new Spinner(this)
        setContentView(R.layout.activity_registrar)


        val dp = resources.getStringArray(R.array.roles_array)
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, dp)
        val spinerRoles = findViewById<Spinner>(R.id.SpinnerRoles)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinerRoles.adapter = aa



        this.texNombre = findViewById(R.id.registronombre)
        this.textApellido = findViewById(R.id.registroApellido)
        this.textDocumento = findViewById(R.id.registroDocumento)
        this.textTelefono = findViewById(R.id.registroTelefono)
        this.textCelular = findViewById(R.id.registroCelular)
        this.textDireccion = findViewById(R.id.registroDireccion)
        this.textContraseña = findViewById(R.id.registroContraseña)
        this.textCorreo = findViewById(R.id.registroCorreo)
        this.btnRegistar = findViewById(R.id.btnResgitrarUsuario)



        btnRegistar.setOnClickListener{
            val url = "192.168.88.149:8080/AgregarUsuario"

    }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}