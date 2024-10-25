package com.example.lr2.ui.fillpersdata

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lr2.FillPersonDataParamsActivity
import com.example.lr2.R
import com.example.lr2.databinding.FragmentPersonBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar
import java.util.Locale

class FillPersDataFragment : Fragment() {

    private var _binding: FragmentPersonBinding? = null
    private lateinit var toolBar: Toolbar

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var dateEditText: TextInputEditText


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        ViewModelProvider(this).get(FillPersonDataViewModel::class.java)

        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}