package com.example.lr2.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lr2.R
import com.example.lr2.adapters.DishCategoryAdapter
import com.example.lr2.apicall.ApiCall
import com.example.lr2.apicall.MockRequests
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

        // ToDo: удалить после подключения API
        val mock = MockRequests()
        binding.DishCategoryRCV.adapter = DishCategoryAdapter(mock.getDishCategory(), con)
        // ToDo: расскоментировать после подключения API
//        ApiCall().getDishCategories(con) { listDishCategory ->
//            binding.DishCategoryRCV.adapter = DishCategoryAdapter(listDishCategory, con)
//        }
        binding.DishCategoryRCV.hasFixedSize()
        binding.DishCategoryRCV.layoutManager = LinearLayoutManager(con)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}