package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentInstructionBinding = FragmentInstructionBinding.inflate(inflater, container, false)

        //navigates to shoe list fragment
        binding.shoeListButton.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }
        return binding.root
    }

}