package com.example.android_prak5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_prak5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PahlawanListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initData()
    }
    fun initData(){
        val data = ArrayList<Model>()
        data.add(Model("Jenderal Soedirman", R.drawable.sudirman, "Jenderal Sudirman adalah Panglima Besar Tentara Keamanan Rakyat (TKR)"))
        data.add(Model("Hasyim Asyari", R.drawable.hasyimasyari, "Jenderal Sudirman adalah Panglima Besar Tentara Keamanan Rakyat (TKR)"))
        data.add(Model("Pangeran Diponegoro", R.drawable.pangerandiponegoro, "Jenderal Sudirman adalah Panglima Besar Tentara Keamanan Rakyat (TKR)"))
        data.add(Model("Ki Hadjar Dewantara", R.drawable.kihajardewantara, "Jenderal Sudirman adalah Panglima Besar Tentara Keamanan Rakyat (TKR)"))
        data.add(Model("Bung Tomo", R.drawable.bung_tomo, "Jenderal Sudirman adalah Panglima Besar Tentara Keamanan Rakyat (TKR)"))

        val adapter = Adapter()
        binding.Recycler1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.Recycler1.adapter = adapter
        adapter.setData(data, this)

    }

    override fun pindah(model: Model) {
        supportFragmentManager.beginTransaction().replace(binding.containerDetail.id, DetailPahlawanFragment.newInstance(model.namaPahlawan, model.gambarPahlawan, model.ketPahlawan))
            .addToBackStack(null)
            .commit()
    }
}