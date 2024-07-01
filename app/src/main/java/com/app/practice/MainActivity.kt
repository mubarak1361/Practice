package com.app.practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.app.practice.adapter.CompetencyTopicListAdapter
import com.app.practice.model.CompetencyTopic
//https://medium.com/@sneha.bhat/expand-collapse-animation-in-recyclerview-a17021186315
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val topics = listOf(
            CompetencyTopic("1", "Industrial Goods", "LEAD"),
            CompetencyTopic("2", "Industrial Goods", "LEAD"),
            CompetencyTopic("3", "Industrial Goods", "LEAD"))
        recyclerView.adapter = CompetencyTopicListAdapter(topics)
    }
}