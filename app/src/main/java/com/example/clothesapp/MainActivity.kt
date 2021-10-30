package com.example.clothesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            var image = data?.data
            try {
                var bitmap = MediaStore.Images.Media.getBitmap(contentResolver, image)
                findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)
                com.example.clothesapp.data.currentListOfBitmaps.add(bitmap)
                com.example.clothesapp.data.currentListOfClothes.add(getClothes(bitmap))
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "image error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun startGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
    }
    fun getClothes(bitmap:Bitmap):Clothes {
        return Clothes(Shirt(), bitmap, Black())
    }
}
