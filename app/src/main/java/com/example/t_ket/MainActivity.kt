package com.example.t_ket


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.t_ket.core.data.eventDi.implementation.EventImpl
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.data.eventDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.eventDi.repository.TicketRepository
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.AssociatedUserLoginUseCase
import com.example.t_ket.core.domain.usecase.TicketInteractorImpl
import com.example.t_ket.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var navController: NavController




    @Inject
    lateinit var eventRepository: EventRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        //Prubas pipo
        //eventRepository = EventImpl()
        //ticketRepository = eventRepository.getTicketRepository()






        //pipoPrubas()


    }

    private fun pipoPrubas(){
        lifecycleScope.launch (Dispatchers.IO){
            eventRepository.initEvent("UOT")
            Log.d("MainActivity", "setIdEvent: UOT")
            val ticketRepository =eventRepository.getTicketRepository()
            val allTickets = ticketRepository.getAllTickets()
            Log.d("MainActivity", "getAllTickets: $allTickets")

            val ticketById = ticketRepository.getTicketById("UOT001")
            Log.d("MainActivity", "getTicketById: $ticketById")

            val ticketsFromGroup = ticketRepository.getTicketsFromGroup("G1")
            Log.d("MainActivity", "getTicketsFromGroup: $ticketsFromGroup")

            val ticketByDni = ticketRepository.getTicketByDni("54173430N")
            Log.d("MainActivity", "getTicketByDni: $ticketByDni")

            ticketRepository.updateStatusTicket("UOT001", true)
            Log.d("MainActivity", "updateStatusTicket: UOT001, false")


            val eventInfo = eventRepository.getEventInfo()
            Log.d("MainActivity", "getTicketByDni: $eventInfo")


        }



    }
    /*
    data class CreaEvento(
        var capacity: Int? = null,
        var date: String? = "",
        var end_time: String? ="",
        var name: String? = "",
        var organizer: String? = "",
        var start_time: String? ="",
        var imageRef:  String?= ""
    )

    data class Ticket2(
        var status: Boolean? = null, // Validado o no validado
        var fullName: String? = "", // Propietario del ticket nombre completo
        var dni: String? = "", // Identificador del propietario
        var idGroup: String? = "", // Identificador del grupo (si existe)
    )
    //Borrar cuando esten subidos:
    fun subirEventos(){
        val db = FirebaseFirestore.getInstance()
        val idEvento = "TOM"

        val tomorrowlandEvent = CreaEvento(
            capacity = 1000,
            date = "2023-01-01", // Fecha del evento (usando un formato YYYY-MM-DD)
            end_time = "23:00",
            name = "Tomorrowland",
            organizer = "We Are One",
            start_time = "20:00",
            imageRef = "",

        )
        db.collection("Events").document(idEvento).set(tomorrowlandEvent)

    }


    fun añadirTicketsaEvento(idEvent:String, ticket:Ticket ){

        val db = FirebaseFirestore.getInstance()


    }

    */

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