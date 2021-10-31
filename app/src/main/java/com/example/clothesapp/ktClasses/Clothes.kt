package com.example.clothesapp

import android.graphics.Bitmap

class Clothes(var name: ClothName, var photo: Bitmap, var color: Color) {
    var clothName = name.clothName
    var clothType = name.clothType
}

open class TypeCloth(var name: String) {
    var typeName = name
}// тип одежды верх/низ

open class Color(name: String) {
    var colorName = name
}// цвет одежды

open class ClothName(type: TypeCloth, name: String, warmth:Int) {
    var clothType = type
    var clothName = name
    var clothWarmth = warmth
}// название одежды


// классы Type
class Top : TypeCloth("Верх")

class Bottom : TypeCloth("Низ")

class Hats : TypeCloth("Головной убор")

// классы Color
class White : Color("Белый")

class Black : Color("Чёрный")

class Red : Color("Красный")

class Blue : Color("Синий")

class Yellow : Color("Жёлтый")

class Green : Color("Зелёный")

class Purple : Color("Фиолетовый")

class Orange : Color("Оранжевый")

class Gray : Color("Серый")

class Pink : Color("Розовый")




// классы Name

//верх
class TShirt : ClothName(Top(), "Футболка", 2)

class Shirt : ClothName(Top(), "Кофта", 5)

class Jacket : ClothName(Top(), "Куртка", 8)

//низ
class Jeans : ClothName(Bottom(), "Джинсы", 5)

class Shorts : ClothName(Bottom(), "Шорты", 2)

//головной убор
class Beanie : ClothName(Hats(), "Шапка", 8)

class Cylinder : ClothName(Hats(), "Цилиндр", 5)