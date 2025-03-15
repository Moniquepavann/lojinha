package com.example.meuprojeto.model

class Loja(val produtos: List<Produto>){
    fun finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras){
        val total = carrinho.calcularTotal()
        if (cliente.saldo >= total){
            println("Compra realizada")

            // Atualizar saldo e estoque
            cliente.saldo -= total
            carrinho.produtosLista.forEach{ it.estoque -=1 }
            carrinho.produtosLista.clear()
        }
        else{
            println("Saldo insuficiente")
        }
    }
}