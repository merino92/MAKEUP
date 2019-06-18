package com.example.tienda

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView.ScaleType
import android.widget.ViewSwitcher
import android.support.v4.view.LayoutInflaterCompat.setFactory
import android.widget.ImageView
import android.support.v7.app.ActionBar
import android.view.animation.AnimationUtils.loadAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import java.util.*

import kotlin.concurrent.thread
import kotlin.concurrent.timerTask
import android.support.v4.os.HandlerCompat.postDelayed
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.widget.ImageButton


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [inicio_fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [inicio_fragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

class inicio_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var salir:ImageButton?=null
    var slider:ImageSwitcher?=null
    var posicion: Int=0
    val galeria = intArrayOf(R.drawable.oferta1,R.drawable.oferta2,R.drawable.oferta3) //imagenes array
    val DURACION = 5000
    var timer: Timer? = null
    var carta1:CardView?=null
    var carta2:CardView?=null
    var carta3:CardView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_inicio_fragment, container, false)
        carta1=v.findViewById(R.id.carta1)
        carta2=v.findViewById(R.id.carta2)
        carta3=v.findViewById(R.id.carta3)
        salir=v.findViewById(R.id.btnsalir)
        salir!!.setOnClickListener {
            var intento=Intent(activity,MainActivity::class.java)
            startActivity(intento)
        }
        carta1!!.setOnClickListener {
            ListarCatalogo("Labiales")
        }
        carta2!!.setOnClickListener {
            ListarCatalogo("Rostro")
        }

        carta3!!.setOnClickListener {
            ListarCatalogo("Ojos")
        }

        val barra= activity!!.actionBar
        if(barra!=null){
            barra!!.hide()
        }
        slider=v.findViewById(R.id.imageSwitcher)
        MostrarImagenes()
        val timer = Timer()
        //Set the schedule function
        timer.scheduleAtFixedRate(
            object : TimerTask() {

               override fun run() {
                        activity!!.runOnUiThread(object :Runnable{
                            override fun run() {
                                slider!!.setImageResource(galeria[posicion])
                                posicion++
                                println(posicion)
                                if (posicion == galeria.size){
                                    posicion = 0

                                }
                            }

                        })


                       }




            },
            0,DURACION.toLong()
        )   //



        return v
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment inicio_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            inicio_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    fun MostrarImagenes(){


        slider!!.setFactory(ViewSwitcher.ViewFactory {
            val imageView = ImageView(activity)
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)

            imageView
        })
        val fadeIn = AnimationUtils.loadAnimation(activity, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(activity, R.anim.fade_out)
        slider!!.setInAnimation(fadeIn)
        slider!!.setOutAnimation(fadeOut)
        //animaicion de entrada y salida




    }


    fun ListarCatalogo(titulo:String){

        val fm = activity!!.supportFragmentManager
        val dialogFragment = Catalogo() // my custom FargmentDialog
        var args: Bundle? = null
        args?.putString("titulo", titulo)
        dialogFragment.setArguments(args)
        dialogFragment.show(fm,"hola")
    }
}

