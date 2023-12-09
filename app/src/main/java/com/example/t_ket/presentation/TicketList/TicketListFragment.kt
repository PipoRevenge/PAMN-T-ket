package com.example.t_ket.presentation.TicketList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.t_ket.R
import com.example.t_ket.databinding.FragmentEventInfoBinding
import com.example.t_ket.databinding.FragmentTicketListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TicketListFragment : Fragment() {
    private var _binding: FragmentTicketListBinding? = null
    private val binding get() = _binding!!

    private val TicketListViewModel by viewModels<TicketListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        TicketListViewModel.ticketState.observe(viewLifecycleOwner) { state ->
            when(state) {
                true -> {
                    with(binding){
                        textVal.isVisible=true
                        Log.d("TAG", "He pasado por aqui")
                    }
                }
                false -> {
                    with(binding){
                        textError.isVisible=true
                    }
                }
            }
        }
    }

    private fun initListeners() {
        with(binding) {
            buttonVal.setOnClickListener {
                handleLogIn()
            }
        }
    }

    private fun handleLogIn() {
        val code = binding.editTextTicket.text.toString()
        TicketListViewModel.signUp(code)
    }
}