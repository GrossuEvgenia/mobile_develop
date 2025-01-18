package com.example.lr2.ui.menu

import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lr2.adapters.DishCategoryAdapter
import com.example.lr2.apiclient.apis.DishApi
import com.example.lr2.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val con = activity as Context
        val menuViewModel =
            ViewModelProvider(this).get(MenuViewModel::class.java)

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())
        val api = DishApi()
        binding.DishCategoryRCV.adapter = DishCategoryAdapter(api.getDishCategories(), con)
        binding.DishCategoryRCV.hasFixedSize()
        binding.DishCategoryRCV.layoutManager = LinearLayoutManager(con)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}