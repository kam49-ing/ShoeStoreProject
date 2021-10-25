package com.udacity.shoestore

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
import com.udacity.shoestore.models.Shoe
import ShoeViewModel


class ShoeDetailFragment : Fragment() {
    private lateinit var binding:FragmentShoeDetailBinding
    private lateinit var shoeViewModel: ShoeViewModel
    private val shoe: Shoe = Shoe("", "", "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.shoe = shoe
        binding.lifecycleOwner = this


        //calls view model
        shoeViewModel = ViewModelProvider(this.requireActivity())[ShoeViewModel::class.java]

        //adds shoe to shoes list when save button is clicked


        binding.saveButton.setOnClickListener {
            val newShoe = shoeViewModel.obervable.createShoe(binding.nameEditText.text.toString(), binding.priceEditText.text.toString(), binding.descriptionEditText.text.toString())

            shoeViewModel.obervable.setShoe(newShoe)

            //closes the key board
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view?.windowToken, 0)

            //navigates to shoe list fragment
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }


}
