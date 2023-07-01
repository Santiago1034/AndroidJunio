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

class DespachoAdaptador (private val DespachoList: ArrayList<JSONObject>, private val despachoListener: DespachoListener) : RecyclerView.Adapter<DespachoAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var numpedido: TextView = view.findViewById(R.id.tv_despacho_numpedido)
        var imagen: ImageView = view.findViewById(R.id.tv_despacho_img)
        var estado: TextView = view.findViewById(R.id.tv_despacho_estado)

        fun bind(despacho: JSONObject){
            numpedido.text = despacho.getString("OrdC_Id")
            estado.text = despacho.getString("OrdE_Estado")
            Log.d("json",despacho.toString())

        }
    }
    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_despachos,parent,false)
    )
    override fun getItemCount() = this.DespachoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val despac = DespachoList[position]

        try{
            Glide.with(holder.itemView.context)
                .load(despac.get("LisP_UrlImg"))
                .into(holder.imagen)
            holder.bind(despac)

            holder.itemView.setOnClickListener{
                despachoListener.onItemClicked(despac,position)
            }

        }catch (e : Exception){
            Log.w("despachodatos", "No cargan datos")
        }
    }


}