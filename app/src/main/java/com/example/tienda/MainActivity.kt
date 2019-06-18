package com.example.tienda

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(),inicio_fragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var usuario:EditText?=null
    private var clave:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val barra: ActionBar?=supportActionBar

        if(barra!=null){

            barra.hide()
        } // oculta la barra de accion
        usuario=findViewById(R.id.txtusuario)
        clave=findViewById(R.id.txtclave)

    }

    fun Ingresar(view: View){

        if(usuario!!.text.toString()=="admin" && clave!!.text.toString()=="admin"){

            val intento= Intent(this,menu_princial::class.java)
            startActivity(intento)
            finish()
            //pasa al otro activity y elimina este activity
        }else{
            Toast.makeText(this,"No puedes ingresar",Toast.LENGTH_LONG).show()
        }
    } //valida el ingreso del login
}
