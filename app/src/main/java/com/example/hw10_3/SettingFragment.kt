package com.example.hw10_3

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw10_3.databinding.FragmentHomeBinding
import com.example.hw10_3.databinding.FragmentSettingBinding
import kotlin.system.exitProcess


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

        changeTheme()

        changeNumberOfItemInHome()

        binding.buttonRegister.setOnClickListener {
            pref.edit().clear().apply()
            findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
        }

        binding.buttonEdit.setOnClickListener {
            Storage.editFlag=true
            findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
        }




    }


    private fun changeNumberOfItemInHome() {
        val arrayOfRadioButtons= arrayOf(binding.number1,binding.number2,binding.number3
            ,binding.number4,binding.number5,binding.number6)

        val pref2 = requireActivity().getSharedPreferences("share2", Context.MODE_PRIVATE)
        val number=pref2.getInt("numberOfItem",-1)
        for(i in arrayOfRadioButtons.indices){
            if (i==number-1){
                arrayOfRadioButtons[i].isChecked=true
            }
        }

        for (i in arrayOfRadioButtons.indices){
            arrayOfRadioButtons[i].setOnCheckedChangeListener { compoundButton, b ->
                if(b){
                    //Storage.item=i+1
                    val editor= pref2.edit()
                    editor.putInt("numberOfItem", i+1)
                    editor.apply()
                    findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
                    }
                }
            }
    }


    private fun changeTheme() {
        val pref2 = requireActivity().getSharedPreferences("share2", Context.MODE_PRIVATE)
        val s= pref2.getString("theme", "")
        if (s=="1"){
            binding.theme1.isChecked=true
        }else if (s=="2"){
            binding.theme2.isChecked=true
        }

        binding.theme1.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                pref2.edit().putString("theme", "1").apply()
                val intent= Intent(activity,MainActivity::class.java)
                requireActivity().finishAffinity()
                startActivity(intent)
            }
        }

        binding.theme2.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                pref2.edit().putString("theme", "2").apply()
                val intent= Intent(activity,MainActivity::class.java)
                requireActivity().finishAffinity()
                startActivity(intent)
            }
        }
    }


}