package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface DespachoListener {
    fun onItemClicked(despacho: JSONObject, position: Int)
}