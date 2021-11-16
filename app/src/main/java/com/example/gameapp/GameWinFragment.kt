package com.example.gameapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class GameWinFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_win, container, false)

        view.findViewById<Button>(R.id.play_again_btn).setOnClickListener {
            view.findNavController().navigate(R.id.action_gameWinFragment_to_inGameFragment)
        }

        view.findViewById<Button>(R.id.leaderboard_btn2).setOnClickListener {
            view.findNavController().navigate(R.id.action_gameWinFragment_to_leaderBoardFragment)
        }
        return view
    }
}
