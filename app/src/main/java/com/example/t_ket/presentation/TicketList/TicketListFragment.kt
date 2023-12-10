package com.example.t_ket.presentation.TicketList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t_ket.R
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.databinding.FragmentEventInfoBinding
import com.example.t_ket.databinding.FragmentTicketListBinding
import com.example.t_ket.presentation.TicketList.adapter.TicketListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TicketListFragment : Fragment() {
    private var _binding: FragmentTicketListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TicketListAdapter
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
        initList()
    }

    private fun initList() {
        adapter = TicketListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun initObservers() {
        TicketListViewModel.getList().observe(viewLifecycleOwner) { state ->
            when(state) {
                is List<Ticket> -> {
                    with(binding){
                        adapter.updateList(state)
                    }
                }
                null -> {
                    with(binding){
                        Log.d("TAG", "Error Info")
                    }
                }
            }
        }
    }



}