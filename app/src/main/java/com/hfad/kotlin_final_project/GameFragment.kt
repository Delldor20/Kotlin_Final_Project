package com.hfad.kotlin_final_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hfad.kotlin_final_project.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        updateDisplay()

        binding.guessButton.setOnClickListener {
            viewModel.makeGuess(binding.guess.text.toString().uppercase())
            binding.guess.text = null
            updateDisplay()
            if(viewModel.isWon() || viewModel.isLost()) {
                    val action = GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.wonLostMessage(), viewModel.lives)
                    view.findNavController().navigate(action)
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateDisplay()
    {
        binding.word.text = viewModel.wordDisplay
        binding.lives.text = "Lives Remaining: \n ${viewModel.lives}"
        binding.incorrectGuesses.text = "Incorrect guesses: \n ${viewModel.incorrectGuesses}"
    }
}