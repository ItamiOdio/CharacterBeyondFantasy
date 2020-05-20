package com.example.animaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animaproject.CreateCharacter.CreateBasicsFragment
import com.example.animaproject.CreateCharacter.CreateStatsFragment

class CreateCharacterActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val firstFragment =
        CreateBasicsFragment();
    private val secondFragment = CreateStatsFragment();



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_character)

        //val fragmentTransaction = fragmentManager.beginTransaction()
        //fragmentTransaction.replace(R.id.myFragment, firstFragment)
       // fragmentTransaction.commit()
    }
}
