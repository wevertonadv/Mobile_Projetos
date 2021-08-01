package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Busca os elementos da interface
        this.mViewHolder.editValue = this.findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = this.findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = this.findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = this.findViewById(R.id.button_calculate);

        this.clearValues();


        this.mViewHolder.buttonCalculate.setOnClickListener((View.OnClickListener) this);
        //Para tirar da tela o valor em dolar e em euro #4
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                //Mostra mensagem pro úsuario
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 5.21 )));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 6.18)));


            }
        }
    }

    //implementei o método clearValues #4
    private void clearValues() {
        this.mViewHolder.textDolar.setText(""); //Peguei o método e deixei vazio
        this.mViewHolder.textEuro.setText("");//Peguei o método e deixei vazio
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}