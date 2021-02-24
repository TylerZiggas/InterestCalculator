package edu.umsl.tyler.ui.main

import androidx.lifecycle.ViewModel
import edu.umsl.tyler.YearLoan
import java.time.Year

class CalculatedViewModel(yearLoan: YearLoan/*, loan: Int, escrow: Double, APR: Double*/) : ViewModel() {

    //var APR: Double = APR
    //var escrow: Double = escrow
    //var loan: Int = loan
    var yearLoan: YearLoan = yearLoan
}