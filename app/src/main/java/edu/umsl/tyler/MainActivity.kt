package edu.umsl.tyler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.umsl.tyler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar!!.hide()

        binding.calculateButton.setOnClickListener {
            val yearOption = when (binding.yearGroup.checkedRadioButtonId) {
                binding.fifteenButton.id -> YearLoan.FIFTEEN
                binding.thirtyButton.id -> YearLoan.THIRTY
                binding.fortyButton.id -> YearLoan.FORTY
                else -> YearLoan.FIFTEEN
            }

            val startAPR: String = binding.editAPR.text.toString()
            val startEscrow: String = binding.editEscrow.text.toString()
            val startLoan: String = binding.editLoan.text.toString()

            if (startAPR.isNotEmpty() && startEscrow.isNotEmpty() && startLoan.isNotEmpty()) {
                CalculatedActivity.newInstance(this, yearOption, startAPR, startEscrow, startLoan)
            }
        }
        binding.resetButton.setOnClickListener {
            binding.editEscrow.setText("1000.00")
            binding.editAPR.setText("5.00")
            binding.editLoan.setText("100000")
            binding.fifteenButton.isChecked = true
        }
    }
}