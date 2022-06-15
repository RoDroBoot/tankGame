package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ScrollPaneConstants;

public class Bullet {
    float y = 13,dy = 2 , x = 240 ,dx = 2.5f,    dr = 1;
    float q = 100, w = 39,e = 100,r = 80,t = y-40,u = y+80;
    final int UP = 0 , DOWN = 1 ,  RIGHT = 3 , LEFT = 4;
    Animation<TextureRegion>bullet;
    TextureRegion[] currFrame;
    float lastMove;


//    public static Random random = new Random();

    public Bullet(Texture img, float frameDuration) {



        TextureRegion[][] textureRegions = TextureRegion.split(img,img.getWidth(), img.getHeight() );
        currFrame = textureRegions[0].clone();
        bullet = new Animation(frameDuration, currFrame);

    }


    public void render(SpriteBatch batch){
        batch.begin();
        batch.end();
    }


    public void draw(SpriteBatch batch, float time){
        batch.draw(bullet.getKeyFrame(time,true),x,y,190,190);
//        batch.draw(bullet.getKeyFrame(time,true),q,w,40,40);
//        batch.draw(bullet.getKeyFrame(time,true),e,t,40,40);
//        batch.draw(bullet.getKeyFrame(time,true),r,u,40,40);
    }


    public void move(int key, float time) {
        if(time - lastMove > 0.01f){
            //x += dx;
            lastMove = time;
        }
            if (time - lastMove > 0.001f) ;
            lastMove = time;


            if (key == UP) {
                y += dy;
            }
            if (key == DOWN) {
                y -= dy;
            }


            if (key == RIGHT) {
                x += dx;
            }

            if (key == LEFT) {
                x -= dr;
            }
//        //Сюда лучше не смотреть! Опасно для психики)
//        if (key == UP) {
//            w += dy;
//        }
//        if (key == DOWN) {
//            w -= dy;
//        }
//
//
//        if (key == RIGHT) {
//            q += dx;
//        }
//
//        if (key == LEFT) {
//            q -= dr;
//        }
//        //===============================
//        if (key == UP) {
//            t += dy;
//        }
//        if (key == DOWN) {
//            t -= dy;
//        }
//
//
//        if (key == RIGHT) {
//            e += dx;
//        }
//
//        if (key == LEFT) {
//            e -= dr;
//        }
//        //===============================
//        if (key == UP) {
//            u += dy;
//        }
//        if (key == DOWN) {
//            u -= dy;
//        }
//
//
//        if (key == RIGHT) {
//            r += dx;
//        }
//
//        if (key == LEFT) {
//            r -= dr;
//        }
//
        }
    }


