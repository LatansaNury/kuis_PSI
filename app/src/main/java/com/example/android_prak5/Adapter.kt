package com.example.android_prak5

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android_prak5.databinding.PahlawanBinding
import com.squareup.picasso.Picasso

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>(){
    var dataAdapter = arrayListOf<Model>()
    private var listener: PahlawanListener? = null
    fun setData(data: ArrayList<Model>, listener: PahlawanListener) {
        dataAdapter = data
        this.listener = listener
    }
    class ViewHolder(val binding: PahlawanBinding, listener: PahlawanListener) : RecyclerView.ViewHolder(binding.root)  {
        private var listener: PahlawanListener? = null
        init {
            this.listener = listener
        }
        fun initData(model: Model) {
            binding.txt1.text =model.namaPahlawan
            binding.txtKet.text = model.ketPahlawan
            val target=binding.img1
            Picasso.get().load(model.gambarPahlawan).into(target)
            binding.img1.setOnClickListener{
                Toast.makeText(it.context, "${model.namaPahlawan}", Toast.LENGTH_SHORT).show()
            }
            binding.img1.setOnLongClickListener{
                listener?.pindah(model)
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PahlawanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        ), listener!!
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataAdapter[position]
        holder.initData(data)
    }

    override fun getItemCount(): Int {
        return dataAdapter.size
    }
}