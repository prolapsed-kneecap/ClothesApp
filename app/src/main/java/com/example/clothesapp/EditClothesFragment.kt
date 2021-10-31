package com.example.clothesapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.clothesapp.data.allColors
import com.example.clothesapp.data.clothes
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditClothesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_clothes, container, false)

        val position = arguments?.getInt("position")

        if (position != null) {
            view.findViewById<TextView>(R.id.textViewChangeName).text =
                data.currentListOfClothes[position].clothName
            view.findViewById<TextView>(R.id.textViewChangeType).text =
                "${data.currentListOfClothes[position].clothType.typeName}"
            view.findViewById<TextView>(R.id.textViewChangeColor).text =
                "${data.currentListOfClothes[position].color.colorName}"
            view.findViewById<TextView>(R.id.textViewChangeWarmth).text =
                "Теплота: ${data.currentListOfClothes[position].name.clothWarmth.toString()}/10"
            view.findViewById<ImageView>(R.id.imageViewChange)
                .setImageBitmap(data.currentListOfClothes[position].photo)
        }

        view.findViewById<FloatingActionButton>(R.id.fabEdit).setOnClickListener {
            var alertDialogChooseEdit = AlertDialog.Builder(view.context)
            alertDialogChooseEdit.setTitle("Что вы хотите изменить?")
            var typePos = 0
            alertDialogChooseEdit.setSingleChoiceItems(data.toChoose, typePos) { p0, p1 ->
                typePos = p1
            }
            alertDialogChooseEdit.setPositiveButton(
                "Ок"
            ) { p0, p1 ->
                when (typePos) {
                    0 -> {
                        var ad = AlertDialog.Builder(view.context)
                        ad.setTitle("Выберите предмет одежды")
                        var pos = 0
                        ad.setSingleChoiceItems(clothes, pos) { p0, p1 -> pos = p1 }
                        ad.setPositiveButton(
                            "Ок"
                        ) { p0, p1 ->
                            val currentCloth = data.currentListOfClothes[position!!]
                            val newCloth = Clothes(
                                data.nameToClothName[clothes[pos]]!!,
                                currentCloth.photo,
                                currentCloth.color
                            )
                            data.currentListOfClothes[position] = newCloth
                            view.findViewById<TextView>(R.id.textViewChangeName).text =
                                newCloth.clothName
                            view.findViewById<TextView>(R.id.textViewChangeType).text =
                                "${newCloth.clothType.typeName}"
                            view.findViewById<TextView>(R.id.textViewChangeColor).text =
                                "${newCloth.color.colorName}"
                            view.findViewById<TextView>(R.id.textViewChangeWarmth).text =
                                "Теплота: ${newCloth.name.clothWarmth.toString()}/10"
                        }
                        ad.setNegativeButton(
                            "Отмена"
                        ) { p0, p1 -> }
                        ad.create()
                        ad.show()
                    }
                    1 -> {
                        var ad = AlertDialog.Builder(view.context)
                        ad.setTitle("Выберите предмет одежды")
                        var pos = 0
                        ad.setSingleChoiceItems(allColors, pos) { p0, p1 -> pos = p1 }
                        ad.setPositiveButton(
                            "Ок"
                        ) { p0, p1 ->
                            val currentCloth = data.currentListOfClothes[position!!]
                            val newCloth = Clothes(
                                currentCloth.name,
                                currentCloth.photo,
                                data.colorNameToColor[data.allColors[pos]]!!
                            )
                            data.currentListOfClothes[position] = newCloth
                            view.findViewById<TextView>(R.id.textViewChangeColor).text =
                                "Цвет: ${newCloth.color.colorName}"
                        }
                        ad.setNegativeButton(
                            "Отмена"
                        ) { p0, p1 -> }
                        ad.create()
                        ad.show()
                    }
                }
            }
            alertDialogChooseEdit.setNegativeButton(
                "Отмена"
            ) { p0, p1 -> }
            alertDialogChooseEdit.create()
            alertDialogChooseEdit.show()
        }
        view.findViewById<FloatingActionButton>(R.id.fabChangeOk).setOnClickListener {
            view.findNavController().navigate(R.id.action_editClothesFragment_to_imagesFragment)
        }
        return view
    }
}