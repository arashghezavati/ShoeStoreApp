package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import kotlinx.android.synthetic.main.shoe_item.*


class ShoelistFragment : Fragment() {

    private val viewModel by activityViewModels<SharedViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
val binding = DataBindingUtil.inflate<FragmentShoelistBinding>(inflater,R.layout.fragment_shoelist,container,false)

        binding.addShoeButton.setOnClickListener{ view:View ->
            view.findNavController().navigate(R.id.action_shoelistFragment_to_shoe_detailFragment)

        }
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe in shoeList){
                val shoeItemBinding :ShoeItemBinding = DataBindingUtil.inflate(inflater,R.layout.shoe_item,container,false

                )
                shoeItemBinding.shoeNameListItem.text= shoe.name
                shoeItemBinding.companyNameListItem.text = shoe.company
                shoeItemBinding.shoeSizeListItem.text = shoe.size.toString()
                shoeItemBinding.descriptionListItem.text =shoe.description
                binding.innerLayout.addView(shoeItemBinding.root)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
        //viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        }
}

