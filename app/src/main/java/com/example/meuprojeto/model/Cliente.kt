package com.example.meuprojeto.model

class Cliente(val id: Int, val nome: String, var saldo: Double){
    fun adicionarSaldo(valor: Double){
        saldo += valor
    }
    fun exibirDetalhes() {
        println("$id\t$nome\tR$$saldo")
    }
}