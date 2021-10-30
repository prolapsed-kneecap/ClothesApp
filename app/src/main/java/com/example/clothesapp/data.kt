package com.example.clothesapp

import android.graphics.Bitmap
import java.util.jar.JarEntry

object data {
    var allNames = mutableListOf<Name>(
        TShirt(), Shirt(), Jeans(), Shorts()
    )
    var currentListOfBitmaps = mutableListOf<Bitmap>()
    var currentListOfClothes = mutableListOf<Clothes>()
}