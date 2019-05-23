package reynosojesus.ittepic.edu.tpdm_u4_juegoserio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Nino {
    Bitmap imagen;
    int x,y;
    float imc;

    public Nino(Lienzo este,int img, int posx, int posy,float imc){
        this.imagen = BitmapFactory.decodeResource(este.getResources(),img);
        this.imagen = Bitmap.createScaledBitmap(this.imagen, 400,800,false);
        x = posx;
        y = posy;
        this.imc = imc;
    }

    public void dibujar(Canvas c, Paint p) {
        c.drawBitmap(imagen, x, y, p);
    }

    public boolean estaEnArea(int Xdedo, int Ydedo){
        int x2 = x+imagen.getWidth();
        int y2= y+imagen.getHeight();

        if(Xdedo >= x && Xdedo <= x2){
            if(Ydedo >= y && Ydedo <= y2){
                return true;
            }
        }
        return false;
    }

    public boolean estaEnColision(Nino objetoB){
        int x2 = x+imagen.getWidth();
        int y2= y+imagen.getHeight();
        if(objetoB.estaEnArea(x,y)){
            return true;
        }if(objetoB.estaEnArea(x2,y)){
            return true;
        }if(objetoB.estaEnArea(x,y2)){
            return true;
        }if(objetoB.estaEnArea(x2,y2)){
            return true;
        }
        return false;
    }

    public void comer(float caloria){
        this.imc += caloria;
    }

}
