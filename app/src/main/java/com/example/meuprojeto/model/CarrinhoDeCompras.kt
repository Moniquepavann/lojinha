package com.example.meuprojeto.model

class CarrinhoDeCompras{
    val produtosLista = mutableListOf<Produto>()

    fun adicionarProduto(p: Produto, quantidade: Int){
        for (i in 1..quantidade){
            produtosLista.add(p)
        }
    }

    fun removerProduto(p: Produto){
        produtosLista.remove(p)
    }

    fun exibirCarrinho(){
        if (produtosLista.isEmpty()) {
            println("carrinho vazio")
        }
        else{
            println("exibindo carrinho: ")
            produtosLista.forEach { it.exibirDetalhes() }
        }
    }

    fun calcularTotal(): Double{
        var total = 0.0
        produtosLista.forEach { total += it.preco }
        //println("O total do carrinho é: $total")
        return total
    }
}