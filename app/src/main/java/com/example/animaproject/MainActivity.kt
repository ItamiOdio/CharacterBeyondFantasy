package com.example.animaproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // Save user theme preferences
        val appSettingPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", Context.MODE_PRIVATE)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", true)

        if(isNightModeOn)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switchNight.isChecked = true;
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            switchNight.isChecked = false;
        }

    // Change theme settings when switch state is changed
    switchNight.setOnCheckedChangeListener(({ _, isChecked ->
        if (isChecked)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            sharedPrefsEdit.putBoolean("NightMode", true)
            sharedPrefsEdit.apply()
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPrefsEdit.putBoolean("NightMode", false)
            sharedPrefsEdit.apply()
        }
    }))

        btnAddCharacter.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateCharacterActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }

        btnMyCharacters.setOnClickListener {
            val intent = Intent(this@MainActivity, CharacterListActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }

    }


}
