package com.example.t_ket.domain.interactor.userInteractor

class UserInteractorImpl(private val userInteractor: UserInteractor) : UserInteractor {

    var evento = ""
    var userCode = ""
    override fun asociateUser(codigo: String): Boolean{
        if(codigo.length == 7) {
            evento = codigo.substring(0,3)
            userCode = codigo.substring(4,7)
            userEvent(evento)
            return true
        }else{
            return false
        }

    }
    override fun userEvent(evento: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun userCode(codigo: String): Boolean {
        TODO("Not yet implemented")
    }
}