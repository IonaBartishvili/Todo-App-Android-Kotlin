package com.example.todokotlin


data class Todos(val name:String){
    //database
    val names = arrayListOf<String>(
        "Donald Trump"
    )

    fun make(newtodo: String) {
        names.add(newtodo)
    }

    fun getList(): ArrayList<String> {
        return names
    }
}
