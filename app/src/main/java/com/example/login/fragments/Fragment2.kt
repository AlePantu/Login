package com.example.login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.login.R
import com.example.login.viewmodels.Fragment2ViewModel

@Suppress("DEPRECATION")
class Fragment2 : Fragment() {


    private lateinit var viewModel: Fragment2ViewModel
    private lateinit var v : View

    lateinit var textoRec : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment2_fragment, container, false)

        textoRec = v.findViewById(R.id.textRec)
        return v
    }

    override fun onStart() {
        super.onStart()
        var textoRecibido = Fragment2Args.fromBundle(requireArguments()).valor
         textoRec.text = textoRecibido
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Fragment2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}