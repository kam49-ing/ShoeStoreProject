package com.udacity.shoestore

import ShoeViewModel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {
    private lateinit var binding:FragmentShoeDetailBinding
    private lateinit var shoeViewModel:ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        //calls view model
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        //adds shoe to shoes list when save button is clicked
        binding.saveButton.setOnClickListener {
            var newShoe = shoeViewModel.createShoe(binding.nameEditText.text.toString(), binding.priceEditText.text.toString(), binding.descriptionEditText.text.toString())

            shoeViewModel.addShoe(newShoe)

            //closes the key board
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view?.windowToken, 0)

            //navigates to shoe list fragment
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }


}