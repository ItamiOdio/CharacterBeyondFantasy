package com.example.animaproject.CreateCharacter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.animaproject.CharacterInfo

import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_create_basics.*
import kotlinx.android.synthetic.main.fragment_primary_skills.*
import java.lang.NumberFormatException

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
        var newCharacter : CharacterInfo = arguments?.getSerializable("character") as CharacterInfo

        var attackValue = editText2.text.toString().toInt() //base attack
        var blockValue = editText3.text.toString().toInt() //base block
        var dodgeValue = editText4.text.toString().toInt() //base dodge
        var devPoints = 75 - (attackValue + blockValue + dodgeValue) // number of development points that can be used for primary abilities
        editText.text = devPoints.toString()

        // Implementation for attack, block and dodge

        //if the value in a row changes, change value of remaining points. Treat null as 0
        editText2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                try
                {
                    if (editText2.text.toString().toInt() != null)
                    {
                        attackValue = editText2.text.toString().toInt()
                    }
                }
                catch (e: NumberFormatException)
                {
                    attackValue = 0
                }

                 devPoints = 75 - (attackValue + blockValue + dodgeValue)
                 editText.text = devPoints.toString()

            }
        })

        editText3.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                try
                {
                    if (editText3.text.toString().toInt() != null)
                    {
                        blockValue = editText3.text.toString().toInt()
                    }
                }
                catch (e: NumberFormatException)
                {
                    blockValue = 0
                }

                    devPoints = 75 - (attackValue + blockValue + dodgeValue)
                    editText.text = devPoints.toString()
                }

        })

        editText4.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                try
                {
                    if (editText4.text.toString().toInt() != null)
                    {
                        dodgeValue = editText4.text.toString().toInt()
                    }
                }
                catch (e: NumberFormatException)
                {
                    dodgeValue = 0
                }

                    devPoints = 75 - (attackValue + blockValue + dodgeValue)
                    editText.text = devPoints.toString()

            }
        })


        btnNext3.setOnClickListener {
            //set values of abilities
            newCharacter.baseAttack = attackValue
            newCharacter.baseDodge = dodgeValue
            newCharacter.baseBlock = blockValue
            newCharacter.baseFatigue = newCharacter.constitution
            newCharacter.baseMovement = newCharacter.agility

            //set modifiers for attributes - for attack and block from dexterity, for dodge - from agility

            newCharacter.specialAttack = newCharacter.dexterityMod
            newCharacter.specialBlock = newCharacter.dexterityMod
            newCharacter.specialDodge = newCharacter.agilityMod

            // sum up the values to get final values for abilities

            newCharacter.finalAttack = newCharacter.baseAttack + newCharacter.specialAttack
            newCharacter.finalBlock = newCharacter.baseBlock + newCharacter.specialBlock
            newCharacter.finalDodge = newCharacter.baseDodge + newCharacter. specialDodge
            newCharacter.finalFatigue = newCharacter.baseFatigue + newCharacter.specialFatigue
            newCharacter.finalMovement = newCharacter.baseMovement + newCharacter.specialMovement
            val bundle = bundleOf("character" to newCharacter)
            findNavController().navigate(R.id.action_primarySkillsFragment_to_createFeatsFragment, bundle)
        }


    }

}
