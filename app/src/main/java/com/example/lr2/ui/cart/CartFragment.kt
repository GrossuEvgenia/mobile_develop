package com.example.lr2.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lr2.R
import com.example.lr2.adapters.CartAdapter
import com.example.lr2.databinding.FragmentCartBinding
import com.example.lr2.logic.CartManager

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CartViewModel
    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CartViewModel::class.java]
        adapter = CartAdapter(emptyList(), viewModel)

        binding.cartRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cartRecyclerView.adapter = adapter

        binding.checkoutButton.setOnClickListener {
            val total = viewModel.items.value?.sumOf { it.dish.price * it.quantity } ?: 0
            Toast.makeText(context, "Оформление заказа на $total ₽", Toast.LENGTH_SHORT).show()
            val bundle = Bundle().apply {
                putInt("totalSum", total)
            }
            findNavController(requireView()).navigate(R.id.navigation_order, bundle)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.updateItems(items)

            val total = items.sumOf { it.dish.price * it.quantity }
            binding.cartTotalText.text = "Итого: $total ₽"

            binding.checkoutButton.apply {
                isEnabled = items.isNotEmpty()
                visibility = if (items.isNotEmpty()) View.VISIBLE else View.GONE
                text = "Оформить за $total ₽"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
