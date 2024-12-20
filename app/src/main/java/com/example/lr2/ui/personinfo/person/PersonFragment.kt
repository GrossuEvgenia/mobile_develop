package com.example.lr2.ui.personinfo.person

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lr2.activity.personinfo.AddressActivity
import com.example.lr2.activity.personinfo.FillPersonDataParamsActivity
import com.example.lr2.R
import com.example.lr2.activity.personinfo.OrderStoryActivity
import com.example.lr2.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {

    private var _binding: FragmentPersonBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val personViewModel =
            ViewModelProvider(this).get(PersonViewModel::class.java)

        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val personData : TextView = root.findViewById<TextView>(R.id.person_data)
        personData.setOnClickListener {
            // Переход на экран с заполнением даты
            val intent = Intent(activity, FillPersonDataParamsActivity::class.java)
            intent.putExtra("id",123)
            startActivity(intent)
        }
        val address : TextView = root.findViewById<TextView>(R.id.add_adress)
        address.setOnClickListener {
            // Переход на экран с заполнением адреса
            val intent = Intent(activity, AddressActivity::class.java)
            intent.putExtra("id", 124)
            startActivity(intent)
        }

        val orderStory : TextView = root.findViewById<TextView>(R.id.order_story)
        orderStory.setOnClickListener {
            // Переход на экран с заполнением адреса
            val intent = Intent(activity, OrderStoryActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}