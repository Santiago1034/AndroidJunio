package com.example.agroexpress

import android.app.DownloadManager.Request
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.resources.*
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Agregar_Produc_CampesinoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Agregar_Produc_CampesinoFragment : Fragment() {

    private lateinit var texNombre : EditText
    private lateinit var texId : EditText
    private lateinit var texUrlImg : EditText
    private lateinit var btnGuardar : ImageButton
    private lateinit var spinerCategoria : Spinner


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val t = inflater.inflate(R.layout.fragment_agregar__produc__campesino, container, false)
        val spinner = t.findViewById<Spinner>(R.id.SpinnerCategoriaProductos)


        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array4,
            android.R.layout.simple_spinner_item

        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter

        }

        this.texNombre = t.findViewById(R.id.NomProduc)
        this.texUrlImg = t.findViewById(R.id.UrlImg)
        this.texId = t.findViewById(R.id.IdProduc)
        this.btnGuardar = t.findViewById(R.id.btnGuardarProduc)
        this.spinerCategoria = t.findViewById(R.id.SpinnerCategoriaProductos)

        btnGuardar.setOnClickListener {
            val url = "http://192.168.1.22:8080/AgregarProducto"
            val queue = Volley.newRequestQueue(getActivity())
            val resultPost = object : StringRequest(
                com.android.volley.Request.Method.POST, url,
                Response.Listener<String> { response ->
                    Toast.makeText(getActivity(), "categoria creada", Toast.LENGTH_LONG).show()
                }, Response.ErrorListener { error ->
                    Toast.makeText(getActivity(), " $error", Toast.LENGTH_LONG).show()
                }
            ) {
                override fun getParams(): MutableMap<String, String>? {
                    val parametros = HashMap<String, String>()
                    parametros.put("LisP_Id", texId?.text.toString())
                    Log.d("ID", texId?.text.toString())

                    parametros.put("LisP_Nombre", texNombre?.text.toString())
                    parametros.put("LisP_Url", texUrlImg?.text.toString())


                    return parametros
                }

            }
            queue.add(resultPost)
        }
        return t


        }
    }


