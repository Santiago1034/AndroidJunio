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
import com.example.agroexpress.Adaptador.ItemListener
import com.example.agroexpress.Adaptador.TransportadorAdaptador
import com.example.agroexpress.Adaptador.TransportadorListener
import com.example.agroexpress.Adaptador.UsuariosAdaptador
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Transp_RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Transp_RecyclerFragment : Fragment(), TransportadorListener {
    private lateinit var recycler: RecyclerView
    private lateinit var  progressBar: ProgressBar
    private lateinit var relative: RelativeLayout
    private  var TranspoList= ArrayList<JSONObject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adaptador = TransportadorAdaptador(TranspoList ,this)
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
        val ll = inflater.inflate(R.layout.fragment_transp__recycler, container, false)
        val url= "http://192.168.22.36/DatosBdAgro/transportador.php"
        val queue= Volley.newRequestQueue(this.context)
        Log.d("trnas fragment", "error")
        val stringRequest = StringRequest(Request.Method.GET,url,{ response ->
            val jsonArray = JSONArray(response)
            this.TranspoList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()

                while (i<l){
                    TranspoList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("product fragment", this.TranspoList.toString())
                this.recycler.adapter = TransportadorAdaptador(this.TranspoList,this)
                this.progressBar.visibility=View.INVISIBLE

            }catch (e: JSONException){

            }

        },{ error ->

        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.recyclertransportador)
        this.progressBar = ll.findViewById(R.id.progresstransportador)
        this.relative = ll.findViewById(R.id.relativetransportador)

        return ll
    }

    override fun onItemClicked(usuarios: JSONObject, position: Int) {

    }
}