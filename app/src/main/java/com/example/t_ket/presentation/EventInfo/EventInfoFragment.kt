package com.example.t_ket.presentation.EventInfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.t_ket.R
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.databinding.FragmentEventInfoBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EventInfoFragment : Fragment() {

    private var _binding: FragmentEventInfoBinding? = null
    private val binding get() = _binding!!

    private val EventInfoViewModel by viewModels<EventInfoViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        EventInfoViewModel.getInfo()
        _binding = FragmentEventInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun initObservers() {
        EventInfoViewModel.eventInfo.observe(viewLifecycleOwner) { state ->
            when(state) {
                is Event -> {
                    with(binding){
                        aforo.text="aforo: ${state.capacity}"
                        horaIn.text="Hora de inicio: ${state.start_time}"
                        horaFin.text="Hora de final: ${state.end_time}"
                        nombreevento.text="${state.name}"
                        EventInfoViewModel.entradasNoValidas.observe(viewLifecycleOwner) { entradasNoValidas ->
                            noValid.text = "Entradas no válidas: $entradasNoValidas"
                        }

                        EventInfoViewModel.entradasValidadas.observe(viewLifecycleOwner) { entradasValidadas ->
                            Validadas.text = "Entradas validadas: $entradasValidadas"
                        }
                        EventInfoViewModel.imageUrl.observe(viewLifecycleOwner) { url ->
                            Glide.with(requireContext())
                                .load(url)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imageEvent)
                        }
                        Log.d("TAG", "He pasado por aqui")
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
