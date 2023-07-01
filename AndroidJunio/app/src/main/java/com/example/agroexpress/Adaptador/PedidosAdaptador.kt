package com.example.agroexpress.Adaptador

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agroexpress.Modelos.Pedidos
import com.example.agroexpress.R
import org.json.JSONObject

class PedidosAdaptador (private val PedidosList: ArrayList<JSONObject>, private val pedidosListener: PedidosListener) : RecyclerView.Adapter<PedidosAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var id_pedido: TextView = view.findViewById(R.id.id_pedidos)
        var cantidad: TextView = view.findViewById(R.id.cantidad_pedidos)
        var estado: TextView = view.findViewById(R.id.estado_pedidos)

        fun bind(pedido: JSONObject){
            id_pedido.text = pedido.getString("OrdC_Id")
            cantidad.text = pedido.getString("OrdC_Cantidad")
            estado.text = pedido.getString("OrdE_Estado")
            Log.d("json",pedido.toString())

        }
    }
    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_mispedidos,parent,false)
    )
    override fun getItemCount() = this.PedidosList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedid = PedidosList[position]

        try{
            holder.bind(pedid)
            holder.itemView.setOnClickListener{
                pedidosListener.onItemClicked(pedid,position)
            }

        }catch (e : Exception){
            Log.w("pedidosdatos", "No cargan datos")
        }
    }


}