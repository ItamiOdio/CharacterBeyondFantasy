package com.example.animaproject.CreateCharacter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_create_basics.*
import kotlinx.android.synthetic.main.fragment_primary_skills.*

/**
 * A simple [Fragment] subclass.
*/
class PrimarySkillsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primary_skills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext3.setOnClickListener {
            findNavController().navigate(R.id.action_primarySkillsFragment_to_createFeatsFragment)
        }
    }


}
