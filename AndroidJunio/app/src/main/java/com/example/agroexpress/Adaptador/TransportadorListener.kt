package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface TransportadorListener {
    fun onItemClicked(transportador: JSONObject, position: Int)
}