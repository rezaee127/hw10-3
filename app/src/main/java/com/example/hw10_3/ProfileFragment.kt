package com.example.hw10_3


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hw10_3.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    var name=""
    var nationalCode=""
    var phone=""
    lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        if (pref.getString("name", "").isNullOrBlank()) {
            gone1()
            binding.buttonRegister.setOnClickListener {
                if (binding.editTextName.text.isNullOrBlank())
                    binding.editTextName.error = "نام را وارد کنید"
                else if (binding.editTextNationalCode.text.isNullOrBlank())
                    binding.editTextNationalCode.error = "کد ملی را وارد کنید"
                else if (binding.editTextPhone.text.isNullOrBlank())
                    binding.editTextPhone.error = "تلفن را وارد کنید"
                else {
                    saveOnSharedPreferences()
                }
            }
        } else {
            viewInformation()
        }
    }

    private fun saveOnSharedPreferences() {
        name = binding.editTextName.text.toString()
        nationalCode = binding.editTextNationalCode.text.toString()
        phone = binding.editTextPhone.text.toString()

        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("name", name)
        editor.putString("nationalCode", nationalCode)
        editor.putString("phone", phone)
        editor.apply()
        Toast.makeText(activity, "ذخیره اطلاعات انجام شد", Toast.LENGTH_LONG).show()

        viewInformation()
    }

    @SuppressLint("SetTextI18n")
    private fun viewInformation() {
        val pref = requireActivity().getSharedPreferences("share", Context.MODE_PRIVATE)
        gone2()
        visible()

        Glide.with(this.requireContext())
            .load(R.drawable.m4)
            .fitCenter()
            .circleCrop()
            .into(binding.imageView)

        binding.textViewName.text = "نام : ${pref.getString("name", "")}"
        binding.textViewNationalCode.text = "کد ملی : ${pref.getString("nationalCode", "")}"
        binding.textViewPhone.text = "تلفن : ${pref.getString("phone", "")}"

    }

    private fun visible() {
        binding.imageView.visibility = View.VISIBLE
        binding.textViewName.visibility = View.VISIBLE
        binding.textViewNationalCode.visibility = View.VISIBLE
        binding.textViewPhone.visibility = View.VISIBLE
    }

    private fun gone2() {
        binding.editTextName.visibility = View.GONE
        binding.editTextNationalCode.visibility = View.GONE
        binding.editTextPhone.visibility = View.GONE
        binding.buttonRegister.visibility = View.GONE

    }

    private fun gone1() {
        binding.imageView.visibility = View.GONE
        binding.textViewName.visibility = View.GONE
        binding.textViewNationalCode.visibility = View.GONE
        binding.textViewPhone.visibility = View.GONE

    }


}
