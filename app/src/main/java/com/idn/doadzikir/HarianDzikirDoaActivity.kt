package com.idn.doadzikir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HarianDzikirDoaActivity : AppCompatActivity() {
    private val listDzikir: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa)

        initData()

        val rvDzikirDoaHarian = findViewById<RecyclerView>(R.id.rv_dzikir_doa_harian)
        rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
        rvDzikirDoaHarian.adapter = DzikirDoaAdapter(listDzikir)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjamah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in desc.indices) {
           val dzikir = DzikirDoa(
               desc[data],
               lafaz[data],
               terjamah[data]
           )
            listDzikir.add(dzikir)
        }

    }
}