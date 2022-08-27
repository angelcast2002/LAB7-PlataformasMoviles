package com.example.lab7

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment: Fragment(R.layout.login_fragment){

    private lateinit var buttonIniciarSesion: Button
    private lateinit var buttonNuevaCuenta: Button
    private lateinit var textCorreo: EditText
    private lateinit var correo: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonIniciarSesion = view.findViewById(R.id.button_iniciarSesion_loginfragment)
        buttonNuevaCuenta = view.findViewById(R.id.button_nuevoUsuario_loginFragment)
        textCorreo = view.findViewById(R.id.textInput_loginFragment_editText)

        setListeners()
    }

    private fun setListeners() {
        buttonIniciarSesion.setOnClickListener {

            correo = textCorreo.getText().toString()

            if(correo == getString(R.string.correoCorrecto)){
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    email = correo
                )
                requireView().findNavController().navigate(action)
            }

            else{
                Toast.makeText(getActivity(), getString(R.string.textToast), Toast.LENGTH_LONG).show()
            }

        }

        buttonNuevaCuenta.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_loginFragment_to_nuevaCuentaFragment)
        }
    }
}