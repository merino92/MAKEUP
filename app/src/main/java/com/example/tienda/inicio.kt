package com.example.tienda

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.NavigationMenu
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.view.Menu
import android.view.MenuItem
import java.util.*

class inicio : AppCompatActivity(),inicio_fragment.OnFragmentInteractionListener, tienda.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    var preferencias:SharedPreferences?=null
    val manage=supportFragmentManager
    var nave:BottomNavigationView?=null
    var editor:SharedPreferences.Editor?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val barra: ActionBar?=supportActionBar
            nave= findViewById(R.id.navegador)
        ArmarMenu()
        preferencias=getSharedPreferences("tienda",Context.MODE_PRIVATE)
        editor= preferencias!!.edit()
        val transiscion = manage.beginTransaction()
        val fragmentocliente = inicio_fragment()
        transiscion.replace(R.id.fragmentador, fragmentocliente)
        transiscion.addToBackStack(null)
        transiscion.commit()
    }


    var contador_estado:Int?=null
    fun ArmarMenu(){

        nave!!.setOnNavigationItemSelectedListener(object:BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(i: MenuItem): Boolean {
                contador_estado=i.itemId
                //guarda que fragmento esta seleccionado
                when (i.itemId){
                    R.id.inicio ->{

                        val transiscion = manage.beginTransaction()
                        val fragmentocliente = inicio_fragment()
                        transiscion.replace(R.id.fragmentador, fragmentocliente)
                        transiscion.addToBackStack(null)
                        transiscion.commit()
                        //muestra el fragmento inicio
                    }

                    R.id.tienda ->{
                        val transiscion = manage.beginTransaction()
                        val fragmentocliente = tienda()
                        transiscion.replace(R.id.fragmentador, fragmentocliente)
                        transiscion.addToBackStack(null)
                        transiscion.commit()

                    }

                }

                return true

            }


        })

    }

    override fun onPause() {

        if(contador_estado!=null) {
            editor!!.putInt("fragmento", contador_estado!!)
            editor!!.commit()
        }
        super.onPause()
    } //guarda el ultimo fragmento visitado

    override fun onDestroy() {
        preferencias!!.edit().clear()
        //borra las preferencias
        super.onDestroy()
    }

    override fun onResume() {
        val fragmento=preferencias!!.getInt("fragmento",0)


            when(fragmento){
                R.id.inicio->{
                    val transiscion = manage.beginTransaction()
                    val fragmentocliente = inicio_fragment()
                    transiscion.replace(R.id.fragmentador, fragmentocliente)
                    transiscion.addToBackStack(null)
                    transiscion.commit()
                    //muestra el fragmento inicio
                }
                R.id.tienda->{
                    val transiscion = manage.beginTransaction()
                    val fragmentocliente = tienda()
                    transiscion.replace(R.id.fragmentador, fragmentocliente)
                    transiscion.addToBackStack(null)
                    transiscion.commit()
                }
                else->{
                    val transiscion = manage.beginTransaction()
                    val fragmentocliente = inicio_fragment()
                    transiscion.replace(R.id.fragmentador, fragmentocliente)
                    transiscion.addToBackStack(null)
                    transiscion.commit()
                    //muestra el fragmento inicio
                }
            }



        super.onResume()
    } //vuelve a colocar el ultimo fragmento visitado por el cliente


}
