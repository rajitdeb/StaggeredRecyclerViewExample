package com.rajit.staggeredrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rajit.staggeredrecyclerviewexample.adapter.MyCustomAdapter
import com.rajit.staggeredrecyclerviewexample.databinding.ActivityMainBinding
import com.rajit.staggeredrecyclerviewexample.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val mAdapter: MyCustomAdapter by lazy { MyCustomAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            adapter = mAdapter
        }

        mAdapter.submitList(Constants.productData)

    }
}