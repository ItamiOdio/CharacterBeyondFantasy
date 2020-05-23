package com.example.animaproject.CreateCharacter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.animaproject.CharacterInfo

import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_character_details.*
import kotlinx.android.synthetic.main.fragment_create_basics.*

/**
 * A simple [Fragment] subclass.
 */
class CreateDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var newCharacter : CharacterInfo = arguments?.getSerializable("character") as CharacterInfo

        // Create String variables for selected items
        var raceFinal = ""
        var classFinal = ""

        //Create arrays of options, add adapter, implement methods

        val racesOptions = arrayOf("The Nephilim", "Sylvain", "Jayan", "D'Anjayni", "Ebudan", "Daimah", "Duk'Zarist")
        var classesOptions = arrayOf("Domine", "Figther", "Mystic", "Prowler", "Psychic", "Novel")

        spinRace.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, racesOptions)
        spinRace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                raceFinal = "Chose your race"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                raceFinal = racesOptions[position]
            }
        }

        spinClass.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, classesOptions)
        spinClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                classFinal = "Chose your class"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                classFinal = classesOptions[position]
            }
        }

        // Navigate between fragments

        btnNext4.setOnClickListener {
            newCharacter.race = raceFinal
            newCharacter.characterClass = classFinal
            val bundle = bundleOf("character" to newCharacter)
            findNavController().navigate(R.id.action_createDetailsFragment_to_primarySkillsFragment, bundle)
        }

        btnBack4.setOnClickListener {
            findNavController().navigate(R.id.action_createDetailsFragment_to_createStatsFragment)
        }
    }



}
