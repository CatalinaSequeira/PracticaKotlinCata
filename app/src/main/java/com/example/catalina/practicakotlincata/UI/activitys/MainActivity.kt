package com.example.catalina.practicakotlincata.UI.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.catalina.practicakotlincata.R
import com.example.catalina.practicakotlincata.model.Author
import com.example.catalina.practicakotlincata.model.Phrase
import com.example.catalina.practicakotlincata.model.Quote
import com.example.catalina.practicakotlincata.viewmodel.QuotesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    // creo una instancia del quotesViewModel
    var mainViewModel : QuotesViewModel? = null
    // es la quote que quiero cargar en el textview
    var lastQuote : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(QuotesViewModel::class.java)
        cargarEditText()
        cargarLastQuote()
        quotes_tv.setText(lastQuote)
    }


    private fun cargarEditText(){
        boton.setOnClickListener {

            //tomamos la frase y el autor y le decimos que es una quote
            val autor = Author(author_et.text.toString())
            val frase = Phrase(frase_et.text.toString())
            val quote = Quote(autor,frase)

            //usamos el metodo cargar quote que creamos en el viewmodel
            mainViewModel?.cargarQuote(quote)
        }
    }

    //este metodo lo que hace es setear la info de los dos edittexts a el textview
    private fun cargarLastQuote() {
        // le pide a la instancia del QuotesViewModel usar el metodo getLastQuote que lo que hace es:
        //pedir el ultimo valor ingresado en la lista y devolverlo
        mainViewModel?.getLastQuote()?.observe(this, Observer { objetoQuote ->
            lastQuote = objetoQuote.autor.author + " " + objetoQuote.frase.frase
            quotes_tv.setText(lastQuote)
        })
    }



}
