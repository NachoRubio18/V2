package com.irubio.v2

import MyAdapter
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tts: TextToSpeech? = null
    private var listo: Boolean? = false
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private val myData = listOf(
        R.drawable.gato,
        R.drawable.gato,
        R.drawable.gato,
        R.drawable.gato,
        R.drawable.gato)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)



        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        myAdapter = MyAdapter(myData) { position ->
            // Handle item click here
            Toast.makeText(this, "Clicked item $position", Toast.LENGTH_SHORT).show()
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