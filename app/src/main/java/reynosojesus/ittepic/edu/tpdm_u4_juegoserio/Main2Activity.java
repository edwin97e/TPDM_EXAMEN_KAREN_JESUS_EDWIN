package reynosojesus.ittepic.edu.tpdm_u4_juegoserio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView inicio;
    EditText peso,altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inicio = findViewById(R.id.play);
        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                i.putExtra("altura",Float.parseFloat(altura.getText().toString()));
                i.putExtra("peso",Float.parseFloat(peso.getText().toString()));
                startActivity(i);
            }
        });
    }

}
