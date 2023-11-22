package com.example.t_ket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.t_ket.data.tickets.repository.TicketRepository
import com.example.t_ket.ui.theme.TketTheme
import com.example.t_ket.data.tickets.repository.TicketRepositoryImpl

class MainActivity : ComponentActivity() {
    //private val firestore = FirebaseFirestore.getInstance()
    //private val ticketRemote = TicketRemoteImpl(firestore)
    private val ticketRepository: TicketRepository = TicketRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        ticketRepository.startListeningToTickets("UOT")
        super.onCreate(savedInstanceState)
        setContent {
            TketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Button(onClick = { updateTicketStatus() }) {
                        Text("Update Ticket Status")
                    }
                }
            }
        }
    }

    private fun updateTicketStatus() {
        /*
        val eventId = "UOT"
        val ticketId = "UOT001"
        val newStatus = true
        ticketRepository.updateTicketStatus(eventId, ticketId, newStatus)
        print(ticketRepository.getTicketById(eventId))
        */
        ticketRepository.printTickets()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}