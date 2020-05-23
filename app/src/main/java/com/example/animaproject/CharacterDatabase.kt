package com.example.animaproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

private val DATABASE_NAME = "DB_CHARACTERS_TEST"
    private val TABLE_BASICS = "TAB_CHARACTER"

    val CHARACTER_ID = "CHARACTER_ID"

    // BASICS

    val CHAR_ID = "CHAR_ID"
    val CHAR_NAME = "CHAR_NAME"
    val CHAR_GENDER = "CHAR_GENDER"
    val CHAR_AGE = "CHAR_AGE"
    val CHAR_EYES = "CHAR_EYES"
    val CHAR_HAIR = "CHAR_HAIR"
    val CHAR_SKIN = "CHAR_SKIN"

    // STATS

    val STATS_AGI_VAL = "STATS_AGI_VAL"
    val STATS_CON_VAL = "STATS_CON_VAL"
    val STATS_DEX_VAL = "STATS_DEX_VAL"
    val STATS_STR_VAL = "STATS_STR_VAL"
    val STATS_INT_VAL = "STATS_INT_VAL"
    val STATS_PER_VAL = "STATS_PER_VAL"
    val STATS_POW_VAL = "STATS_POW_VAL"
    val STATS_WP_VAL = "STATS_WP_VAL"

    val STATS_AGI_MOD = "STATS_AGI_MOD"
    val STATS_CON_MOD = "STATS_CON_MOD"
    val STATS_DEX_MOD = "STATS_DEX_MOD"
    val STATS_STR_MOD = "STATS_STR_MOD"
    val STATS_INT_MOD = "STATS_INT_MOD"
    val STATS_PER_MOD = "STATS_PER_MOD"
    val STATS_POW_MOD = "STATS_POW_MOD"
    val STATS_WP_MOD = "STATS_WP_MOD"

    val STATS__APPEARANCE = "STATS_APPEARANCE"

    //  DETAILS
    val DETAILS_RACE = "DETAILS_RACE"
    val DETAILS_CLASS = "DETAILS_CLASS"

    // PR_SKILLS

    val PR_ATTACK_PRIM = "PR_ATTACK_PRIM"
    val PR_DODGE_PRIM = "PR_DODGE_PRIM"
    val PR_BLOCK_PRIM = "PR_BLOCK_PRIM"
    val PR_FATIGUE_PRIM = "PR_FATIGUE_PRIM"
    val PR_MOVEMENT_PRIM = "PR_MOVEMENT_PRIM"

    val PR_ATTACK_MOD = "PR_ATTACK_MOD"
    val PR_DODGE_MOD = "PR_DODGE_MOD"
    val PR_BLOCK_MOD = "PR_BLOCK_MOD"
    val PR_FATIGUE_MOD = "PR_FATIGUE_MOD"
    val PR_MOVEMENT_MOD = "PR_MOVEMENT_MOD"

    val PR_ATTACK_FIN = "PR_ATTACK_FIN"
    val PR_DODGE_FIN = "PR_DODGE_FIN"
    val PR_BLOCK_FIN = "PR_BLOCK_FIN"
    val PR_MOVEMENT_FIN = "PR_MOVEMENT_FIN"
    val PR_FATIGUE_FIN = "PR_FATIGUE_FIN"

   // FEATS
    val ADVANTAGES = "ADVANTAGES"
    val DISADVENTAGES = "DISADVENTAGES"

    class CharacterDatabase (var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
        override fun onCreate(db: SQLiteDatabase?) {
            val createTable = "CREATE TABLE "+ TABLE_BASICS+" ("+
                    CHAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CHAR_NAME+ " VARCHAR(60), " +
                    CHAR_GENDER+ " VARCHAR(20), "+
                    CHAR_AGE+ " INTEGER, "+
                    CHAR_EYES+" VARCHAR(20),"+
                    CHAR_HAIR+" VARCHAR(20),"+
                    CHAR_SKIN+" VARCHAR(20), "+

                    STATS_AGI_VAL+" INTEGER, "+
                    STATS_CON_VAL+" INTEGER, "+
                    STATS_DEX_VAL+" INTEGER, "+
                    STATS_STR_VAL+" INTEGER, "+
                    STATS_INT_VAL+" INTEGER, "+
                    STATS_PER_VAL+" INTEGER, "+
                    STATS_POW_VAL+" INTEGER, "+
                    STATS_WP_VAL+" INTEGER, "+

                    STATS_AGI_MOD+" INTEGER, "+
                    STATS_CON_MOD+" INTEGER, "+
                    STATS_DEX_MOD+" INTEGER, "+
                    STATS_STR_MOD+" INTEGER, "+
                    STATS_INT_MOD+" INTEGER, "+
                    STATS_PER_MOD+" INTEGER, "+
                    STATS_POW_MOD+" INTEGER, "+
                    STATS_WP_MOD+" INTEGER, "+

                    STATS__APPEARANCE+" INTEGER, "+

                    DETAILS_RACE+ " VARCHAR(40), "+
                    DETAILS_CLASS+ " VARCHAR(40), " +

                    PR_ATTACK_PRIM+ " INTEGER, "+
                    PR_BLOCK_PRIM+ " INTEGER, "+
                    PR_DODGE_PRIM+ " INTEGER, "+
                    PR_FATIGUE_PRIM+ " INTEGER, "+
                    PR_MOVEMENT_PRIM+ " INTEGER, "+

                    PR_ATTACK_MOD+ " INTEGER, "+
                    PR_BLOCK_MOD+ " INTEGER, "+
                    PR_DODGE_MOD+ " INTEGER, "+
                    PR_FATIGUE_MOD+ " INTEGER, "+
                    PR_MOVEMENT_MOD+ " INTEGER, "+

                    PR_ATTACK_FIN+ " INTEGER, "+
                    PR_BLOCK_FIN+ " INTEGER, "+
                    PR_DODGE_FIN+ " INTEGER, "+
                    PR_FATIGUE_FIN+ " INTEGER, "+
                    PR_MOVEMENT_FIN+ " INTEGER, "+

                    ADVANTAGES+" VARCHAR(250), "+
                    DISADVENTAGES+" VARCHAR(250))"

            db?.execSQL(createTable)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun insertData(character : CharacterInfo)
        {
            val db = this.writableDatabase
            val cv = ContentValues()
            cv.put(CHAR_NAME, character.name)
            cv.put(CHAR_GENDER, character.gender)
            cv.put(CHAR_AGE, character.age)
            cv.put(CHAR_EYES, character.eyes)
            cv.put(CHAR_HAIR, character.hair)
            cv.put(CHAR_SKIN, character.skin)

            cv.put(STATS_AGI_VAL, character.agility)
            cv.put(STATS_CON_VAL, character.constitution)
            cv.put(STATS_DEX_VAL, character.dexterity)
            cv.put(STATS_STR_VAL, character.strength)
            cv.put(STATS_INT_VAL, character.intelligence)
            cv.put(STATS_PER_VAL, character.perception)
            cv.put(STATS_POW_VAL, character.power)
            cv.put(STATS_WP_VAL, character.willpower)

            cv.put(STATS_AGI_MOD, character.agilityMod)
            cv.put(STATS_CON_MOD, character.constitutionMod)
            cv.put(STATS_DEX_MOD, character.dexterityMod)
            cv.put(STATS_STR_MOD, character.strengthMod)
            cv.put(STATS_INT_MOD, character.intelligenceMod)
            cv.put(STATS_PER_MOD, character.perceptionMod)
            cv.put(STATS_POW_MOD, character.powerMod)
            cv.put(STATS_WP_MOD, character.willpowerMod)

            cv.put(STATS__APPEARANCE, character.appearance)

            cv.put(DETAILS_RACE, character.race)
            cv.put(DETAILS_CLASS, character.characterClass)

            cv.put(PR_ATTACK_PRIM, character.baseAttack)
            cv.put(PR_BLOCK_PRIM, character.baseBlock)
            cv.put(PR_DODGE_PRIM, character.baseDodge)
            cv.put(PR_FATIGUE_PRIM, character.baseFatigue)
            cv.put(PR_MOVEMENT_PRIM, character.baseMovement)

            cv.put(PR_ATTACK_MOD, character.specialAttack)
            cv.put(PR_BLOCK_MOD, character.specialBlock)
            cv.put(PR_DODGE_MOD, character.specialDodge)
            cv.put(PR_FATIGUE_MOD, character.specialFatigue)
            cv.put(PR_MOVEMENT_MOD, character.specialMovement)

            cv.put(PR_ATTACK_FIN, character.finalAttack)
            cv.put(PR_BLOCK_FIN, character.finalBlock)
            cv.put(PR_DODGE_FIN, character.finalDodge)
            cv.put(PR_FATIGUE_FIN, character.finalFatigue)
            cv.put(PR_MOVEMENT_FIN, character.finalMovement)

            cv.put(ADVANTAGES, character.advantages)
            cv.put(DISADVENTAGES, character.disadvantages)

            var result = db.insert(TABLE_BASICS, null, cv)
            if(result== (-1).toLong())
            {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            }
        }

    }