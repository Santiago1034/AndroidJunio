package com.example.agroexpress.Adaptador

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agroexpress.Modelos.Producto
import com.example.agroexpress.R
import org.json.JSONArray
import org.json.JSONObject

class ProductoAdaptador (private val ProductoList: ArrayList<JSONObject>, private val itemListener: ItemListener) : RecyclerView.Adapter<ProductoAdaptador.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imagen: ImageView = view.findViewById(R.id.img_item_camp_product)
        var referencia: TextView = view.findViewById(R.id.referencia_autoincrement_cam_product)
        var id_usuario: TextView = view.findViewById(R.id.id_usuario_camp_product)
        var nombre: TextView = view.findViewById(R.id.nombre_product_camp)
        var categoria: TextView = view.findViewById(R.id.categoria_product_camp)
        var precio: TextView = view.findViewById(R.id.precio_camp_product)
        var cantidad: TextView = view.findViewById(R.id.cantidad_dispon_camp_product)


        fun bind(Producto: JSONObject){
            referencia.text = Producto.getString("det_Referencia")
            id_usuario.text = Producto.getString("det_IdUsuario")
            nombre.text = Producto.getString("det_nombre_Product")
            precio.text = Producto.getString("det_precio")
            cantidad.text = Producto.getString("det_cantidad")
            categoria.text =Producto.getString("det_Categoria")
            Log.d("json",Producto.toString())

        }
    }
    override  fun  onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_producto_camp,parent,false)
    )
    override fun getItemCount() = this.ProductoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = ProductoList[position]

        try{
            Glide.with(holder.itemView.context)
                .load(product.get("LisP_UrlImg"))
                .into(holder.imagen)
            holder.bind(product)

            holder.itemView.setOnClickListener{
                itemListener.onItemClicked(product,position)
            }

        }catch (e : Exception){
            Log.w("Productosdatos", "No cargan datos")
        }
    }


}

