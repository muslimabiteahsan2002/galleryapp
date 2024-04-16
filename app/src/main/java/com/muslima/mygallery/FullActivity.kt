package com.muslima.mygallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muslima.mygallery.databinding.ActivityFullBinding
import com.squareup.picasso.Picasso

class FullActivity : AppCompatActivity() {
    private val binding:ActivityFullBinding by lazy {
        ActivityFullBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val path = intent.getStringExtra(pathKey)
        val title = intent.getStringExtra(titleKey)
        val description = intent.getStringExtra(descriptionKey)
        Picasso.get().load(path).into(binding.show)
        binding.title.text=title
        binding.description.text=description
    }
    companion object {
        const val pathKey="path"
        const val titleKey="title"
        const val descriptionKey="description"
    }
}