package com.example.t_ket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.t_ket.core.data.ticketDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.ticketDi.repository.TicketRepository
import com.example.t_ket.databinding.ActivityMainBinding
import com.example.t_ket.presentation.EventInfo.EventInfoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var navController: NavController

    private lateinit var ticketRepository: TicketRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        //Prubas pipo
        ticketRepository = TicketRepositoryImpl() // Asume que TicketRepositoryImpl es la implementación de tu interfaz

        // Ahora puedes llamar a las funciones de la interfaz


        //pipoPruebas()
        lifecycleScope.launch (Dispatchers.IO){
            ticketRepository.setIdEvent("UOT")
            Log.d("MainActivity", "setIdEvent: UOT")

            val allTickets = ticketRepository.getAllTickets()
            Log.d("MainActivity", "getAllTickets: $allTickets")

            val ticketById = ticketRepository.getTicketById("UOT001")
            Log.d("MainActivity", "getTicketById: $ticketById")

            val ticketsFromGroup = ticketRepository.getTicketsFromGroup("G1")
            Log.d("MainActivity", "getTicketsFromGroup: $ticketsFromGroup")

            val ticketByDni = ticketRepository.getTicketByDni("54173430N")
            Log.d("MainActivity", "getTicketByDni: $ticketByDni")

            ticketRepository.updateStatusTicket("UOT001", false)
            Log.d("MainActivity", "updateStatusTicket: UOT001, false")
        }

    }


    private fun initUI() {
        initNavigation()
    }

    private fun initNavigation() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHost.navController

        binding.bottomNavView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.eventInfoFragment) {
                // Acciones específicas cuando el destino es EventInfoFragment
                with(binding) {
                    Log.d("TAG", "Koi no DIsco QUEEN")
                    bottomNavView.isVisible = true
                }
            }
        }
    }
}