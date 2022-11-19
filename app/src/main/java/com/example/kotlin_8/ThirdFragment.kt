package com.example.kotlin_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_8.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var binding: FragmentThirdBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickAdd()
    }

    private fun clickAdd() {
        binding?.btnAddThirdFragment?.setOnClickListener {
            val urlsImage = binding?.etImagePerson?.text.toString().trim { it <= ' ' }
            val namePersons = binding?.etNamePerson?.text.toString()
            val middleNames = binding?.etMiddleNamePerson?.text.toString()
            val age = binding?.etAgePerson?.text.toString()
            val bundle = Bundle()

             if (urlsImage.isEmpty()) {
                binding?.etImagePerson?.error = "Заполните поле"
            } else if (namePersons.isEmpty()) {
                binding?.etNamePerson?.error = "Заполните поле"
            } else if (middleNames.isEmpty()) {
                binding?.etMiddleNamePerson?.error = "Заполните поле"
            } else if (age.isEmpty()) {
                binding?.etAgePerson?.error = "Заполните поле"
            } else {
                val model = MyModel(urlsImage, namePersons, age.toInt(), middleNames)
                bundle.putSerializable("OK", model)
                findNavController().navigate(R.id.action_thirdFragment_to_recyclerFragment,bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}