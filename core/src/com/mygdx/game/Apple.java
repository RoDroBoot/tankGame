package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

public class Apple {
    int dx = 1 , y , x = 640;
    Texture pngegg;
    Texture NewTankGame;
    float lastMove = 0f;
    AppleList list;
    SpriteBatch batch;
    public static Random random = new Random();

    public Apple(int y, Texture pngegg) {
        this.y = y;
        this.pngegg = pngegg;
    }


    public void draw(SpriteBatch batch){
        batch.draw(pngegg,x,y,55,55);


    }

    public void move(float time){
        if(time - lastMove > 0.01f){
            x -= dx;
            lastMove = time;
        }

    }



    boolean isVisible(){
        return x > 0;
    }


}
