package com.example.nnnnn

import android.annotation.SuppressLint
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),Interface {
        lateinit var arrayList: ArrayList<Dataclass>
        lateinit var adapter: com.example.nnnnn.Adapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list=findViewById<ListView>(R.id.list)

        val button=findViewById<FloatingActionButton>(R.id.btn)
        arrayList=ArrayList()
        adapter= Adapter(this,arrayList,this)
        list.adapter=adapter

        button.setOnClickListener {

            showdialog()
        }

//        button.setOnClickListener {
//
//            arrayList.add(
//                Dataclass(
//                    "${nameEditText.text}",
//                    ageEditText.text.toString(),
//                    R.drawable.baseline_add_a_photo_24
//                )
//            )
//            adapter.notifyDataSetChanged()
//        }

    }

    private fun showdialog() {



        val layoutInflater= LayoutInflater.from(this).inflate(R.layout.item_add,null)
        val name=layoutInflater.findViewById<EditText>(R.id.userName)
        val Title=layoutInflater.findViewById<EditText>(R.id.userNo)

        val buttt=layoutInflater.findViewById<Button>(R.id.done)

        val cancel=layoutInflater.findViewById<Button>(R.id.cancel)
        

        val alert= AlertDialog.Builder(this)
        val dialog=alert.create()
        dialog.setView(layoutInflater)
        dialog.show()
        buttt.setOnClickListener {
            arrayList.add(Dataclass(name.text.toString(),Title.text.toString(),R.drawable.baseline_add_a_photo_24))
            Toast.makeText(this, "${name.text}", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            adapter.notifyDataSetChanged()
        }
        cancel.setOnClickListener{
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }


    }

    override fun onProfileClick (name: String, position:Int) {
        Toast.makeText(this,"deleted "+name, Toast.LENGTH_SHORT).show()
        arrayList.removeAt(position)
        adapter.notifyDataSetChanged()
    }


}