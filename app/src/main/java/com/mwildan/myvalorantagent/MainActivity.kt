package com.mwildan.myvalorantagent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAgent: RecyclerView
    private val list = ArrayList<Agent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAgent = findViewById(R.id.rv_agent)
        rvAgent.setHasFixedSize(true)

        list.addAll(getListAgent())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAgent(): ArrayList<Agent> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listAgent = ArrayList<Agent>()
        for (i in dataName.indices) {
            val agent = Agent(dataName[i], dataDescription[i], dataPhoto[i])
            listAgent.add(agent)
        }
        return listAgent
    }

    private fun showRecyclerList() {
        rvAgent.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)
        rvAgent.adapter = listAgentAdapter

        listAgentAdapter.setOnItemClickCallback(object : ListAgentAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Agent) {
                showSelectedAgent(data)
            }
        })
    }

    private fun showSelectedAgent(agent: Agent) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("agent_name", agent.name)
        intent.putExtra("agent_description", agent.description)
        intent.putExtra("agent_photo", agent.photo)
        startActivity(intent)
    }


}