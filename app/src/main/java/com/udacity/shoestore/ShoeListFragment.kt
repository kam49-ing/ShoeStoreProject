package com.udacity.shoestore

import ShoeViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginLeft
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel:ShoeViewModel
    //val args:ShoeDetailFragmentArgs by navArgs()


    /*
    *when the view is created, we adds shoes we have in our "database"
    * and create a floating action button
    * that we will add to our layout
     */
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Action to do on click of any button beside the shoe image

        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        shoeViewModel = ViewModelProvider(this.requireActivity())[ShoeViewModel::class.java]
        shoeViewModel.browseShoes()


        binding.sebago.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.toString()
        shoeViewModel.browseShoes()


        binding.nikeAir.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.toString()
        shoeViewModel.browseShoes()


        binding.jordanAir.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.toString()
        shoeViewModel.browseShoes()


        binding.dg.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.toString()
        shoeViewModel.browseShoes()


        binding.versace.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.toString()
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)
        //shoeViewModel.rearangeShoes()

        return binding.root

    }

    private fun login(){
        view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_loginFragment)
    }



    //adds the option menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.login -> login()
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())|| super.onOptionsItemSelected(item)
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layout = binding.layout
        val textView = TextView(this.activity)

        shoeViewModel.shoe.observe(this.viewLifecycleOwner, { newShoe->
            shoeViewModel.rearangeShoes()
            Log.i("MainActivity", "Adding new shoe: ${newShoe.name}")

            //creates new text view
            textView.id = View.generateViewId()
            textView.text = "name: " + newShoe.name + " \nPrice: " + newShoe?.price + "\nDescription: " + newShoe?.description?.toString()

            //adds margin to the new text view and applies
            var textViewParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            textViewParams.setMargins(16, 16, 16, 16)
            textView.setLayoutParams(textViewParams)

            //adds the text view to the layout
            layout.addView(textView)

            //replaces the floating button by another
            //so that it is displayed after the last text view added
            binding.layout.removeView(binding.floatingActionButton)
            val floatingActionButton = FloatingActionButton(this.requireContext())
            floatingActionButton.id = binding.floatingActionButton.id
            layout.addView(floatingActionButton)
            floatingActionButton.setOnClickListener{
                it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
            }
            floatingActionButton.setLayoutParams(textViewParams)
            Log.i("MainActivity", "margin left: ${textView.marginLeft}")

        })
        super.onViewCreated(view, savedInstanceState)
    }
}
