package com.example.tienda

import android.support.v4.app.DialogFragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.TextView


class Catalogo: DialogFragment() {

    var titulo:TextView?=null
    var Salir:ImageButton?=null
    var lista:RecyclerView?=null
    var titulos=""
    var l:Listado?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            val mArgs = arguments
            titulos = mArgs!!.getString("titulo")
        }
        l= Listado()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.catalogo_activity, container, false)
        titulo=v.findViewById(R.id.titulo)
        Salir=v.findViewById(R.id.btnatras)
        lista=v.findViewById(R.id.reciclador)
        titulo!!.text=titulos
        Salir!!.setOnClickListener {
            dismiss()
        }
        ArmarLista(1)
        return v
    }

    fun ArmarLista(d:Int){
        var datos=ArrayList<Productos>()
        if(d==1){
            datos=l!!.ArmarLista()
        }else if(d==2){

        }else{

        }

        var mLayoutManager = GridLayoutManager(activity,2)
        lista!!.layoutManager=mLayoutManager
        //ASIGNA LA VISTA EN CUADRICULA 2 COLUMNAS
        val adaptador=ListadoProductos(datos,activity!!.applicationContext)
        lista!!.adapter=adaptador


    }
}