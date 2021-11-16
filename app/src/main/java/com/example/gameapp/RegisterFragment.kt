package com.example.gameapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gameapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater, R.layout.fragment_register, container, false)
        binding.nextBtn.setOnClickListener {  view:View ->
//            val name = binding.nameEditText.text.toString()
//            val email = binding.emailEditText.text.toString()
//            val user = User(name, email)
//
//            val action = RegisterFragmentDirections.actionRegisterFragmentToInGameFragment(user)
//
//            val navController = view.findNavController()
//            navController.navigate(action)

        }
        return binding.root
    }
}