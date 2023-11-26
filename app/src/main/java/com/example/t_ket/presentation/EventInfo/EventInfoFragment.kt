package com.example.t_ket.presentation.EventInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.t_ket.R
import com.example.t_ket.databinding.FragmentEventInfoBinding


class EventInfoFragment : Fragment() {

    private var _binding: FragmentEventInfoBinding? = null
    private val binding get() = _binding!!

    private val EventInfoViewModel by viewModels<EventInfoViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEventInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        EventInfoViewModel.signUpState.observe(viewLifecycleOwner) { state ->
            when(state) {
                 true -> {
                     with(binding){
                         TextToVerify.isVisible=true
                     }
                }
                 false -> {
                     with(binding){
                         TextToVerify.isVisible=true
                     }
                }
            }
        }
    }

    private fun initListeners() {
        with(binding) {
            buttonlogin.setOnClickListener {
                handleLogIn()
            }
        }
    }

    private fun handleLogIn() {
        val code = binding.etlogin.text.toString()
        EventInfoViewModel.signUp(code)
    }
}