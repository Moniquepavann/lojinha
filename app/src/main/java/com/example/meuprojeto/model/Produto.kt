package com.example.meuprojeto.model

class Produto(val id: Int, val nome: String, val preco: Double, var estoque: Int){
    fun exibirDetalhes() {
        println("$id\t$nome\tR$$preco \tEstoque: $estoque")
    }
}