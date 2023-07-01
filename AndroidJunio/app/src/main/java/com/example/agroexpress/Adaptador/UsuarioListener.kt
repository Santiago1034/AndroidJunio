package com.example.agroexpress.Adaptador

import org.json.JSONObject

interface UsuarioListener {
    fun onItemClicked(Usuarios: JSONObject, position: Int)
}