package com.example.animaproject.CreateCharacter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.animaproject.R
import kotlinx.android.synthetic.main.activity_create_character.*
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

        btnNext1.setOnClickListener {
             findNavController().navigate(R.id.action_createBasicsFragment_to_createStatsFragment)
            }
        }
 }

