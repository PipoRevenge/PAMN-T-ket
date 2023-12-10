package com.example.t_ket.presentation.TicketList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t_ket.R
import com.example.t_ket.databinding.FragmentEventInfoBinding
import com.example.t_ket.databinding.FragmentTicketListBinding
import com.example.t_ket.presentation.TicketList.adapter.TicketListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketListFragment : Fragment() {
    private var _binding: FragmentTicketListBinding? = null
    private val binding get() = _binding!!
    private lateinit var ticketListAdapter: TicketListAdapter
    private val TicketListViewModel by viewModels<TicketListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initRecyclerView()
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

                    }
                }
                false -> {
                    with(binding){

                    }
                }
            }
        }
    }

    private fun initListeners() {
        with(binding) {
        }
    }

    fun initRecyclerView(){
        with(binding){

            binding.recyclerTickets.apply {
                layoutManager = GridLayoutManager(context, 1)
                adapter = ticketListAdapter
            }
        }
    }
}