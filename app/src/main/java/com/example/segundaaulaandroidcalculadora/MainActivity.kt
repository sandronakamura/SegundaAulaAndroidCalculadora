package com.example.segundaaulaandroidcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcularPitagoras(view: View){
        // Atribui os valores dos edits texts para as variáveis
        val nome = edtNome.text.toString()
        val primeiroCateto = edtPrimeiroCateto.text.toString()
        val segundoCateto = edtSegundoCateto.text.toString()

        // Variável recebe resuldado no formato Boolean da função validaCampos
        val validaCampos = validarCampos(nome, primeiroCateto, segundoCateto)

        // Verifica se o valor é true e chama a função calcularResultadoPitagoras senão altera o texto do textView resultado
        if (validaCampos){
            calcularResultadoPitagoras(nome, primeiroCateto, segundoCateto)
        }else{
            txtResultado.text=resources.getString(R.string.preencha_os_valores)
        }
    }

    fun calcularResultadoPitagoras(nome: String, primeiroCateto: String, segundoCateto: String){
        // Converte os valores recebidos para ponto flutuante
        val valorPrimeiroCateto = primeiroCateto.toDouble()
        val valorSegundoCateto = segundoCateto.toDouble()

        // Realiza soma dos quadrados dos catetos e depois a raiz do resultado
        val somaCatetos=  valorPrimeiroCateto.pow(2) + valorSegundoCateto.pow(2)
        val resultado = kotlin.math.sqrt(somaCatetos)

        val textViewResultado = findViewById<TextView>(R.id.txtResultado)

        // Concatenando o nome do usuário e o resultado para ser exibido no textView
        val resultadoString = "Ola $nome o resultado é: $resultado"
        textViewResultado.text= resultadoString


    }


    fun validarCampos(nome: String, primeiroCateto: String, segundoCateto: String): Boolean{
        // Cria variável booleana iniciada em true
        var camposValidados: Boolean = true
        // Verifica se os valores nome, primeiroCateto e segundoCateto são nulos ou vazios
        if(nome == ""){
            camposValidados = false
        } else if (primeiroCateto == ""){
            camposValidados = false
        } else if (segundoCateto == ""){
            camposValidados = false
        }
        // Retorna true ou false
        return camposValidados
    }
}