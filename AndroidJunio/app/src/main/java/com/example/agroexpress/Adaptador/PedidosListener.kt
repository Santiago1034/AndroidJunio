package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface PedidosListener {
    fun onItemClicked(pedido: JSONObject, position: Int)
}