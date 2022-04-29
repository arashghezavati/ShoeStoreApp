package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class shoe_detailFragment : Fragment() {

private val viewModel by activityViewModels<SharedViewModel>()
    private val shoe : Shoe = Shoe("",0,"","")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater,R.layout.fragment_shoe_detail,container,false
                 )


        binding.shoe = shoe



        binding.cancelButton.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_shoe_detailFragment_to_shoelistFragment)
        }

        binding.saveButton.setOnClickListener { view:View ->
          viewModel.addNewShoe(shoe)

            view.findNavController().navigate(R.id.action_shoe_detailFragment_to_shoelistFragment)

        }

return binding.root
    }


    }
