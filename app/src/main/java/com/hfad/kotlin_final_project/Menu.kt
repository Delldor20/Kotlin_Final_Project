package com.hfad.kotlin_final_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class Menu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        val btn = view.findViewById<Button>(R.id.button)

        val description = view.findViewById<TextView>(R.id.descriptionText)

        description.text = "Word Master \n \n \n" +
                           "Press play to be given either a four, five, or a six letter game!\n" +
                           "Guess a letter, but be careful you only have 10 lives.\n" +
                           "The more lives you have the better reward you will receive.\n" +
                           "Have fun!"


        btn.setOnClickListener {
            val action = MenuDirections.actionMenuFragmentToGameFragment()
            view.findNavController().navigate(action)
        }
        return view
    }
}
