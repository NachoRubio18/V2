package com.irubio.v2.Data

import com.google.gson.annotations.SerializedName

data class Imagen(
    @SerializedName("idImagen") var idImagen: Int? = 0,
    @SerializedName("imagen") var imagen: Int = -1,
    @SerializedName("titulo") var titulo: String? = null,
    @SerializedName("palabra") var palabra: String? = null
)


