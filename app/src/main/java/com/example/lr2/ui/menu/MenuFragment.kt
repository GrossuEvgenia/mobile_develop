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

//        val listCategory = ArrayList<String>()
//        for(i in 1..9){
//            listCategory.add("item $i")
//        }
//        val listCategoryView = binding.listCategoryView
//        val con = activity as Context
//        val adapter = ArrayAdapter(con, R.layout.simple_list_item_1, listCategory)
//        listCategoryView.adapter = adapter


//        val listContact: ArrayList<ListviewContactItem> = GetlistContact()
//        val lv = activity!!.findViewById<View>(R.id.lv_contact) as ListView
//        lv.adapter = ListviewContactAdapter(activity, listContact)

//        binding.button.setOnClickListener {
//            binding.textHome.text = "Привет, мир!"
//        }

//        val textView: TextView = binding.textHome
//        menuViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}