package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.LinkedList;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyGameTank {
    int a;
    float y = 1,dy = 2 , x = 1 ,dx = 2.5f,    dr = 1;
    final int UP = 0 , DOWN = 1 ,  RIGHT = 3 , LEFT = 4;
    Animation<TextureRegion> NewTankGame;
    TextureRegion[] currFrame;
    Texture newTankGame;
    Texture img;
    float lastMove;
    //============
    String name;
    int frags;
    //===========================

    public static Random random = new Random();

    public MyGameTank(Texture img, float frameDuration) {
        //=========
        this.name = name;
        this.frags = frags;
        //===================
        TextureRegion[][] textureRegions = TextureRegion.split(img,img.getWidth() / 4, img.getHeight() );
        currFrame = textureRegions[0].clone();
        NewTankGame = new Animation(frameDuration, currFrame);

    }

    public void draw(SpriteBatch batch, float time){
        batch.draw(NewTankGame.getKeyFrame(time,true),x,y,55,55);

    }
    public void move(int key, float time){
        if(time - lastMove > 0.001f);
        lastMove = time;
        if (key == UP){
            y += dy;
        }
        if (key == DOWN){
            y -= dy;
        }



        if (key == RIGHT) {
            x += dx;
        }

        if (key == LEFT) {
            x -= dr;
        }

    }

}


