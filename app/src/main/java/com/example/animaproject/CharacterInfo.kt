package com.example.animaproject

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

  class CharacterInfo: Serializable
  {
      // BASICS
      var characterID:Long = 0
      var name: String = "Name"
      var gender: String = "Gender"
      var age: String = "Age"
      var eyes: String = "Eyes"
      var hair: String = "Hair"
      var skin: String = "Skin"

      // STATS
      var agility:Int = 0
      var constitution:Int = 0
      var dexterity:Int = 0
      var strength:Int = 0
      var intelligence:Int = 0
      var perception:Int = 0
      var power:Int = 0
      var willpower:Int = 0

      var agilityMod: Int = 0
      var constitutionMod: Int = 0
      var dexterityMod:Int = 0
      var strengthMod:Int = 0
      var intelligenceMod:Int = 0
      var perceptionMod:Int = 0
      var powerMod:Int = 0
      var willpowerMod:Int = 0

      var appearance:Int = 0

      //DETAILS
      var race: String? = "Race"
      var characterClass: String? = "Class"

      //PR_SKILLS

      var baseAttack:Int = 0
      var baseBlock:Int = 0
      var baseDodge:Int = 0
      var baseMovement:Int = 0
      var baseFatigue:Int = 0

      var specialAttack:Int = 0
      var specialBlock:Int = 0
      var specialDodge:Int = 0
      var specialMovement:Int = 0
      var specialFatigue:Int = 0

      var finalAttack:Int = 0
      var finalBlock:Int = 0
      var finalDodge:Int = 0
      var finalMovement:Int = 0
      var finalFatigue:Int = 0


      //FEATS

      var advantages: String? = "Advantages"
      var disadvantages: String? = "Disadvantages"
  }


