package com.example.segundaaulaandroidcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcularPreco(view: View){
        // Atribui os valores dos edits texts para as variáveis
        val precoAlcool = edtPrecoAlcool.text.toString()
        val precoGasolina = edtPrecoGasolina.text.toString()

        // Variável recebe resuldado no formato Boolean da função validaCampos
        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        // Verifica se o valor é true e chama a função calcularMelhorPreco senão altera o texto do textView resultado
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            txtResultado.text = getString(R.string.preencha_precos_primeiro)
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
            txtResultado.text = getString(R.string.utilizar_gasolina)
        }else{
            txtResultado.text = getString(R.string.utilizar_alcool)
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        // Cria variável booleana iniciada em true
        var camposValidados = true
        // Verifica se os valores do Alcool e Gasolina são nulos ou vazios
        if(precoAlcool == ""){
            camposValidados = false
        } else if (precoGasolina == ""){
            camposValidados = false
        }
        // Retorna true ou false
        return camposValidados
    }
}