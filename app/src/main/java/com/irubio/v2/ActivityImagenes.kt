package com.irubio.v2

import MyAdapter
import MyAdapter_Images
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irubio.v2.Data.Imagen
import com.irubio.v2.Data.Usuario
import java.util.*

class ActivityImagenes : AppCompatActivity() {

    private var tts: TextToSpeech? = null
    private var listo: Boolean? = false
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter_Images
    var imagenes = ArrayList<Imagen>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_imagenes)
        val imagen1 = Imagen(0,R.drawable.gato,"Gato","Gato")
        val imagen2 = Imagen(1,R.drawable.conejo,"Conejo","Conejo")
        val imagen3 = Imagen(2,R.drawable.perro,"Perro","Perro")
        val imagen4 = Imagen(3,R.drawable.vaca,"Vaca","Vaca")
        imagenes.add(imagen1)
        imagenes.add(imagen2)
        imagenes.add(imagen3)
        imagenes.add(imagen4)

        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        myAdapter = MyAdapter_Images(imagenes) { position ->
            Toast.makeText(this, "Clicked item ${imagenes[position].titulo}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = myAdapter
    }




    //override fun onInit(status: Int) {
        //if (status == TextToSpeech.SUCCESS) {
            //val result = tts!!.setLanguage(Locale("spa"))

            //if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                //Log.e("TTS","The Language not supported!")
            //} else {
               // listo = true
            //}
        //}
    //}

    //public override fun onDestroy() {

        //if (tts != null) {
            //tts!!.stop()
            //tts!!.shutdown()
        //}

        //super.onDestroy()
    //}


}