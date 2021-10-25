package com.udacity.shoestore

import ShoeViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel:ShoeViewModel
    private var index:Int = 0

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



        val layout = binding.layout
        val textViewParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, WRAP_CONTENT)
        val floatingActionButton = FloatingActionButton(this.requireContext())


        shoeViewModel.obervable.initialization()

        shoeViewModel.obervable.shoes.observe(this.viewLifecycleOwner, {
                newShoeList->
            while (newShoeList.size > index){
                val textView = TextView(this.activity)
                textView.id = View.generateViewId()
                textView.text = "name: " + newShoeList[index].name + " \nSize: " + newShoeList[index].size + "\nDescription: " + newShoeList[index].description
                textViewParams.setMargins(16, 16, 16, 16)

                //adds the text view to the layout
                layout.addView(textView)
                textView.setLayoutParams(textViewParams)
                index++
            }
            floatingActionButton.id = View.generateViewId()

            floatingActionButton.setImageResource(R.drawable.ic_add)
            //tests if textviews have been added before adding the floating action button
            layout.addView(floatingActionButton)

        })

        floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        floatingActionButton.setLayoutParams(textViewParams)



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

}
