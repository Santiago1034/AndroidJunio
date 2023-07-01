package com.example.agroexpress.Adaptador

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agroexpress.R
import org.json.JSONObject

class DevolucionAdaptador (private val devolucionList: ArrayList<JSONObject>, private val devolucionListener: DevolucionListener) : RecyclerView.Adapter<DevolucionAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var id_devolucion: TextView = view.findViewById(R.id.id_devolucion)
        var direccion: TextView = view.findViewById(R.id.direccion_devolucion)
        var departamento: TextView = view.findViewById(R.id.departamento_devolucion)
        var totalPagar: TextView = view.findViewById(R.id.precio_devolucion)
        var estado: TextView = view.findViewById(R.id.estado_devolucion)

        fun bind(devolucion: JSONObject){
            id_devolucion.text = devolucion.getString("OrdC_Id")
            direccion.text = devolucion.getString("Usu_Direccion")
            departamento.text = devolucion.getString("Usu_Departamento")
            totalPagar.text = devolucion.getString("OrdC_Total_pagar")
            estado.text = devolucion.getString("OrdE_Estado")
            Log.d("json",devolucion.toString())

        }
    }
    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_devoluciones,parent,false)
    )
    override fun getItemCount() = this.devolucionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val devo = devolucionList[position]

        try{
            holder.bind(devo)
            holder.itemView.setOnClickListener{
                devolucionListener.onItemClicked(devo,position)
            }

        }catch (e : Exception){
            Log.w("devoluciondatos", "No cargan datos")
        }
    }
}

