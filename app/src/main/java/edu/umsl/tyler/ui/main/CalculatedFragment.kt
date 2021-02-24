package edu.umsl.tyler.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.umsl.tyler.YearLoan
import edu.umsl.tyler.databinding.AmortizationListItemBinding
import edu.umsl.tyler.databinding.CalculatedFragmentBinding
import kotlinx.android.synthetic.main.amortization_list_item.*
import java.time.Year

class CalculatedFragment : Fragment() {

    companion object {
        fun newInstance() = CalculatedFragment()
    }

    private lateinit var viewModel: CalculatedViewModel
    private lateinit var binding: CalculatedFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CalculatedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(activity!!).get(CalculatedViewModel::class.java)
        viewModel.yearLoan
        binding.calculatedRV.layoutManager = LinearLayoutManager(activity)
        binding.calculatedRV.adapter = AmortizationListAdapter(viewModel.yearLoan)

    }

    // can just pass in an array here
    inner class AmortizationListAdapter(private val yearLoan: YearLoan): RecyclerView.Adapter<AmortizationViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmortizationViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = AmortizationListItemBinding.inflate(inflater, parent, false)
            return AmortizationViewHolder(binding)
        }

        override fun onBindViewHolder(holder: AmortizationViewHolder, position: Int) {
            //holder.bind()
            Log.e("BIND", "onBindViewHolder")
        }

        override fun getItemCount(): Int {
            return yearLoan.value
        }
    }

    inner class AmortizationViewHolder(private val binding: AmortizationListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (yearLoan: YearLoan) {
            //binding.loanLeft.text =
            binding.appliedPrincipal.setText(yearLoan.value)
            //binding.appliedEscrow.setText()
           // binding.appliedInterest.setText()
        }
    }
}