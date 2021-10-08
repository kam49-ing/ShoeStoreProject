package com.udacity.shoestore

import ShoeViewModel
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    lateinit var shoeViewModel:ShoeViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Action to do on click of any button beside the shoe image

        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        displayShoe()
        return binding.root

    }



    fun displayShoe() {

        var newTextView = TextView(this.getActivity())
        val parent = LinearLayout(this.activity)

        newTextView.width =  0
        newTextView.height = ViewGroup.LayoutParams.WRAP_CONTENT
        shoeViewModel.nextShoe()
        newTextView.setText(shoeViewModel.shoe.value?.name)
        parent.addView(newTextView)
    }

}
