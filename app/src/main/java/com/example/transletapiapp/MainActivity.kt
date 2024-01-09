package com.example.transletapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.transletapiapp.ApiClient.Companion.getApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import com.example.transletapiapp.TranslateModel as TranslateModel

class MainActivity : AppCompatActivity() {
    lateinit var edtTranslate:EditText
    lateinit var btnTranslate:Button
    lateinit var txtTranslate:TextView
    var translateModel : TranslateModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTranslate = findViewById<EditText>(R.id.edtTranslate)
        btnTranslate = findViewById<Button>(R.id.btnTranslate)
        txtTranslate = findViewById<TextView>(R.id.txtTranslate)

       btnTranslate.setOnClickListener {

           getTranslateAPI(edtTranslate.text.toString())
       }





    }



    fun getTranslateAPI(text :String) {

        var apiTranslate = getApiClient()!!.create(APIInterface::class.java).also {
            it.TranslateApi("58eedfb08cmsh40001dd692eadfap147e2ajsna2337313944f", "text-translator2.p.rapidapi.com", "en", "hi", "How are You?").enqueue(object :retrofit2.Callback<TranslateModel>{
                override fun onResponse(call: Call<TranslateModel>?, response: Response<TranslateModel>?) {
                    if (response!!.code()==200){
                        translateModel = response.body()

                    }
                }

                override fun onFailure(call: Call<TranslateModel>?, t: Throwable?) {
                    Log.e("TAG", "onFailure: ${t!!.message}", )
                }

            })
        }
    }
}