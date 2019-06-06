package com.example.idol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentInicial: Fragment() {

    //Crear la interfaz con las funciones declaradas, para abajo tomarlas y hacerles la funcionalidad implementarlas

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view:View = inflater.inflate(R.layout.lista_inicio,container,false)
        return view
    }

}