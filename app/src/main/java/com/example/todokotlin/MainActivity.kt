package com.example.todokotlin

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic  val todos = Todos("Todo Name")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = MyCustomAdapter(this) // this needs to be my custom adapter telling my list what to render

        addnewTodoBtn.setOnClickListener{
            newTodo()
        }

    }

    fun newTodo(){
        val newtodo = inputNewTODO.text.toString()
        todos.make(newtodo)
    }
    
    
    // ai es PREFS cvladia romelic gvinda globaluri cvladi ikos da mivwvdet getView() metodshi elementebis amosagebad
    fun makePreferences(){
        val newtodo = inputNewTODO.text.toString()
        val prefs = getSharedPreferences("Todo List", Context.MODE_APPEND).edit()
        prefs.putString(newtodo, newtodo)
        prefs.apply()
    }



    class MyCustomAdapter(context: Context): BaseAdapter() {


        private val mContext: Context = context

        // responsible for rendering out each row
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val row_ui = layoutInflater.inflate(R.layout.row_ui, parent, false)

            val nameTextView = row_ui.findViewById<TextView>(R.id.todo_name)
//             nameTextView.text = todos.names.get(position)
            nameTextView.text = // აი აქ რომ მივწვდე Rowში ჩაწაწერად

            return row_ui
//            val textView = TextView(mContext)
//            textView.text = "Here is my ROW for my LISTVIEW"
//            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // how many rows in list
        override fun getCount(): Int {
            //return names.size
            return todos.names.size
        }


    }

}
