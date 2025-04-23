package com.example.lr2.ui.order

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lr2.databinding.FragmentOrderBinding
import com.example.lr2.logic.CartManager
import com.example.lr2.R

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack(R.id.navigation_cart, false)
        }

        val totalSum = arguments?.getInt("totalSum") ?: 0
        binding.orderSummary.text =
            "Сумма заказа: ${totalSum} ₽\nСтоимость доставки: 0 ₽\nДоставим в течение: 30–45 мин\n\nИТОГО: ${totalSum} ₽"

        binding.confirmOrderButton.setOnClickListener {
            Toast.makeText(requireContext(), "Заказ оформлен!", Toast.LENGTH_SHORT).show()
            CartManager.clear()
            findNavController().navigate(R.id.navigation_menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().popBackStack(R.id.navigation_cart, false)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}