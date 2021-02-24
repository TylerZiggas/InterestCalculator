package edu.umsl.tyler.ui.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.umsl.tyler.YearLoan

class CalculatedModelFactory(private val yearLoan: YearLoan/*,private val APR: Double, private val escrow: Double, private val loan: Int*/): ViewModelProvider.Factory {

//    fun CalculatedModelFactory(application: Application, APR: Double, escrow: Double, loan: Int) {
//        var APR = APR
//        var escrow = escrow
//        var loan = loan
//    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(YearLoan::class.java).newInstance(yearLoan)
    }
}