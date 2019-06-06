package com.example.idol

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.lista_inicio.view.*

class FragmentInicial: Fragment() {

    //Crear la interfaz con las funciones declaradas, para abajo tomarlas y hacerles la funcionalidad implementarlas
    var listenerTool: ButtonSelect? = null

    interface ButtonSelect{
        fun agregarIdol(v: View)
        fun mostrarIdol(v: View)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view:View = inflater.inflate(R.layout.lista_inicio,container,false)

        view.bt_agregar.setOnClickListener {
            listenerTool?.agregarIdol(it)
        }

        view.rv_lista_idols.setOnClickListener {
            listenerTool?.mostrarIdol(it)
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ButtonSelect) listenerTool = context
        else throw RuntimeException("Se necesita una implementación de  la interfaz")
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }

}