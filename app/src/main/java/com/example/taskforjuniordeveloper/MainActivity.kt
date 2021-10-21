package com.example.taskforjuniordeveloper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskforjuniordeveloper.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.InputStream
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var activityMainBinding: ActivityMainBinding? = null
    private val arrayList = ArrayList<Result>()
    private var adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        readJsonFile()
        initRecyclerView()

    }

    private fun readJsonFile() {
        val json: String

        val inputStream: InputStream = assets.open("localData.json")
        json = inputStream.bufferedReader().use {
            it.readText()
        }
        val jsonObject = JSONObject(json)

        val jsonArray = jsonObject.getJSONArray("results")
        for (i in 0 until jsonArray.length()) {
            val data = jsonArray.getJSONObject(i)
            arrayList.add(Result(data.getString("description"), data.getString("title")))
        }
    }

    private fun initRecyclerView() {
        activityMainBinding?.apply {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            adapter.setUpdateData(arrayList, applicationContext)
            recyclerView.adapter = adapter
        }
    }

}