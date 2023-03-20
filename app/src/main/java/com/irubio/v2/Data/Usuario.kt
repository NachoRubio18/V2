package com.irubio.v2.Data

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("idUsuario") var idUsuario: Int? = 0,
    @SerializedName("usuario") var usuario: String? = null,
    @SerializedName("pass") var pass: String? = null,
    @SerializedName("nombre") var nombre: String? = null,
    @SerializedName("apellidos") var apellidos: String? = null,
    @SerializedName("fotoPerfil") var fotoPerfil: Int = -1,
    @SerializedName("lista") var imagenes: ArrayList<Int>? = null
)


