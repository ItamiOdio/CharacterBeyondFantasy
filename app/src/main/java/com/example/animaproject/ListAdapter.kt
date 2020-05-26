package com.example.animaproject
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.signle_list_item.view.*

// Adapter for recyclerView
class ListAdapter (private val characterList : ArrayList<CharacterInfo>) : RecyclerView.Adapter<ListAdapter.ViewHolder>()
{

    // set layout for items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.signle_list_item, parent, false)
        return ViewHolder(view)
    }

    // count number of characters in list
    override fun getItemCount(): Int {
        return characterList.size
    }

    // set text from database in view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val character : CharacterInfo = characterList[position]
        val context = holder.imageAvatar.context
        holder.textViewName.text = character.name
        holder.textViewRace.text = character.race
        holder.textViewClass.text = character.characterClass
        holder.imageAvatar.setImageResource(R.drawable.ic_person_black_24dp)

        holder.itemView.setOnClickListener {
           val intent = Intent (context, CharacterSheetActivity::class.java)
           val charId = character.characterID.toInt()
           intent.putExtra("charid", charId)
            context.startActivity(intent)
        }

    }


        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textViewName : TextView = itemView.charName
            val textViewRace : TextView =  itemView.charRace
            val textViewClass : TextView = itemView.charClass
            val imageAvatar : ImageView = itemView.charAvatar

    }

}