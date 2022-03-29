package com.example.hw10_3

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw10_3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate (inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayOfConstraintLayouts= arrayOf(binding.const1,binding.const2,binding.const3,
            binding.const4,binding.const5,binding.const6)
        val arrayOfImageViews= arrayOf(binding.imageView1,binding.imageView2,
            binding.imageView3,binding.imageView4,binding.imageView5,binding.imageView6)
        val arrayOfTextViews= arrayOf(binding.textView1,binding.textView2,
            binding.textView3,binding.textView4,binding.textView5,binding.textView6)

        val pref2 = requireActivity().getSharedPreferences("share2", Context.MODE_PRIVATE)
        var x=4
        val y=pref2.getInt("numberOfItem",-1)
        if (y!=-1){
            x=y
        }
        for (i in x until arrayOfConstraintLayouts.size){
            arrayOfConstraintLayouts[i].visibility=View.GONE
        }

       // for (i in Storage.item until arrayOfConstraintLayouts.size){
       //    arrayOfConstraintLayouts[i].visibility=View.GONE
       // }


        for (i in arrayOfImageViews.indices){
            arrayOfImageViews[i].setOnClickListener {
                Storage.indexOfDetail=i
                val bundle=bundleOf("index" to i, "title" to arrayOfTextViews[i].text)
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
            }
        }


    }

}