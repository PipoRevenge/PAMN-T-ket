package com.example.t_ket.presentation.TicketList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t_ket.R
import com.example.t_ket.databinding.FragmentEventInfoBinding
import com.example.t_ket.databinding.FragmentTicketListBinding


class TicketListFragment : Fragment() {
    private var _binding: FragmentTicketListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}