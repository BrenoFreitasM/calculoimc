package br.unis.edu.calculoimc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var edtPeso: EditText? = null
    var edtAltura: EditText? = null
    var btnVerificar: Button? = null
    var txtResultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carregaComponentes()
        configurarBotaoVerificar()
    }

    protected fun carregaComponentes() {
        edtAltura = findViewById(R.id.edtAltura)
        edtPeso = findViewById(R.id.edtPeso)
        btnVerificar = findViewById(R.id.btnVerificar)
        txtResultado = findViewById(R.id.txtResultado)
    }

    protected fun configurarBotaoVerificar() {
        btnVerificar!!.setOnClickListener {
            val resultado = realizaCalculo()
            exibiResultado(resultado)
            limpaCampos()
        }
    }

    protected fun realizaCalculo(): String {
        val peso = edtPeso!!.text.toString().toDouble()
        val altura = edtAltura!!.text.toString().toDouble()
        val res = peso / (altura * altura)
        var resultado = "Obesidade Grau IIII (mórbida)"
        if (res < 16) {
            resultado = "Magreza grave"
        } else if (res == 16.0) {
            resultado = "Magreza moderada"
        } else if (res > 15 && res < 18.5) {
            resultado = "Magreza leve"
        } else if (res > 18.4 && res < 25) {
            resultado = "Saudável"
        } else if (res > 25 && res < 30) {
            resultado = "Sobrepeso"
        } else if (res > 30 && res < 35) {
            resultado = "Obesidade Grau 1"
        } else if (res > 35 && res < 40) {
            resultado = "Obesidade Grau II"
        }
        return resultado
    }

    protected fun exibiResultado(resultado: String?) {
        txtResultado!!.text = resultado
    }

    protected fun limpaCampos() {
        edtAltura!!.setText("")
        edtPeso!!.setText("")
        edtPeso!!.requestFocus()
        edtAltura!!.requestFocus()
    }
}