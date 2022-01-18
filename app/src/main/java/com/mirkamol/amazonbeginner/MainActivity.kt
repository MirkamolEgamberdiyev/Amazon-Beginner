package com.mirkamol.amazonbeginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.mirkamol.amazonbeginner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var phoneProduct: ArrayList<Product>
    private lateinit var tvProduct: ArrayList<Product>
    private lateinit var lapProduct: ArrayList<Product>
    private lateinit var allProducts:ArrayList<ArrayList<Product>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        allProducts  = ArrayList()

        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("Phone"))
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("TV"))
        binding.tabLayoutMain.addTab(binding.tabLayoutMain.newTab().setText("Laptop"))

        phoneProduct = addPhones()
        tvProduct  =addTvs()
        lapProduct = addLaptops()

        allProducts.add(phoneProduct)
        allProducts.add(tvProduct)
        allProducts.add(lapProduct)

        binding.rvMain.adapter  =setAdapter(phoneProduct)
        binding.rvMain.layoutManager  =GridLayoutManager(this, 2)
        binding.tabLayoutMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    binding.rvMain.adapter = setAdapter(allProducts[tab.position])
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null){
                    binding.rvMain.adapter = setAdapter(allProducts[tab.position])
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null){
                    binding.rvMain.adapter = setAdapter(allProducts[tab.position])
                }
            }

        })


    }

    private fun setAdapter(products:ArrayList<Product>):ProductAdapter{
        return ProductAdapter(products)
    }

    private fun addLaptops(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..50) {
                this.add(
                    Product(
                        "MacBook M1 pro",
                        "Laptop",
                        "https://cdn.mos.cms.futurecdn.net/GfinEMFXnT42BFxAcDc2rA.jpg"
                    )
                )
            }
        }
    }

    private fun addTvs(): ArrayList<Product> {
        return ArrayList<Product>().apply {
            for (i in 0..50) {
                this.add(
                    Product(
                        "Apple Tv",
                        "TV",
                        "https://cdn.pocket-lint.com/r/s/1200x/assets/images/156947-tv-review-apple-tv-4k-review-web-story-image6-kfj67p3b0x.jpg"
                    )
                )
            }
        }
    }


    private fun addPhones(): ArrayList<Product> {

        return ArrayList<Product>().apply {
            for (i in 0..50) {
                this.add(
                    Product(
                        "iPhone 8 pluss",
                        "Telephone",
                        "https://www.apple.com/newsroom/images/r8-landing-page-tiles/iPhone8-iPhone8PLUS-Special-Edition_LP_hero.jpg.og.jpg"
                    )
                )
            }
        }
    }
}