package com.example.hw10_3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw10_3.databinding.FragmentHomeBinding
import com.example.hw10_3.databinding.FragmentSettingBinding

object Storage{
    var editFlag=false

}

class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate (inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)

        var arrayOfRadioButtons= arrayOf(binding.number1,binding.number2,binding.number3
            ,binding.number4,binding.number5,binding.number6)
        binding.buttonRegister.setOnClickListener {
            pref.edit().clear().apply()
            findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
        }

        binding.buttonEdit.setOnClickListener {
            Storage.editFlag=true
            findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
        }


            binding.buttonRegisterNumber.setOnClickListener {
                for (i in arrayOfRadioButtons.indices){
                    if (arrayOfRadioButtons[i].isChecked){
                        var editor= pref.edit()
                        editor.putInt("numberOfItem", i+1)
                        editor.apply()
                        findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
                    }

                }
            }




    }

}