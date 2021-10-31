package com.example.clothesapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.clothesapp.data.data
import com.example.clothesapp.data.data.currentListOfBitmaps
import com.example.clothesapp.data.data.currentListOfClothes
import com.example.clothesapp.fragment.AddImageFragment
import com.example.clothesapp.fragment.EditClothesFragment
import com.example.clothesapp.fragment.ImagesFragment
import com.example.clothesapp.fragment.RemoveFragment
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
                currentListOfBitmaps.add(bitmap)
                currentListOfClothes.add(getClothes(bitmap))
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "image error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.removeItem -> {
                val currentFragment = getVisibleFragment()
                Log.d("ABOBA", currentFragment.toString())
                Log.d("ABOBA", "i"+ImagesFragment().toString())
                Log.d("ABOBA", "a"+AddImageFragment().toString())
                Log.d("ABOBA", "e"+EditClothesFragment().toString())
//                supportFragmentManager.fragments.forEach {
//                    Log.d("ABOBA", "x$it")
//                }
                Log.d("ABOBA", "x${data.currentFragment}")
//                currentFragment!!.requireView().findNavController().navigate(R.id.action_imagesFragment_to_removeFragment)
                when(data.currentFragment){
                    R.id.imagesFragment -> {
                        currentFragment!!.requireView().findNavController().navigate(R.id.action_imagesFragment_to_removeFragment)
                    }
                    R.id.changeImageFragment -> {
                        currentFragment!!.requireView().findNavController().navigate(R.id.action_changeImageFragment_to_removeFragment)
                    }
                    R.id.editClothesFragment -> {
                        currentFragment!!.requireView().findNavController().navigate(R.id.action_editClothesFragment_to_removeFragment)
                    }
//                    NavHostFragment -> Toast.makeText(this, "ШТО? ${currentFragment!!.id}", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.setItem -> {
                Toast.makeText(this, "set", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun startGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
    }

    private fun getClothes(bitmap: Bitmap): Clothes {
        return Clothes(Shirt(), bitmap, Black())
    }

    private fun getVisibleFragment(): Fragment? {
        val fragmentManager: FragmentManager = this@MainActivity.supportFragmentManager
        val fragments: List<Fragment> = fragmentManager.fragments
        for (fragment in fragments) {
            if (fragment.isVisible)
                return fragment
        }
        return null
    }
}
