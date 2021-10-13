package com.udacity.shoestore

import ShoeViewModel
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    lateinit var shoeViewModel:ShoeViewModel



    /*
    *when the view is created, we adds shoes we have in our "database"
    * and create a floating action button
    * that we will add to our layout
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Action to do on click of any button beside the shoe image

        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        shoeViewModel.browseShoes()
        binding.sebago.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.let {
                getString(
                    it.toInt())
            }
        shoeViewModel.browseShoes()
        binding.nikeAir.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.let {
                getString(
                    it.toInt())
            }
        shoeViewModel.browseShoes()
        binding.jordanAir.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.let {
                getString(
                    it.toInt())
            }
        shoeViewModel.browseShoes()
        binding.dg.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.let {
                getString(
                    it.toInt())
            }
        shoeViewModel.browseShoes()
        binding.versace.text = "name: "+shoeViewModel.shoe.value?.name+" \nPrice: "+shoeViewModel.shoe.value?.price+"\nDescription: "+shoeViewModel.shoe.value?.description?.let {
                getString(
                    it.toInt())
            }

        var ll = binding.layout

        //creates a new floating button and adds to the layout
        var floatingActionButton = FloatingActionButton(this.requireContext())
        floatingActionButton.setImageResource(R.drawable.ic_add)
        floatingActionButton.id = View.generateViewId()

        ll.addView(floatingActionButton)


        floatingActionButton.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        setHasOptionsMenu(true)

        return binding.root

    }

    fun login(){
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


    /*
    *when the view is resumed, we search for new added shoes to add them in the view
    * after setting constraints
     */
    override fun onResume() {

        var ll = binding.layout
        var textView = TextView(this.activity)
        var set = ConstraintSet()
        var constraintLayout = binding.constraintLayout

        //clones the constraint set with the layout
        set.clone(constraintLayout)


        shoeViewModel.shoe.observe(this, { newShoe->

            //creates new text view
            textView.id = View.generateViewId()
            textView.text =
                "name: " + newShoe.name + " \nPrice: " + newShoe?.price + "\nDescription: " + newShoe?.description?.let {
                    getString(
                        it.toInt()
                    )
                }

            //adds constraints on the new text view and applies
            set.connect(textView.id, ConstraintSet.TOP, binding.versace.id, ConstraintSet.BOTTOM)
            set.connect(textView.id, ConstraintSet.END, binding.layout.id, ConstraintSet.END)
            set.connect(textView.id, ConstraintSet.START, binding.layout.id, ConstraintSet.START)
            textView.width = 0
            set.applyTo(constraintLayout)

            //adds the text view to the layout
            ll.addView(textView)

        })

        super.onResume()
    }


}
