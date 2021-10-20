package com.example.taskforjuniordeveloper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.taskforjuniordeveloper.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    var detailsActivity: ActivityDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsActivity = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val bundle = intent.extras

        val name = bundle!!.getString("name")
        val description = bundle.getString("description")

        detailsActivity?.apply {
            movieName.text = name
            movieDescription.text = description
        }

    }
}