package com.example.catalina.practicakotlincata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.catalina.practicakotlincata.model.Quote
import androidx.lifecycle.MutableLiveData

class QuotesViewModel : ViewModel() {


    private var quotesList: MutableLiveData<List<Quote>>? = null
    private val quotesHelper = mutableListOf<Quote>()


    //éste metodo carga la quote a la lista de quotes

    //en el main activity le pasamos la quote que creamos por parametro
    public fun cargarQuote(quoteACargar: Quote) {

        if (quotesList == null) {
            quotesList = MutableLiveData<List<Quote>>()
        }
        // acá le cargo a la lista de quotes la quote que cree en el main
        quotesHelper.add(quoteACargar)
        //acá le paso el valor del quoteshelper a la quoteslist
        quotesList!!.value = quotesHelper
    }

    public fun getLastQuote(): MutableLiveData<Quote>? {

        if (quotesHelper != null && quotesHelper.size != 0) {
            return quotesHelper?.get(quotesHelper.size - 1) as MutableLiveData<Quote>
        }else{
            return null
        }
    }

}