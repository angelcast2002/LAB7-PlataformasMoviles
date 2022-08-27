package com.example.lab7

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class PerfilFragment: Fragment(R.layout.perfil_fragment){

    private lateinit var textNuevoCorreo : EditText
    private lateinit var buttonActualizar : Button
    private val args: PerfilFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textNuevoCorreo = view.findViewById(R.id.textInput_actualizar_perfilFragment_editText)
        setNuevoCorreo()

        buttonActualizar = view.findViewById(R.id.button_actualizar_perfilFragment)
        setListeners()
    }

    private fun setNuevoCorreo() {
        textNuevoCorreo.setText(args.email)
    }


    private fun setListeners() {
        buttonActualizar.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_perfilFragment_to_loginFragment)
        }
    }
}