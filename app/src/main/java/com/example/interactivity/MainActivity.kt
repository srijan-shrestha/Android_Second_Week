package com.example.interactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val finTeams = findViewById<Button>(R.id.find_team)
        finTeams.setOnClickListener {
            val teamChoice = findViewById<Spinner>(R.id.team_dropdown)
            val selectedTeam = teamChoice.selectedItem

            val players = getPlayers(selectedTeam.toString())
            val reducedPlayers = players.reduce{str, item->str + '\n' + item}

            val teamDescription = getTeamDescription(selectedTeam.toString())

            val playerView = findViewById<TextView>(R.id.players)
            playerView.text = reducedPlayers

            val description = findViewById<TextView>(R.id.team_description)
            description.text = teamDescription
        }
    }

    /*Function to list players*/
    private fun getPlayers(selectedTeam: String): List<String> {
        return when (selectedTeam) {
            "Barcelona" -> listOf("Ousmane Dembele","Robert Lewandowski", "Pedri", "Ter Stegen")
            "Real Madrid" -> listOf("David Alaba", "Modric", "Toni Kroos", "Eden Hazard")
            "Arsenal" -> listOf("Gabriel Jesus", "Gabriel Martineli", "Saka", "Martin Odegard")
            "Manchester United" -> listOf("Cristiano Ronaldo", "Maguire", "Martial", "De Gea", "Rashford")
            "Manchester City" -> listOf("Haland", "De Bruyne", "Bernado Silva", "Phil Foden")
            "PSG" -> listOf("Lionel Messi", "Neymar", "Mbappe", "Sergio Ramos")
            else -> listOf("Suarez", "Iniesta")
        }
    }

    /*Function to return description*/
    private fun getTeamDescription(selectedTeam: String): String {
        return when (selectedTeam) {
            "Barcelona" -> "Futbol Club Barcelona commonly referred to as Barcelona and colloquially known as Barça is a professional football club based in Barcelona, Catalonia"
            "Real Madrid" -> "Real Madrid Club de Fútbol, commonly referred to as Real Madrid or simply Real, is a Spanish professional football club based in Madrid. Founded in 1902"
            "Arsenal" -> "Arsenal Football Club, commonly referred to as Arsenal, is a professional football club based in Islington, London, England."
            "Manchester United" -> "Manchester United Football Club, commonly referred to as Man United, or simply United, is a professional football club based in Old Trafford, Greater Manchester, England."
            "Manchester City" -> "Manchester City Football Club is an English football club based in Manchester that competes in the Premier League, the top flight of English football. Founded in 1880"
            "PSG" -> "Paris Saint-Germain Football Club, commonly referred to as Paris Saint-Germain, Paris, Paris SG or simply PSG is a professional football club based in Paris, France. "
            else -> "The selected team does not exist"
        }
    }
}