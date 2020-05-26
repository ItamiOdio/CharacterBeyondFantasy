package com.example.animaproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_character_list.*
import kotlinx.android.synthetic.main.signle_list_item.view.*

class CharacterListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        var db = CharacterDatabase(this)

        // set layout to recycler view, fill with data from database
        recyclerChars.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        var characters = db.getCharacters() as ArrayList<CharacterInfo>
        recyclerChars.adapter = ListAdapter(characters)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@CharacterListActivity, MainActivity::class.java)
        startActivity(intent)
    }
}



