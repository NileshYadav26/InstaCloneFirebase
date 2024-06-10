package com.nilesh.firebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("MainActivity", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("MainActivity", "Failed to read value.", error.toException())
            }
        })
    }
}