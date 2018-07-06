package br.pucminas.rachacontakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var ProgressStatus: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBarId.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                ProgressStatus = i
                txtSeekBarId.text = "${ProgressStatus.toString()}%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar)  { }
        })
    }

    // PROCEDIMENTO PARA VALIDAR OS CAMPOS STRINGS
    fun validaCampo(x:String?) : Boolean = !(x==null || x.equals(""))

    // PROCEDIMENTO PARA EXECUTAR A ACAO DO BOTAO
    fun CalcularConta(view : View){

        if(validaCampo(edtValorId.text.toString()) &&
                validaCampo(edtNumPessoasId.text.toString())) {

            val valor = edtValorId.text.toString().toDouble()
            val pessoas = edtNumPessoasId.text.toString().toInt()

            val ValorGarcom = valor / 100.0 * ProgressStatus
            val ValorTotal = valor + ValorGarcom
            val ValorIndividual = ValorTotal / pessoas

            vlrGarcomId.text = "RS${String.format("%02.2f",ValorGarcom)}"
            vlrTotalId.text = "RS${String.format("%02.2f",ValorTotal)}"
            vlrIndividualId.text = "RS${String.format("%02.2f",ValorIndividual)}"

        }else{
            Toast.makeText(this, "Preencha os valores", Toast.LENGTH_LONG).show()
        }
    }
}
