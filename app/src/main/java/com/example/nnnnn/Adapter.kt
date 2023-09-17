package com.example.nnnnn

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class Adapter(val context: Context, val userarray:ArrayList<Dataclass>, val Interface:Interface):BaseAdapter() {
    override fun getCount(): Int {
        return userarray.size
    }

    override fun getItem(p0: Int): Any {
       return userarray[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder", "MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val row=LayoutInflater.from(context).inflate(R.layout.listview,p2,false)
        val name=row.findViewById<TextView>(R.id.nameView)
        val age=row.findViewById<TextView>(R.id.ageView)
        val image=row.findViewById<ImageView>(R.id.imageView)
        image.setImageResource(userarray[p0].img)
        name.text=userarray[p0].name
        age.text=userarray[p0].age
        row.setOnLongClickListener {
            val alertDialog=AlertDialog.Builder(context)
            alertDialog.setPositiveButton("yes",DialogInterface.OnClickListener{dialogInterface, i ->
                Interface.onProfileClick(userarray[p0].name,p0 )
            })
            val dialog=alertDialog.create()
            dialog.setMessage("Are You Sure")
            dialog.setTitle("Delete")
            dialog.show()
            true
        }
//            Interface.onProfileClick(userarray[p0].name,p0 )



        image.setOnClickListener{

            val intent=Intent(context,MainActivity2::class.java)
            intent.putExtra("image",userarray[p0].img)
            intent.putExtra("name",userarray[p0].name)
            intent.putExtra("age",userarray[p0].age)
            context.startActivities(arrayOf(intent))

        }




        return row
    }

}