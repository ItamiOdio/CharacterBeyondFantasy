package com.example.animaproject.CreateCharacter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.animaproject.CharacterInfo
import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_create_basics.*


/**
 * A simple [Fragment] subclass.
 */
class CreateBasicsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_basics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var newCharacter = CharacterInfo() // create object instance for the new character

        //set listener to the button
        btnNext1.setOnClickListener {

            // fill basic information with data provided by user
            newCharacter.name = writeName.text.toString()
            newCharacter.gender = writeGender.text.toString()
            newCharacter.age = writeAge.text.toString()
            newCharacter.eyes = writeEyes.text.toString()
            newCharacter.hair = writeHair.text.toString()
            newCharacter.skin = writeSkin.text.toString()

            // go to the next fragment with data in bundle
            val bundle = bundleOf("character" to newCharacter)
            findNavController().navigate(R.id.action_createBasicsFragment_to_createStatsFragment, bundle)
        }
    }
}

