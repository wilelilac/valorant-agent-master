package com.mwildan.myvalorantagent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val agentName = intent.getStringExtra("agent_name")
        val agentDescription = intent.getStringExtra("agent_description")
        val agentPhoto = intent.getStringExtra("agent_photo")

        val fotoAgentImageView = findViewById<ImageView>(R.id.foto_agent)
        val namaAgentTextView = findViewById<TextView>(R.id.nama_agent)
        val agentDescriptionTextView = findViewById<TextView>(R.id.agent_description)

        namaAgentTextView.text = agentName
        agentDescriptionTextView.text = agentDescription

        Glide.with(this)
            .load(agentPhoto)
            .into(fotoAgentImageView)
    }
}
