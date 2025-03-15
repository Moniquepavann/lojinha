package com.example.meuprojeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meuprojeto.model.*
import com.example.meuprojeto.ui.theme.MeuProjetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MeuProjetoTheme {
                CarrinhoScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen() {
    val produto1 = Produto(1, "Notebook", 4500.0, 5)
    val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)
    val cliente = Cliente(1, "Ana", 5000.0)
    var carrinho = remember { CarrinhoDeCompras() }
    val loja = Loja(listOf(produto1, produto2))

    carrinho.adicionarProduto(produto1, 1)
    carrinho.adicionarProduto(produto2, 2)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Carrinho de Compras") })
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(text = "Cliente: ${cliente.nome}")
                Text(text = "Saldo: R$${cliente.saldo}")
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Produtos no carrinho:")
                CarrinhoView(carrinho)

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}

@Composable
fun CarrinhoView(carrinho: CarrinhoDeCompras) {
    if (carrinho.produtosLista.isEmpty()) {
        Text("Carrinho vazio")
    } else {
        carrinho.produtosLista.forEach { produto ->
            Text("${produto.nome} - R$${produto.preco}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCarrinhoScreen() {
    CarrinhoScreen()
}
