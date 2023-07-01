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

class UsuariosAdaptador(private val UsuarioList: ArrayList<JSONObject>, private val UsuarioListener: UsuarioListener) : RecyclerView.Adapter<UsuariosAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imagen: ImageView = view.findViewById(R.id.tvimagen_campesino)
        var nombre: TextView = view.findViewById(R.id.tvnombres_campesino)
        var apellido: TextView = view.findViewById(R.id.tvapellidos_campesino)
        var ciudad: TextView = view.findViewById(R.id.tvciudad_campesino)
        var telefono: TextView = view.findViewById(R.id.tvtelefono_campesino)

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
            .inflate(R.layout.item_campesinos,parent,false)
    )
    override fun getItemCount() = this.UsuarioList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val Campesinos = UsuarioList[position]
        Log.d("imgcampesinos",Campesinos.getString("Usu_Correo"))
        try{
            Glide.with(holder.itemView.context)
                .load(Campesinos.get("Usu_UrlImg"))
                .into(holder.imagen)
            holder.bind(Campesinos)

            holder.itemView.setOnClickListener{
                UsuarioListener.onItemClicked(Campesinos,position)
            }

        }catch (e : Exception){
            Log.w("Campesinosdatos", "No cargan datos")
        }
    }


}


