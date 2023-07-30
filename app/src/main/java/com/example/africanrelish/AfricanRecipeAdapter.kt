package com.example.africanrelish

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class AfricanRecipeAdapter(private val context: Activity, private val arrayList: ArrayList<AfricanRecipeItem>): ArrayAdapter<AfricanRecipeItem>(context,
    R.layout.african_recipe_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.african_recipe_item, null)

        val recipeImage: ImageView = view.findViewById(R.id.recipe_photo)
        val recipeTitle: TextView = view.findViewById(R.id.recipe_title)
        val recipeType: TextView = view.findViewById(R.id.recipe_meal_type)
        val recipeDifficulty: TextView = view.findViewById(R.id.recipe_difficulty)

        recipeImage.setImageResource(arrayList[position].recipe_image)
        recipeTitle.text=arrayList[position].recipe_title
        recipeType.text=arrayList[position].recipe_type
        recipeDifficulty.text=arrayList[position].recipe_difficulty


        return view
    }
}