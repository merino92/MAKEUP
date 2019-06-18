package com.example.tienda

class Listado {

    fun ArmarLista():ArrayList<Productos>{
        var lista=ArrayList<Productos>()
        val a1=Productos(
            R.drawable.labial,
            "Labial",
            "Diferente tonos matte.",
            6.95
        )

        lista.add(a1)
        val a2=Productos(
            R.drawable.polvera,
            "Polvo Cover Girl",
            "Con un acabado Matte.",
            7.50
        )
        lista.add(a2)
        val a3=Productos(
            R.drawable.rubor,
            "Pomada para cejas.",
            "Pomada para cejas Beverly Hills",
            8.99
        )
        lista.add(a3)
        val a4=Productos(
            R.drawable.p1,
            "Sombras NAKED",
            "Varieda de sombras a tu gusto",
            6.67
        )
        lista.add(a4)

        val a5=Productos(
            R.drawable.rubor2,
            "Sombras JAMES CHARLES",
            "Original paleta de sombras.",
            12.00
        )
        lista.add(a5)
        val a6=Productos(
            R.drawable.sombra,
            "Rubor MAC",
            "Sientete una diva",
            17.05
        )
        lista.add(a6)
        return  lista

    }


}