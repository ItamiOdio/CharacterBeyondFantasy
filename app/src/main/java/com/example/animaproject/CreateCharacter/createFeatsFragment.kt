package com.example.animaproject.CreateCharacter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.animaproject.CharacterDatabase
import com.example.animaproject.CharacterInfo
import com.example.animaproject.CharacterListActivity

import com.example.animaproject.R
import kotlinx.android.synthetic.main.fragment_create_basics.*
import kotlinx.android.synthetic.main.fragment_create_feats.*

/**
 * A simple [Fragment] subclass.
 */
class createFeatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_feats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var newCharacter : CharacterInfo = arguments?.getSerializable("character") as CharacterInfo

        btnBack5.setOnClickListener {
            findNavController().navigate(R.id.action_createFeatsFragment_to_primarySkillsFragment)
        }

        btnDone.setOnClickListener {
            newCharacter.advantages = writeAdventages.text.toString()
            newCharacter.disadvantages = writeDisadvantages.text.toString()
            val db=CharacterDatabase(requireContext())
            db.insertData(newCharacter)
            val intent = Intent(requireContext(), CharacterListActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }
    }
}
