package com.example.clothesapp

import android.graphics.Bitmap

class Clothes(var name: Name, var photo:Bitmap, var color:Color){
    var clothName = name.clothName
    var clothType = name.clothType
}

open class TypeCloth(var name: String){
    var typeName = name
}// тип одежды верх/низ

open class Color(name: String){
    var colorName = name
}// цвет одежды

open class Name (type: TypeCloth, name: String){
    var clothType = type
    var clothName = name
}// название одежды


// классы Type
class Top : TypeCloth("Верх")

class Bottom : TypeCloth("Низ")

// классы Color
class White : Color("Белый")

class Black : Color("Чёрный")

// классы Name

//верх
class TShirt : Name(Top(), "Футболка")

class Shirt : Name(Top(), "Кофта")

//низ
class Jeans : Name(Bottom(), "Джинсы")

class Shorts : Name(Bottom(), "Шорты")