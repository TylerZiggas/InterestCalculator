package edu.umsl.tyler

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import edu.umsl.tyler.ui.main.CalculatedFragment
import edu.umsl.tyler.ui.main.CalculatedModelFactory
import edu.umsl.tyler.ui.main.CalculatedViewModel
import kotlin.math.pow

class CalculatedActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context, yearOption: YearLoan, startAPR: String, startEscrow: String, startLoan: String)  {
            val startAPR: Double = startAPR.toDouble()
            val APR:Double = String.format("%.3f", startAPR).toDouble()
            val startEscrow: Double = startEscrow.toDouble()
            val escrow:Double = String.format("%.2f", startEscrow).toDouble()
            var loan:Double = startLoan.toDouble()
            val monthlyPayment:Double = (loan * (((APR/100)/12) * (1 + (APR/100)/12).pow(yearOption.value)))/(((1 + (APR/100)/12).pow(yearOption.value)) - 1)
            val roundedMonthlyPayment:Double = String.format("%.2f", monthlyPayment).toDouble()
            val monthlyEscrow:Double = escrow/12
            val roundedMonthlyEscrow:Double = String.format("%.2f", monthlyEscrow).toDouble()
            var monthlyInterest: Double
            var monthlyPrincipal: Double
            var monthlyInterestList = ArrayList<Double>(initialCapacity = yearOption.value)
            var monthlyPrincipalList = ArrayList<Double>(initialCapacity = yearOption.value)
            var monthlyLoanLeft = ArrayList<Double>(initialCapacity = yearOption.value)
            var monthlyEscrowList = ArrayList<Double>(initialCapacity = yearOption.value)
            for (i in 1..yearOption.value) {
                monthlyInterest = String.format("%.2f", (loan * ((APR/100)/ 12))).toDouble()
                monthlyInterestList.add(i, monthlyInterest)
                monthlyPrincipal = String.format("%.2f", (monthlyPayment - monthlyInterest)).toDouble()
                if (i != yearOption.value) {
                    loan = String.format("%.2f", (loan - monthlyPrincipal)).toDouble()
                } else {
                    monthlyPrincipal = String.format("%.2f", (loan)).toDouble()
                    loan = 0.00
                }
                monthlyPrincipalList.add(i, monthlyPrincipal)
                monthlyLoanLeft.add(i, loan)
                monthlyEscrowList.add(i, roundedMonthlyEscrow)
            }
            val x = CalculatedViewModel(yearOption, monthlyInterestList, monthlyPrincipalList, monthlyLoanLeft, monthlyEscrowList)
            val intent = Intent(context, CalculatedActivity::class.java)
            intent.putExtra("Year Amount", yearOption)
            //intent.putExtra("APR Amount", APR)
            //intent.putExtra("Escrow Amount", escrow)
            //intent.putExtra("Loan Amount", loan)
            context.startActivity(intent)
        }
    }

    private lateinit var viewModel: CalculatedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculated_activity)
        val yearLoan = intent.getSerializableExtra("Year Amount") as? YearLoan ?: YearLoan.FIFTEEN
        //val APR = intent.getSerializableExtra("APR Amount") as? Double ?: 5.00
        //val escrow = intent.getSerializableExtra("Escrow Amount") as? Double ?: 10000.00
        //val loan = intent.getSerializableExtra("Loan Amount") as? Int ?: 100000
        viewModel = ViewModelProvider(this, CalculatedModelFactory(yearLoan/*, APR, escrow, loan*/)).get(CalculatedViewModel::class.java)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, CalculatedFragment.newInstance()).commitNow()
        }
    }
}