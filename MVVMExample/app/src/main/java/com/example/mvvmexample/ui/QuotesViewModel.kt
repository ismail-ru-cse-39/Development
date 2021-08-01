package com.example.mvvmexample.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.Quote
import com.example.mvvmexample.data.QuoteRepository

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}