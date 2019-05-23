package reynosojesus.ittepic.edu.tpdm_u4_juegoserio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float altura,peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle parametros = this.getIntent().getExtras();
        altura=parametros.getFloat("altura");
        peso=parametros.getFloat("peso");

        setContentView(new Lienzo(this,altura,peso));
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }
}


