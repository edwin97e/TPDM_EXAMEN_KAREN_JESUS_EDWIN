package reynosojesus.ittepic.edu.tpdm_u4_juegoserio;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Lienzo extends View {
    Comida manzana,pera,kiwi,naranja,platano,puntero,papas,pizza,hamburgesa,hotdog,dona;
    Nino nino;
    Float altura,peso;
    Float imc;
    int gx=0,gy=0;


    public Lienzo(Context context, Float altura, Float peso) {
        super(context);
        this.altura=altura;
        this.peso=peso;

        manzana = new Comida(this,R.drawable.manzana,100,50, (float) -0.5);
        pera = new Comida(this,R.drawable.pera,280,50,(float) -0.5);
        naranja = new Comida(this,R.drawable.naranja,470,50,(float) -0.5);
        platano = new Comida(this,R.drawable.platano,650,50,(float) -0.5);
        kiwi = new Comida(this,R.drawable.kiwi,800,50,(float) -0.5);
        puntero=null;
        //comida chatarra
        papas = new Comida(this,R.drawable.papasfritas,100,250,(float) 0.5);
        pizza = new Comida(this,R.drawable.pizza,280,250,(float) 0.5);
        hamburgesa = new Comida(this,R.drawable.hamburguesa,470,250,(float) 0.5);
        hotdog = new Comida(this,R.drawable.hotdog,650,250,(float) 0.5);
        dona = new Comida(this,R.drawable.dona,800,250,(float) 0.5);


        altura = altura/100;
        imc = (peso/(altura*altura));
        nino = new Nino(this,R.drawable.boy_slim_3,360,880,imc);
        evaluarnino(imc);

    }

    public void evaluarnino(float imc){
        Bitmap b;
        if(imc<=15){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.lapida);
            b = Bitmap.createScaledBitmap(b, 500,800,false);
            nino.imagen = b;
        }else if (imc <= 18 && imc>15){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_slim_3);
            b = Bitmap.createScaledBitmap(b, 500,800,false);
            nino.imagen = b;
        }else if(imc <= 19 &&  imc > 18){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_slim_2);
            b = Bitmap.createScaledBitmap(b, 500,800,false);
            nino.imagen = b;
        }else if(imc <= 20 &&  imc > 19){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_slim_1);
            b = Bitmap.createScaledBitmap(b, 400,800,false);
            nino.imagen = b;
        }else if(imc <= 21 &&  imc > 20){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_regular);
            b = Bitmap.createScaledBitmap(b, 400,800,false);
            nino.imagen = b;
        }else if(imc <= 23 &&  imc > 21){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_fat_1);
            b = Bitmap.createScaledBitmap(b, 400,800,false);
            nino.imagen = b;
        }else if(imc <= 25 &&  imc > 23){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_fat_2);
            b = Bitmap.createScaledBitmap(b, 400,800,false);
            nino.imagen = b;
        }else if(imc > 25 && imc<28){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.boy_fat_3);
            b = Bitmap.createScaledBitmap(b, 400,800,false);
            nino.imagen = b;
        }else if(imc>=28){
            b = BitmapFactory.decodeResource(this.getResources(),R.drawable.lapida);
            b = Bitmap.createScaledBitmap(b, 500,800,false);
            nino.imagen = b;
        }
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        c.drawText("Comida Saludable",0,0,p);
        manzana.dibujar(c,p);
        pera.dibujar(c,p);
        platano.dibujar(c,p);
        naranja.dibujar(c,p);
        kiwi.dibujar(c,p);
        //chatarra
        papas.dibujar(c,p);
        pizza.dibujar(c,p);
        hamburgesa.dibujar(c,p);
        hotdog.dibujar(c,p);
        dona.dibujar(c,p);
        nino.dibujar(c,p);
    }


    public Comida agarrando(int x,int y){
        if(manzana.estaEnArea(x,y)){
            gx=manzana.x;
            gy=manzana.y;
            return manzana;
        }else if(platano.estaEnArea(x,y)){
            gx=platano.x;
            gy=platano.y;
            return platano;
        }else if(pera.estaEnArea(x,y)){
            gx=pera.x;
            gy=pera.y;
            return pera;
        }else if(naranja.estaEnArea(x,y)){
            gx=naranja.x;
            gy=naranja.y;
            return naranja;
        }else if(kiwi.estaEnArea(x,y)){
            gx=kiwi.x;
            gy=kiwi.y;
            return kiwi;
        }else if(papas.estaEnArea(x,y)){  //comida chatarra
            gx=papas.x;
            gy=papas.y;
        return papas;
        }else if(pizza.estaEnArea(x,y)){
            gx=pizza.x;
            gy=pizza.y;
        return pizza;
        }else if(hamburgesa.estaEnArea(x,y)){
            gx=hamburgesa.x;
            gy=hamburgesa.y;
            return hamburgesa;
        }else if(hotdog.estaEnArea(x,y)){
            gx=hotdog.x;
            gy=hotdog.y;
            return hotdog;
        }else if(dona.estaEnArea(x,y)){
            gx=dona.x;
            gy=dona.y;
            return dona;
        }
        return null;
    }

    public boolean onTouchEvent (MotionEvent me){
        int accion = me.getAction();
        int posx = (int) me.getX();
        int posy = (int) me.getY();

        switch (accion){
            case MotionEvent.ACTION_DOWN:
                puntero=agarrando(posx,posy);
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero != null){
                    puntero.mover(posx,posy);
                }
                break;
            case MotionEvent.ACTION_UP:
                if(puntero!=null){
                    if(nino.estaEnArea(posx,posy)){
                        nino.comer(puntero.caloria);
                        evaluarnino(nino.imc);
                    }
                    puntero.x=gx;
                    puntero.y=gy;
                }
                puntero=null;
                break;
        }
        invalidate();
        return true;
    }

}
