package com.example.idol

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idol.data.Idol
import kotlinx.android.synthetic.main.lista_inicio.view.*

class FragmentInicial: Fragment() {

    //Crear la interfaz con las funciones declaradas, para abajo tomarlas y hacerles la funcionalidad implementarlas
    private lateinit var idols: ArrayList<Idol>
    private lateinit var idolsAdapter: IdolAdapter
    var listenerTool: ViewSelect? = null

    interface ViewSelect{
        fun agregarIdol(v: View)
        fun mostrarIdol(idol: Idol)
    }
    companion object {
        fun newInstance(dataset: ArrayList<Idol>): FragmentInicial{
            val newFragment = FragmentInicial()
            newFragment.idols = dataset
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view:View = inflater.inflate(R.layout.lista_inicio,container,false)

        //Manjeo del RecyclerView
        var linearLayoutManager = LinearLayoutManager(this.context)
        idolsAdapter = IdolAdapter(idols, {idol:Idol->listenerTool?.mostrarIdol(idol)})
        //view.rv_lista_idols.adapter = idolsAdapter as IdolAdapter

        view.rv_lista_idols.apply {
            adapter= idolsAdapter
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }

        //Manejo del boton agregar
        view.bt_agregar.setOnClickListener {
            listenerTool?.agregarIdol(it)
        }

        return view
    }

    fun updateIdolAdapter(idolList: ArrayList<Idol>){ idolsAdapter.updateList(idolList)}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ViewSelect) listenerTool = context
        else throw RuntimeException("Se necesita una implementación de  la interfaz")
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }

}