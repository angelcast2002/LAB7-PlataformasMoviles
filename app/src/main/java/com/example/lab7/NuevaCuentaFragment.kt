package com.example.lab7

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class NuevaCuentaFragment: Fragment(R.layout.nueva_cuenta_fragment){

    private lateinit var buttonCrearCuenta: Button
    private lateinit var textCorreo: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCrearCuenta = view.findViewById(R.id.button_crearCuenta_nuevaCuentaFragment)
        textCorreo = view.findViewById(R.id.textInput_ingresaCorreo_nuevaCuentaFragment_editText)

        setListeners()
    }

    private fun setListeners() {
        buttonCrearCuenta.setOnClickListener {

            val action = NuevaCuentaFragmentDirections.actionNuevaCuentaFragmentToHomeFragment(
                email = textCorreo.getText().toString()
            )
            requireView().findNavController().navigate(action)
        }

    }
}