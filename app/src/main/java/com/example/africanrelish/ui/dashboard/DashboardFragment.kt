package com.example.africanrelish.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.africanrelish.AfricanRecipe
import com.example.africanrelish.AfricanRecipeAdapter
import com.example.africanrelish.AfricanRecipeItem
import com.example.africanrelish.R
import com.example.africanrelish.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var recipeArrayList: ArrayList<AfricanRecipeItem>


    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root



        // Get the reference to the ListView
        listView = root.findViewById(R.id.recipe_list)

        // Sample data for the ListView
        val recipe_images = intArrayOf(
            R.drawable.chow,
            R.drawable.salad,
            R.drawable.jollof,
            R.drawable.morocoo,



            )
        val recipe_titles = arrayOf(
            "South African Breakfast Bunny Chow",
            "Moroccan Chickpea Salad",
            "Nigerian Jollof Rice with Grilled Chicken",
            "Moroccan Spiced Roasted Chickpeas",
        )
        val recipe_types = arrayOf(
            "Breakfast",
            "Lunch",
            "Dinner",
            "Snack",
        )
        val recipe_difficulties = arrayOf(
            "Beginner",
            "Advanced",
            "Intermediate",
            "Beginner",

        )
        val recipe_quantites = intArrayOf(
            4,2,4,4
        )
        val recipe_ingredients= arrayOf(
            "- 4 small bread loaves (hollowed out)\n" +
                    "   - 4 large eggs\n" +
                    "   - 1/2 lb bacon, cooked and chopped\n" +
                    "   - 1 cup cherry tomatoes, halved\n" +
                    "   - 1 cup grated cheddar cheese\n" +
                    "   - Salt and pepper to taste\n",
            "- 2 cans chickpeas, drained and rinsed\n" +
                    "   - 1 cucumber, diced\n" +
                    "   - 1 red bell pepper, diced\n" +
                    "   - 1/2 cup cherry tomatoes, halved\n" +
                    "   - 1/4 cup chopped fresh parsley\n" +
                    "   - 1/4 cup chopped fresh mint\n" +
                    "   - 1/4 cup crumbled feta cheese\n" +
                    "   - Juice of 1 lemon\n" +
                    "   - 2 tablespoons extra-virgin olive oil\n" +
                    "   - Salt and pepper to taste\n",
            "- 2 cups long-grain rice\n" +
                    "   - 1 lb chicken drumsticks or thighs\n" +
                    "   - 1 onion, chopped\n" +
                    "   - 2 red bell peppers, diced\n" +
                    "   - 2 tomatoes, chopped\n" +
                    "   - 3 tablespoons tomato paste\n" +
                    "   - 2 cups chicken broth\n" +
                    "   - 1 teaspoon ground ginger\n" +
                    "   - 1 teaspoon ground cumin\n" +
                    "   - 1 teaspoon paprika\n" +
                    "   - 1 teaspoon thyme\n" +
                    "   - Salt and pepper to taste\n" +
                    "   - Vegetable oil\n",
            "- 2 cans chickpeas, drained and rinsed\n" +
                    "   - 2 tablespoons olive oil\n" +
                    "   - 1 teaspoon ground cumin\n" +
                    "   - 1 teaspoon ground coriander\n" +
                    "   - 1/2 teaspoon paprika\n" +
                    "   - 1/4 teaspoon cayenne pepper (optional)\n" +
                    "   - Salt and pepper to taste\n",

        )
        val recipe_preparation_steps = arrayOf(
            "   - Preheat the oven to 350°F (175°C).\n" +
                    "   - Place the hollowed-out bread loaves on a baking sheet.\n" +
                    "   - Crack an egg into each bread loaf, making sure the yolk is intact.\n" +
                    "   - Sprinkle bacon, cherry tomatoes, and cheddar cheese over the eggs.\n" +
                    "   - Season with salt and pepper.\n" +
                    "   - Bake for about 15-20 minutes or until the eggs are cooked to your liking.\n" +
                    "   - Serve the South African Breakfast Bunny Chow hot.\n",
            "   - In a large bowl, combine chickpeas, cucumber, red bell pepper, cherry tomatoes, parsley, and mint.\n" +
                    "   - Add crumbled feta cheese, lemon juice, and olive oil. Toss to mix well.\n" +
                    "   - Season with salt and pepper.\n" +
                    "   - Chill the Moroccan Chickpea Salad in the refrigerator before serving.\n",
            "- In a pot, heat vegetable oil and sauté onions and red bell peppers until softened.\n" +
                    "   - Add chicken drumsticks or thighs and cook until browned.\n" +
                    "   - Stir in chopped tomatoes, tomato paste, ground ginger, cumin, paprika, thyme, salt, and pepper.\n" +
                    "   - Add rice and mix well, then pour in the chicken broth.\n" +
                    "   - Cover and simmer until the rice is cooked and absorbs the flavors.\n" +
                    "   - Meanwhile, grill the chicken until fully cooked.\n" +
                    "   - Serve Nigerian Jollof Rice with Grilled Chicken.\n",
            "- Preheat the oven to 400°F (200°C).\n" +
                    "   - In a bowl, toss chickpeas with olive oil, ground cumin, ground coriander, paprika, cayenne pepper (if using), salt, and pepper until well coated.\n" +
                    "   - Spread the seasoned chickpeas in a single layer on a baking sheet.\n" +
                    "   - Roast in the oven for about 25-30 minutes or until crispy and golden brown.\n" +
                    "   - Let the Moroccan Spiced Roasted Chickpeas cool before serving as a tasty and healthy snack.\n",
                    )
        // Create an ArrayAdapter to populate the ListView with data
        recipeArrayList=ArrayList()
        for (i in recipe_types.indices){
            val recipe = AfricanRecipeItem(recipe_types[i],recipe_titles[i], recipe_quantites[i], recipe_difficulties[i], recipe_ingredients[i], recipe_preparation_steps[i], recipe_images[i] )
            recipeArrayList.add(recipe)
        }

        listView.isClickable = true
        listView.adapter = AfricanRecipeAdapter(requireContext() as Activity, recipeArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            val recipe_type = recipe_types[position]
            val recipe_difficulty = recipe_difficulties[position]
            val recipe_image = recipe_images[position]
            val recipe_title = recipe_titles[position]
            val recipe_quantity = recipe_quantites[position]
            val recipe_ingredients = recipe_ingredients[position]
            val recipe_preparation_steps = recipe_preparation_steps[position]


            val i = Intent(requireContext() as Activity, AfricanRecipe::class.java)
            i.putExtra("recipe_type", recipe_type)
            i.putExtra("recipe_difficulty", recipe_difficulty)
            i.putExtra("recipe_image", recipe_image)

            i.putExtra("recipe_title", recipe_title)
            i.putExtra("recipe_quantity", recipe_quantity)
            i.putExtra("recipe_ingredients", recipe_ingredients)
            i.putExtra("recipe_preparation_steps", recipe_preparation_steps)


            startActivity(i)

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}