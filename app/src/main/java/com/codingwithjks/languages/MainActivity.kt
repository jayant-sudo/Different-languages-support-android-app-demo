package com.codingwithjks.languages


import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.Language
import java.util.*


class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{

    private lateinit var list: List<String>
    private lateinit var preferences:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLocale("fr")
        setContentView(R.layout.activity_main)
     list= listOf("Select Language","English","Spanish","French","Hindi")
       var arrayAdapter=ArrayAdapter.createFromResource(this,R.array.items,R.layout.spinner_item)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_items)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener=this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
     when(position)
     {
         1-> getLocale("en")
         2-> getLocale("es")
         3-> getLocale("fr")
         4-> getLocale("hi")
     }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun getLocale(lang:String?)
    {
        if(lang == "")
            return
        val resources= resources
        val dm=resources.displayMetrics
        val config=resources.configuration
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            config.setLocale(Locale(lang?.toLowerCase()))
            this.createConfigurationContext(config)
        }else{
            config.locale= Locale(lang?.toLowerCase())
            resources.updateConfiguration(config,dm)
        }


    }


}