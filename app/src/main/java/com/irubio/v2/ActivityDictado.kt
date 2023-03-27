package com.irubio.v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class ActivityDictado : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private lateinit var imagenDictado: ImageView
    private lateinit var textoDictado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictado)

        imagenDictado = findViewById<ImageView>(R.id.imagenDictado)
        textoDictado = findViewById<TextView>(R.id.textoDictado)

        tts = TextToSpeech(this,this)


        when (intent.getIntExtra("idImagen", 0)){
            0 ->
            {
                imagenDictado.setImageResource(R.drawable.gato)
            }

            1 ->
            {
                imagenDictado.setImageResource(R.drawable.conejo)
            }

            2 ->
            {
                imagenDictado.setImageResource(R.drawable.perro)
            }

            3 ->
            {
                imagenDictado.setImageResource(R.drawable.vaca)
            }

            else ->
            {
                imagenDictado.setImageResource(R.drawable.gato)
            }
        }

        textoDictado.text = intent.getStringExtra("titulo")

        imagenDictado.setOnClickListener {
            //Toast.makeText(this, "Image clicked!", Toast.LENGTH_SHORT).show()
            speakOut()
        }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale("spa"))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language not supported!")
            } else {
                //btnSpeak!!.isEnabled = true
            }
        }
    }

    private fun speakOut() {
//        val phoneme = "<phoneme alphabet=\"ipa\" ph=\"mmmm\"></phoneme>"
//        val ssml = "<speak>$phoneme</speak>"
        tts!!.speak(textoDictado.text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    public override fun onDestroy() {
        // Shutdown TTS when
        // activity is destroyed
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}