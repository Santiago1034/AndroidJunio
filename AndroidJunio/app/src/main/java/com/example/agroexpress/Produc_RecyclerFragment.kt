package com.example.agroexpress

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.agroexpress.Adaptador.ItemListener
import com.example.agroexpress.Adaptador.ProductoAdaptador
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 LISTAR DETALLE PRODUCTO EN ITEM PRODUCTO CAMPESINO
 */
class Produc_RecyclerFragment : Fragment(),ItemListener {
    private lateinit var recycler: RecyclerView
    private lateinit var  progressBar: ProgressBar
    private lateinit var relative: RelativeLayout
    private lateinit var floatingBtn:FloatingActionButton
    private  var productlist= ArrayList<JSONObject>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adaptador = ProductoAdaptador(productlist ,this)
        val layoutmanager = LinearLayoutManager(requireContext())
        recycler.layoutManager = layoutmanager

        recycler.adapter = adaptador
        Log.d("adaptador","onViewCreated")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_produc__recycler, container, false)

        this.floatingBtn = ll.findViewById(R.id.gravityBtnagregarProduc)
        val url= "http://192.168.104.149:8080/Listarproductos"
        val url2 = "http://192.168.104.149:8080/ListarProductosCampesino/{documento}"
        val queue= Volley.newRequestQueue(this.context)
        Log.d("product fragment", "error")
        val stringRequest = StringRequest(Request.Method.GET,url,{response ->
            val jsonArray = JSONArray(response)
            this.productlist = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()

                while (i<l){
                    productlist.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("product fragment", this.productlist.toString())
                this.recycler.adapter = ProductoAdaptador(this.productlist,this)
                this.progressBar.visibility=View.INVISIBLE

            }catch (e: JSONException){

            }

        },{ error ->

        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.recyclerproducto)
        this.progressBar = ll.findViewById(R.id.progressproducto)
        this.relative = ll.findViewById(R.id.relativeproducto)
        floatingBtn.setOnClickListener{
            val navController = Navigation.findNavController(requireActivity(), R.id.gravityBtnagregarProduc)
            navController.navigate(R.id.camEditarproductoFragment)
        }
        return ll

    }

    override fun onItemClicked(product: JSONObject, position: Int) {
        //

    }


}