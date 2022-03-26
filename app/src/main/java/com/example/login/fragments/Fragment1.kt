@file:Suppress("DEPRECATION")

package com.example.login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.entities.Usuario
import com.example.login.viewmodels.Fragment1ViewModel
import com.google.android.material.snackbar.Snackbar

@Suppress("DEPRECATION")
class Fragment1 : Fragment() {

    private lateinit var viewModel: Fragment1ViewModel

    private lateinit var v : View

    private lateinit var btnLogin : Button

    var usuarios : MutableList<Usuario> = mutableListOf()

    lateinit var inMail : TextView

    lateinit var inPass : TextView

    lateinit var email : String

    lateinit var pass : String





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        usuarios.add(Usuario("ale@ale.com" , "123" , "Alejandro"))
        usuarios.add(Usuario("juan@juan" , "123" , "Juan"))
        usuarios.add(Usuario("fer@fer.com" , "123" , "Fernando"))

        v =inflater.inflate(R.layout.fragment1_fragment, container, false)
        btnLogin = v.findViewById(R.id.btnLogin)

        inMail = v.findViewById(R.id.email)
        inPass = v.findViewById(R.id.pass)
        return v
    }

    override fun onStart() {
        super.onStart()





        btnLogin.setOnClickListener {

            email = inMail.text.toString()
            pass = inPass.text.toString()

            val usuario = buscarUsuario(email , pass)

            if (usuario != null) {
                val action = Fragment1Directions.actionFragment1ToFragment2(valor = usuario.name)
                v.findNavController().navigate(action)
            } else{
                Snackbar.make(v,"Email o Contraseña incorrecta",Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    private fun buscarUsuario(mail : String, pass : String): Usuario? {

        var u = usuarios.find { e -> e.email == mail && e.pass == pass  }

        return u
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}