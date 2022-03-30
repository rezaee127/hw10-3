package com.example.hw10_3

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw10_3.databinding.FragmentBankInfoBinding


class BankInfoFragment : Fragment() {
    lateinit var binding:FragmentBankInfoBinding
    var userName=""
    var password=""
    var accountNumber=""
    var cardNumber=""
    var shabaNumber=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBankInfoBinding.inflate (inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_bank_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)


        when {
            pref.getString("userName", "").isNullOrBlank() -> {
                gone1()
                register()
            }
            Storage.editBankInfoFlag -> {
                enter()
                register()
            }
            else -> {
                enter()
            }
        }
    }



    private fun register(){

            binding.buttonRegister.setOnClickListener {
                when {
                    binding.editTextUserName.text.isNullOrBlank() -> binding.editTextUserName.error = "نام کاربری را وارد کنید"
                    binding.editTextPassword.text.isNullOrBlank() -> binding.editTextPassword.error = "پسورد را وارد کنید"
                    binding.editTextBankAccountNumber.text.isNullOrBlank() -> binding.editTextBankAccountNumber.error = "شماره حساب را وارد کنید"
                    binding.editTextBankCardNumber.text.isNullOrBlank() -> binding.editTextBankCardNumber.error = "شماره کارت را وارد کنید"
                    binding.editTextShabaNumber.text.isNullOrBlank() -> binding.editTextShabaNumber.error = "شماره شبا را وارد کنید"
                    binding.editTextBankCardNumber.length()!=16 -> binding.editTextBankCardNumber.error="شماره کارت اشتباه است"
                    binding.editTextPassword.text.toString()!=binding.editTextRetypePassword.text.toString() -> binding.editTextRetypePassword.error="پسوردهای وارد شده یکسان نیستند"
                    else -> {
                        saveOnSharedPreferences()
                    }
                }
            }
        }




    private fun saveOnSharedPreferences() {
        userName = binding.editTextUserName.text.toString()
        password=binding.editTextPassword.text.toString()
        accountNumber=binding.editTextBankAccountNumber.text.toString()
        cardNumber=binding.editTextBankCardNumber.text.toString()
        shabaNumber=binding.editTextShabaNumber.text.toString()

        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("userName", userName)
        editor.putString("password", password)
        editor.putString("accountNumber", accountNumber)
        editor.putString("cardNumber", cardNumber)
        editor.putString("shabaNumber", shabaNumber)
        editor.apply()
        Toast.makeText(activity, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()
        Storage.editBankInfoFlag=false
        enter()
    }

    private fun enter() {
        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        gone2()
        visible1()
        binding.editTextUserName2.setText("")
        binding.editTextPassword2.setText("")
        binding.buttonEnter.setOnClickListener {
            if (binding.editTextUserName2.text.toString()!=pref.getString("userName","")|| binding.editTextPassword2.text.toString()!=pref.getString("password", ""))
                Toast.makeText(activity,"یوزر نیم یا پسورد اشتباه است", Toast.LENGTH_SHORT).show()
            else {
                Storage.hideInfoFlag=pref.getBoolean("hideBankInfo", false)
                if (Storage.hideInfoFlag) {
                    Toast.makeText(requireContext(), "متاسفانه نمیتوان اطلاعات را نمایش داد", Toast.LENGTH_LONG).show()
                } else if (Storage.editBankInfoFlag) {
                    edit()
                } else
                    showInfo()
            }
        }
    }

    private fun edit() {
        gone1()
        visible3()
        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        binding.editTextUserName.setText(pref.getString("userName",""))
        binding.editTextPassword.setText(pref.getString("password",""))
        binding.editTextRetypePassword.setText(pref.getString("password",""))
        binding.editTextBankAccountNumber.setText(pref.getString("accountNumber",""))
        binding.editTextBankCardNumber.setText(pref.getString("cardNumber",""))
        binding.editTextShabaNumber.setText(pref.getString("shabaNumber",""))
        Storage.editBankInfoFlag=false
    }

    @SuppressLint("SetTextI18n")
    private fun showInfo() {
        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        visible2()

        binding.textViewAccountNumber.text="شماره حساب : ${pref.getString("accountNumber", "")}"
        binding.textViewCardNumber.text="شماره کارت : ${pref.getString("cardNumber", "")}"
        binding.textViewShabaNumber.text="شماره شبا : ${pref.getString("shabaNumber", "")}"

    }


    private fun gone1() {
        binding.editTextPassword2.visibility=View.GONE
        binding.editTextUserName2.visibility=View.GONE
        binding.buttonEnter.visibility=View.GONE
        binding.textViewAccountNumber.visibility=View.GONE
        binding.textViewCardNumber.visibility=View.GONE
        binding.textViewShabaNumber.visibility=View.GONE
    }

    private fun visible1() {
        binding.editTextUserName2.visibility=View.VISIBLE
        binding.editTextPassword2.visibility=View.VISIBLE
        binding.buttonEnter.visibility=View.VISIBLE
    }


    private fun gone2() {
        binding.editTextUserName.visibility=View.GONE
        binding.editTextPassword.visibility=View.GONE
        binding.editTextRetypePassword.visibility=View.GONE
        binding.editTextBankAccountNumber.visibility=View.GONE
        binding.editTextBankCardNumber.visibility=View.GONE
        binding.editTextShabaNumber.visibility=View.GONE
        binding.buttonRegister.visibility=View.GONE

    }

    private fun visible2() {
        binding.editTextUserName2.visibility=View.GONE
        binding.editTextPassword2.visibility=View.GONE
        binding.buttonEnter.visibility=View.GONE

        binding.textViewAccountNumber.visibility=View.VISIBLE
        binding.textViewCardNumber.visibility=View.VISIBLE
        binding.textViewShabaNumber.visibility=View.VISIBLE
    }


    private fun visible3() {
        binding.editTextUserName.visibility=View.VISIBLE
        binding.editTextPassword.visibility=View.VISIBLE
        binding.editTextRetypePassword.visibility=View.VISIBLE
        binding.editTextBankAccountNumber.visibility=View.VISIBLE
        binding.editTextBankCardNumber.visibility=View.VISIBLE
        binding.editTextShabaNumber.visibility=View.VISIBLE
        binding.buttonRegister.visibility=View.VISIBLE

    }


}