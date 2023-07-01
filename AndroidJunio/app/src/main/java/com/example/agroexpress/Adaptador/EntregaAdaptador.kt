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

class EntregaAdaptador (private val EntregaList: ArrayList<JSONObject>, private val entregaListener: EntregaListener) : RecyclerView.Adapter<EntregaAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imagen: ImageView = view.findViewById(R.id.img_entrega)
        var producto: TextView = view.findViewById(R.id.producto_entrega)
        var direccion: TextView = view.findViewById(R.id.direccion_entrega)
        var ciudad: TextView = view.findViewById(R.id.ciudad_entrega)
        var departamento: TextView = view.findViewById(R.id.departamento_entrega)
        var totalapagar: TextView = view.findViewById(R.id.total_entrega)
        var estado: TextView = view.findViewById(R.id.estado_entrega)

        fun bind(entrega: JSONObject){
            producto.text = entrega.getString("LisP_Nombre")
            direccion.text = entrega.getString("Usu_Direccion")
            ciudad.text = entrega.getString("Usu_Ciudad")
            departamento.text = entrega.getString("Usu_Departamento")
            totalapagar.text = entrega.getString("OrdC_Total_pagar")
            estado.text = entrega.getString("OrdE_Estado")
            Log.d("json",entrega.toString())

        }
    }
    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_entregados_trans,parent,false)
    )
    override fun getItemCount() = this.EntregaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entrega = EntregaList[position]

        try{
            Glide.with(holder.itemView.context)
                .load(entrega.get("LisP_UrlImg"))
                .into(holder.imagen)
            holder.bind(entrega)

            holder.itemView.setOnClickListener{
                entregaListener.onItemClicked(entrega,position)
            }

        }catch (e : Exception){
            Log.w("entregadatos", "No cargan datos")
        }
    }


}