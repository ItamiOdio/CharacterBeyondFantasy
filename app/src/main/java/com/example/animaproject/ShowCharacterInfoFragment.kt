package com.example.animaproject

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_character_sheet.*


/**
 * A simple [Fragment] subclass.
 */
class ShowCharacterInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_character_info, container, false)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.menu_character_sheet, menu)
      super.onCreateOptionsMenu(menu, inflater)
  }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
       var itemView = item.itemId
       when(itemView) {

      R.id.editChar -> Toast.makeText(activity, "Coming soon", Toast.LENGTH_SHORT).show()
      }
      return super.onOptionsItemSelected(item)
   }
}
