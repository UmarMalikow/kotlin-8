package com.example.kotlin_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_8.databinding.ItemNameBinding

class MyAdapter(onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>(), View.OnClickListener {

    private var listCharacters: MutableList<MyModel>? = null
    private val onItemClickListener: OnItemClickListener

    fun setData(listCharacters: MutableList<MyModel>?) {
        this.listCharacters = listCharacters
        notifyDataSetChanged()
    }

    fun data2(model: MyModel) {
        listCharacters?.add(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(listCharacters!![position])
    }

    override fun getItemCount(): Int {
        return listCharacters!!.size
    }

    override fun onClick(view: View) {
        onItemClickListener.onClick(view.tag as MyModel)
    }

    class ViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(celebrities: MyModel) {
            Glide.with(binding.ivImageUrl.context).load(celebrities.urls).into(binding.ivImageUrl)
            binding.tvNamePerson.text = celebrities.namePerson
            binding.tvAgePerson.text = celebrities.age.toString()
            binding.tvFamily.text = celebrities.middleName
            itemView.tag = celebrities
        }
    }

    init {
        this.onItemClickListener = onItemClickListener
    }
}