package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.LinkedList;
import java.util.Random;

public class AppleList {

    Random random =  new Random();
    Texture pngegg;
    LinkedList<Apple>list =  new LinkedList<Apple>();
    LinkedList<Bullet>bulletLinkedListst =  new LinkedList<Bullet>();
    int x = 200, y = 200 , h = 50;


    public AppleList(Texture pngegg) {
        this.pngegg =  pngegg;
    }

    public void draw(SpriteBatch batch) {
        for (Apple pngegg : list) {
            pngegg.draw(batch);

        }
    }

    public void move(float time){
        for (Apple pngegg : list){
            pngegg .move(time);
        }

        for(int i = 0 ; i < list.size(); i++){
            if(!list.get(i).isVisible()|| Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                list.remove(i);
            }
        }
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,h,h);
    }


    public void spawn(){
        if(random.nextInt(10) > 5);
        list.add(new Apple(random.nextInt(4000) +3 , pngegg));

    }

}


