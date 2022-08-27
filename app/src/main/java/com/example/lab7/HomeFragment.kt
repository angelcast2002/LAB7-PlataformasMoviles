package com.example.lab7

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class HomeFragment: Fragment(R.layout.home_fragment){

    private lateinit var textCentral : TextView
    private lateinit var buttonActualizarPerfil : Button
    private val args: HomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textCentral = view.findViewById(R.id.text_mail_homeFragment)
        setCenterText()

        buttonActualizarPerfil = view.findViewById(R.id.button_actualizarPerfil_homeFragment)

        setListeners()
    }

    private fun setCenterText() {
        textCentral.text = getString(R.string.mensage_central_homeFragment).format(args.email)
    }

    private fun setListeners() {
        buttonActualizarPerfil.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToPerfilFragment(
                email = args.email
            )
            requireView().findNavController().navigate(action)


        }
    }
}