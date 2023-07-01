package com.example.agroexpress

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.agroexpress.Adaptador.DespachoAdaptador
import com.example.agroexpress.Adaptador.DespachoListener
import com.example.agroexpress.Adaptador.EntregaAdaptador
import com.example.agroexpress.Adaptador.EntregaListener
import com.example.agroexpress.Modelos.Entregas
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Entrega_RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Entrega_RecyclerFragment : Fragment(), EntregaListener {
    private lateinit var recycler: RecyclerView
    private lateinit var  progressBar: ProgressBar
    private lateinit var relative: RelativeLayout
    private var entregaList= ArrayList<JSONObject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adaptador = EntregaAdaptador(entregaList ,this)
        val layoutmanager = LinearLayoutManager(requireContext())
        recycler.layoutManager = layoutmanager

        recycler.adapter = adaptador
        Log.d("adaptador","onViewCreated")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ll = inflater.inflate(R.layout.fragment_entrega__recycler, container, false)
        val url= "http://192.168.22.36/DatosBdAgro/entrega.php"
        val queue= Volley.newRequestQueue(this.context)
        Log.d("camp fragment", "error")
        val stringRequest = StringRequest(Request.Method.GET,url,{ response ->
            val jsonArray = JSONArray(response)
            this.entregaList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()

                while (i<l){
                    entregaList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("entrega fragment", this.entregaList.toString())
                this.recycler.adapter = EntregaAdaptador(this.entregaList,this)
                this.progressBar.visibility=View.INVISIBLE

            }catch (e: JSONException){

            }

        },{ error ->

        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.recyclerentrega)
        this.progressBar = ll.findViewById(R.id.progressentrega)
        this.relative = ll.findViewById(R.id.relativeentrega)

        return ll}

    override fun onItemClicked(entrega: JSONObject, position: Int) {

    }
}