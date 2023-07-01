package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface DevolucionListener {
    fun onItemClicked(devolucion: JSONObject, position: Int)
}