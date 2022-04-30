package com.hfad.kotlin_final_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.*
import androidx.core.view.get
import androidx.navigation.findNavController
import com.hfad.kotlin_final_project.databinding.FragmentResultBinding

class Result : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ResultViewModel
    lateinit var sharedViewModel: SharedViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        var view = binding.root

        val livesLeft = ResultArgs.fromBundle(requireArguments()).livesLeft

        binding.wonLost.text = ResultArgs.fromBundle(requireArguments()).result

        val bestAdapter = activity?.let { ArrayAdapter.createFromResource(it.baseContext, R.array.bestReward, android.R.layout.simple_spinner_item) }
        val midAdapter = activity?.let { ArrayAdapter.createFromResource(it.baseContext, R.array.midReward, android.R.layout.simple_spinner_item) }
        val lowAdapter = activity?.let { ArrayAdapter.createFromResource(it.baseContext, R.array.lowReward, android.R.layout.simple_spinner_item) }

        bestAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        midAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        lowAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        when (livesLeft) {
             0,1,2,3,4 -> binding.spinner.adapter = lowAdapter
             5,6,7,8,9 -> binding.spinner.adapter = midAdapter
             10 -> binding.spinner.adapter = bestAdapter
         }

        var initialPos = 0;

        binding.spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                if(initialPos < 1) {
                    initialPos++
                } else {
                    Toast.makeText(view!!.context , binding.spinner.selectedItem.toString() ,Toast.LENGTH_SHORT).show()
                    initialPos = 0
                }

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
            binding.returnToMenu.setOnClickListener {
                view.findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
            }
            return view
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}