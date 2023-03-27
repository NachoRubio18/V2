package com.irubio.v2

import MyAdapter
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irubio.v2.Data.Usuario
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private var tts: TextToSpeech? = null
    private var listo: Boolean? = false
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    var imagenes: ArrayList<Int>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        val user1 = Usuario(0,"Nacho123","123","Nacho","Nosk",R.drawable.user_verde,imagenes)
        val user2 = Usuario(1,"oliver123","123","Oliver","Nosk",R.drawable.user_naranja,imagenes)
        val user3 = Usuario(2,"li13323","123","Prueba","Nosk",R.drawable.user_naranja_pollo,imagenes)
        val user4 = Usuario(3,"oo33123","123","Prueba","Nosk",R.drawable.user_negro,imagenes)

        imagenes?.add(1)
        imagenes?.add(2)
        imagenes?.add(3)
        imagenes?.add(4)

        for (i in 0..3){
         imagenes?.add(
            Random.nextInt(0,
            4))
        }
        val myData = listOf(user1,user2,user3,user4)
        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        myAdapter = MyAdapter(myData) { position ->
            val intent = Intent(this, ActivityImagenes::class.java)
            val b = Bundle()
            b.putInt("lista", 1)
            intent.putExtras(b)
            startActivity(intent)
            //finish()

            //val b = getIntent().extras
            //var value = -1 // or other values if (b != null) value = b.getInt("key")
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