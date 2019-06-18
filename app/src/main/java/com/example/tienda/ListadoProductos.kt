package com.example.tienda

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ListadoProductos(private val lista:ArrayList<Productos>?, private val context: Context ): RecyclerView.Adapter<ListadoProductos.MyViewHolder>() {



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListadoProductos.MyViewHolder {

        val vista= LayoutInflater.from(p0.context).inflate(R.layout.carta_productos,p0,false)
        return  MyViewHolder(vista)
        //retorna el cardview

    }//devuelve el contenido de cada fila en la vista



    override fun getItemCount(): Int {
        return lista!!.size
        //retorna el tama;o de la lista
    }

    override fun onBindViewHolder(vista: ListadoProductos.MyViewHolder, conta: Int) {
      val datos=lista!![conta]
        vista.titulo.text=datos.Titulo
        vista.descripcion.text=datos.Descripcion
        vista.precio.text="$"+datos.Precio
        vista.imagen.setImageResource(datos.Imagen)



    } //asigna el item a cada carta

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        internal  var titulo: TextView
        internal var  descripcion:TextView
        internal var precio:TextView
        internal var imagen:ImageView


        init {
            titulo=itemView.findViewById(R.id.txttitulo)
            descripcion=itemView.findViewById(R.id.txtdescripcion)
            precio=itemView.findViewById(R.id.txtprecio)
            imagen=itemView.findViewById(R.id.img)

        }

    } //inicializa los componentes de la carta


}


