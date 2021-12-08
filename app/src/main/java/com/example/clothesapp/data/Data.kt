package com.example.clothesapp.data

import android.graphics.Bitmap
import android.location.Location
import com.example.clothesapp.*
import com.example.clothesapp.fragment.ImagesFragment

object data {
    val allNames = mutableListOf<ClothName>(
        TShirt(), Shirt(), Jacket(), Jeans(), Shorts(), Beanie(), Cylinder()
    )

    var currentFragment = R.id.imagesFragment//надеюсь, что найду фикс поумнее

    val clothes = arrayOf(
        "Футболка",
        "Кофта",
        "Куртка",
        "Джинсы",
        "Шорты",
        "Шапка",
        "Цилиндр"
    )

    val allColors = arrayOf(
        "Белый",
        "Чёрный",
        "Красный",
        "Синий",
        "Жёлтый",
        "Зелёный",
        "Фиолетовый",
        "Оранжевый",
        "Серый",
        "Розовый"
    )

    val allTypes = arrayOf(
        "Верх",
        "Низ",
        "Головной убор"
    )

    var nameToClothName = mapOf<String, ClothName>(
        "Футболка" to TShirt(),
        "Кофта" to Shirt(),
        "Куртка" to Jacket(),
        "Джинсы" to Jeans(),
        "Шорты" to Shorts(),
        "Шапка" to Beanie(),
        "Цилиндр" to Cylinder()
    )

    var toChoose = arrayOf(
        "Одежду",
        "Цвет одежды"
    )

    var colorNameToColor = mapOf<String, Color>(
        "Белый" to White(),
        "Чёрный" to Black(),
        "Красный" to Red(),
        "Синий" to Blue(),
        "Жёлтый" to Yellow(),
        "Зелёный" to Green(),
        "Фиолетовый" to Purple(),
        "Оранжевый" to Orange(),
        "Серый" to Gray(),
        "Розовый" to Pink()
    )

    var latlan : Location = Location("")

    var chosenItems = mutableListOf<Int>()

    var currentListOfBitmaps = mutableListOf<Bitmap>()
    var currentListOfClothes = mutableListOf<Clothes>()
}