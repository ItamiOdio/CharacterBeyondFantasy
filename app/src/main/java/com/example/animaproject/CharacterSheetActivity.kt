package com.example.animaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_character_sheet.*

class CharacterSheetActivity : AppCompatActivity()  {
    var db = CharacterDatabase(this) //database instance
    var charId = -1 // id of character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_sheet)

        // set action bar for activity
        setSupportActionBar(toolbar2)
        val bundle = intent.extras //get extras from intent

        charId = bundle?.getInt("charid") ?: -1 // if extras with given key are not null, set id for a given value

        // get character from database by given id
        val character :CharacterInfo = db.getSingleCharacter(charId.toLong())

        // fill text fields with data
        text_show_characterName.text = character.name
        textRace.text = character.race
        textClass.text = character.characterClass

        textAgiVal.text = character.agility.toString()
        textAgiMod.text = character.agilityMod.toString()
        textConVal.text = character.constitution.toString()
        textConMod.text = character.constitutionMod.toString()
        textDexVal.text = character.dexterity.toString()
        textDexMod.text = character.dexterityMod.toString()
        textStrVal.text = character.strength.toString()
        textStrMod.text = character.strengthMod.toString()
        textIntVal.text = character.intelligence.toString()
        textIntMod.text = character.intelligenceMod.toString()
        textPerVal.text = character.perception.toString()
        textPerMod.text = character.perceptionMod.toString()
        textPowVal.text = character.power.toString()
        textPowMod.text = character.powerMod.toString()
        textWpVal.text = character.willpower.toString()
        textWpMod.text = character.willpowerMod.toString()

        baseAttack.text = character.baseAttack.toString()
        baseBlock.text = character.baseBlock.toString()
        baseDodge.text = character.baseDodge.toString()
        dexAttack.text = character.specialAttack.toString()
        dexBlock.text = character.specialBlock.toString()
        agiDodge.text = character.specialDodge.toString()
        finalAttack.text = character.finalAttack.toString()
        finalBlock.text = character.finalBlock.toString()
        finalDodge.text = character.finalDodge.toString()

        baseFatigue.text = character.baseFatigue.toString()
        baseMovement.text = character.baseFatigue.toString()
        specialFatigue.text = character.specialFatigue.toString()
        specialMovement.text = character.specialMovement.toString()
        finalFatigue.text = character.finalFatigue.toString()
        finalMovement.text = character.finalFatigue.toString()


    }

    // ACTION BAR

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_character_sheet, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId // item chosen on action bar
        when(itemView)
        {
            R.id.editChar -> (Toast.makeText(applicationContext, "Coming soon", Toast.LENGTH_SHORT)).show()
            R.id.deleteChar ->
            {
                db.deleteCharacter(charId) //delete character
                val intent = Intent(this, CharacterListActivity::class.java) //move to the list of characters
                startActivity(intent)
            }
        }

        return true
    }
}
