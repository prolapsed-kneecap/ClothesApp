package com.example.clothesapp

import android.graphics.Bitmap

object data {
    val allNames = mutableListOf<ClothName>(
        TShirt(), Shirt(), Jacket(), Jeans(), Shorts(), Beanie(), Cylinder()
    )
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
        "Серый"
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
    var currentListOfBitmaps = mutableListOf<Bitmap>()
    var currentListOfClothes = mutableListOf<Clothes>()
}