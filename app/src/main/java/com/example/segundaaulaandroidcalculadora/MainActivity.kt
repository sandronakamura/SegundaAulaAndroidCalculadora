package com.example.segundaaulaandroidcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcularPreco(view: View){
        // Atribui os valores dos edits texts para as variáveis
        val precoAlcool = edtPrecoAlcool.text.toString()
        var precoGasolina = edtPrecoGasolina.text.toString()

        // Variável recebe resuldado no formato Boolean da função validaCampos
        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        // Verifica se o valor é true e chama a função calcularMelhorPreco senão altera o texto do textView resultado
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            txtResultado.text = "Preencha os preços primeiro!"
        }
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        // Converte os valores recebidos para ponto flutuante
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        // Realiza a divisão e salva em uma variável
        val resultadoPreco = valorAlcool / valorGasolina

        // Se o resultado for menor ou igual a 0.7 altera o texto do textView resultado para melhor usar gasolina senão altera para
        // melhor utilizar alcool
        if(resultadoPreco >= 0.7){
            txtResultado.text = "Melhor utilizar Gasolina"
        }else{
            txtResultado.text = "Melhor utilizar Alcool"
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        // Cria variável booleana iniciada em true
        var camposValidados: Boolean = true
        // Verifica se os valores do Alcool e Gasolina são nulos ou vazios
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        // Retorna true ou false
        return camposValidados
    }
}