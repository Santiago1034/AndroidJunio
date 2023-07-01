package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface EntregaListener {
    fun onItemClicked(entrega: JSONObject, position: Int)
}