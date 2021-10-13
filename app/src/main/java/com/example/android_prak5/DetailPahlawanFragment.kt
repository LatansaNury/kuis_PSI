package com.example.android_prak5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_prak5.databinding.FragmentDetailPahlawanBinding
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val nama = "nama"
private const val gambar = "gambar"
private const val keterangan = "keterangan"


class DetailPahlawanFragment : Fragment() {
    private var _binding : FragmentDetailPahlawanBinding?=null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var namaPahlawan: String? = null
    private var gambarPahlawan: Int? = null
    private var keteranganPahlawan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailPahlawanBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            namaPahlawan = it.getString(nama)
            gambarPahlawan = it.getInt(gambar)
            keteranganPahlawan = it.getString(keterangan)
            binding.txtDetailNama.text = namaPahlawan
            binding.txtDetailKeterangan.text = keteranganPahlawan
            val target=binding.imgDetail
            Picasso.get().load(gambarPahlawan!!).into(target)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailPahlawanFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(kirim1: String, kirim2: Int, kirim3: String ) =
            DetailPahlawanFragment().apply {
                arguments = Bundle().apply {
                    putString(nama, kirim1)
                    putInt(gambar, kirim2)
                    putString(keterangan, kirim3)

                }
            }
    }
}