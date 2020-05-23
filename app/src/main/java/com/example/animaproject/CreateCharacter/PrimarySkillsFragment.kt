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

        var attackValue = editText2.text.toString().toInt()
        var blockValue = editText3.text.toString().toInt()
        var dodgeValue = editText4.text.toString().toInt()
        var devPoints = 75 - (attackValue + blockValue + dodgeValue)
        editText.text = devPoints.toString()

        editText2.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                attackValue = editText2.text.toString().toInt()
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
                blockValue = editText3.text.toString().toInt()
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
                dodgeValue = editText4.text.toString().toInt()
                devPoints = 75 - (attackValue + blockValue + dodgeValue)
                editText.text = devPoints.toString()
            }
        })

        btnNext3.setOnClickListener {

            newCharacter.baseAttack = attackValue
            newCharacter.baseDodge = dodgeValue
            newCharacter.baseBlock = blockValue
            newCharacter.baseFatigue = newCharacter.constitution
            newCharacter.baseMovement = newCharacter.agility

            newCharacter.specialAttack = newCharacter.dexterityMod
            newCharacter.specialBlock = newCharacter.dexterityMod
            newCharacter.specialDodge = newCharacter.agilityMod

            newCharacter.finalAttack = newCharacter.baseAttack + newCharacter.specialAttack
            newCharacter.finalBlock = newCharacter.baseBlock + newCharacter.specialBlock
            newCharacter.finalDodge = newCharacter.baseDodge + newCharacter. specialDodge
            newCharacter.finalFatigue = newCharacter.baseFatigue + newCharacter.specialFatigue
            newCharacter.finalMovement = newCharacter.baseMovement + newCharacter.specialMovement
            val bundle = bundleOf("character" to newCharacter)
            findNavController().navigate(R.id.action_primarySkillsFragment_to_createFeatsFragment, bundle)
        }

        btnBack3.setOnClickListener {
            findNavController().navigate(R.id.action_primarySkillsFragment_to_createDetailsFragment)
        }


    }




}
