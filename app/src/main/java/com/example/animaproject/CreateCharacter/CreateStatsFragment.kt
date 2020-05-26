package com.example.animaproject.CreateCharacter

import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.animaproject.CharacterInfo
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

        var newCharacter : CharacterInfo = arguments?.getSerializable("character") as CharacterInfo


        //Generate random stats for the character
        //Process of generating stats goes by the rules described in Anima Beyond Fantasy : Core Rulebook
        btnGenerate.setOnClickListener {
            run {
                val generatedValues = Array(8) {
                    Random.nextInt(3, 11) // generate 8 random values between 3 and 10
                }
                var minGenerated = generatedValues.min() // find min value in generated array

                generatedValues[generatedValues.indexOf(minGenerated)] = 9 //replace value with 9

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

        // Fill text fields with array values and navigate between fragments
        btnNext2.setOnClickListener {
            newCharacter.agility = valAgi.text.toString().toInt()
            newCharacter.constitution = valCon.text.toString().toInt()
            newCharacter.dexterity = valDex.text.toString().toInt()
            newCharacter.strength = valStr.text.toString().toInt()
            newCharacter.intelligence= valInt.text.toString().toInt()
            newCharacter.perception = valPer.text.toString().toInt()
            newCharacter.power = valPow.text.toString().toInt()
            newCharacter.willpower = valWp.text.toString().toInt()


            newCharacter.agilityMod = setModifier(newCharacter.agility)
            newCharacter.constitutionMod = setModifier(newCharacter.constitution)
            newCharacter.dexterityMod = setModifier(newCharacter.dexterity)
            newCharacter.strengthMod = setModifier(newCharacter.strength)
            newCharacter.intelligenceMod = setModifier(newCharacter.intelligence)
            newCharacter.perceptionMod = setModifier(newCharacter.perception)
            newCharacter.powerMod = setModifier(newCharacter.power)
            newCharacter.willpowerMod = setModifier(newCharacter.willpower)

            val bundle = bundleOf("character" to newCharacter)
            findNavController().navigate(R.id.action_createStatsFragment_to_createDetailsFragment, bundle)
        }

    }

    // Set modifiers for attributes. Modifier value depends on attribute, described in the rulebook
    private fun setModifier(x : Int): Int {
        val modifier: Int
        when(x)
        {
            0,1 -> modifier = -30
            2 -> modifier = -20
            3 -> modifier = -10
            4 -> modifier = -5
            5 -> modifier =  0
            6, 7 -> modifier = 5
            8, 9 -> modifier = 10
            10 -> modifier = 15
            11, 12 -> modifier = 20
            13, 14 -> modifier = 25
            15 -> modifier = 30
            16, 17 -> modifier = 35
            18, 19 -> modifier = 40
            else -> modifier = 45
        }

        return modifier
    }

}
