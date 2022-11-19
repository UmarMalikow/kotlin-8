package com.example.kotlin_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_8.databinding.FragmentRecyclerBinding

const val BUNDLE_KEY : String = "getkey"

class RecyclerFragment : Fragment(), OnItemClickListener {

    private var binding: FragmentRecyclerBinding? = null
    private val adapter = MyAdapter(this)
    private var arrayListCharacters: ArrayList<MyModel>? = null
    private val recyclerRepository = MyRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayListCharacters = recyclerRepository.getListOfPersons()
        adapter.setData(arrayListCharacters)
        initialize()
        setOnClickListener()
        addDats()
    }

    private fun initialize() {
        binding?.rvListOfName?.adapter = adapter
    }

    private fun setOnClickListener() {
        binding?.btnAdd?.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_thirdFragment)
        }
    }

    override fun onClick(model: MyModel?) {
        val bundle = Bundle()
        bundle.putSerializable(BUNDLE_KEY, model)
        findNavController().navigate(R.id.action_recyclerFragment_to_detailFragment, bundle)
            .toString()
    }

    private fun addDats() {
        arguments.let {
            adapter.data2(it?.getSerializable("OK") as MyModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}