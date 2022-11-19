package com.example.kotlin_8
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.kotlin_8.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private var model: MyModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lookData
        setOnClick()
    }

    private fun setOnClick() {
        binding?.bntBackStack?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val lookData: Unit
        private get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable(BUNDLE_KEY) as MyModel?
                binding?.ivFullscreen?.let {
                    it.context?.let { it1 ->
                        Glide.with(it1).load(model?.urls).into(binding?.ivFullscreen!!)
                    }
                }
                binding?.tvNamePerson?.text = model?.namePerson
                binding?.tvAgePerson?.text = model?.age.toString()
                binding?.tvFamilyPerson?.text = model?.middleName
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}