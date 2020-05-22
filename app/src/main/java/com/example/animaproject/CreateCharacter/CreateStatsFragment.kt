package com.example.animaproject.CreateCharacter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_character_details.*
import kotlinx.android.synthetic.main.fragment_create_basics.*
import kotlinx.android.synthetic.main.fragment_create_stats.*
import java.util.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class CreateStatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGenerate.setOnClickListener {
            run {
                val generatedValues = Array(8) {
                    Random.nextInt(3, 11)
                }
                var minGenerated = generatedValues.min()
                Toast.makeText(requireContext(),"Generated: "+ (generatedValues.contentToString()), Toast.LENGTH_SHORT).show()
                generatedValues[generatedValues.indexOf(minGenerated)] = 9

                valAgi.setText(Integer.toString(generatedValues[0]))
                valCon.setText(Integer.toString(generatedValues[1]))
                valDex.setText(Integer.toString(generatedValues[2]))
                valStr.setText(Integer.toString(generatedValues[3]))
                valInt.setText(Integer.toString(generatedValues[4]))
                valPer.setText(Integer.toString(generatedValues[5]))
                valPow.setText(Integer.toString(generatedValues[6]))
                valWp.setText(Integer.toString(generatedValues[7]))

            }
        }

        btnNext2.setOnClickListener {
            findNavController().navigate(R.id.action_createStatsFragment_to_createDetailsFragment)
        }

        btnBack2.setOnClickListener {
            findNavController().navigate(R.id.action_createStatsFragment_to_createBasicsFragment)
        }
    }

}
