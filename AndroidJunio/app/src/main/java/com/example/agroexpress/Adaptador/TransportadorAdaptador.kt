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

class TransportadorAdaptador (private val TranspoList: ArrayList<JSONObject>, private val TransportadorListener: TransportadorListener) : RecyclerView.Adapter<TransportadorAdaptador.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imagen: ImageView = view.findViewById(R.id.tvimagen_transp)
        var nombre: TextView = view.findViewById(R.id.tvnombre_transp)
        var apellido: TextView = view.findViewById(R.id.tvapellidos_transp)
        var ciudad: TextView = view.findViewById(R.id.tvciudad_transp)
        var telefono: TextView = view.findViewById(R.id.tvtelefono_transp)

        fun bind(Usuarios: JSONObject){
            Log.d("error",Usuarios.getString("Usu_Apellidos"))
            nombre.text = Usuarios.getString("Usu_Nombre")

            apellido.text = Usuarios.getString("Usu_Apellidos")
            ciudad.text = Usuarios.getString("Usu_Ciudad")
            telefono.text = Usuarios.getString("Usu_Telefono")

        }
    }

    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_transportador,parent,false)
    )
    override fun getItemCount() = this.TranspoList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val Transportador = TranspoList[position]

        try{
            Glide.with(holder.itemView.context)
                .load(Transportador.get("Usu_UrlImg"))
                .into(holder.imagen)
            holder.bind(Transportador)

            holder.itemView.setOnClickListener{
                TransportadorListener.onItemClicked(Transportador,position)
            }

        }catch (e : Exception){
            Log.w("Transpodatos", "No cargan datos")
        }
    }


}