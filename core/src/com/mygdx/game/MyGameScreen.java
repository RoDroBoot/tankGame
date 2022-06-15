package com.mygdx.game;

import static java.lang.Long.SIZE;
import static sun.net.InetAddressCachePolicy.get;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Event;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyGameScreen implements Screen {
    //=========


    Array<MyGameTank> myGameTanks = new Array<>();

    int nPlayers = 10;


    //=========
    float time;
    MyGameTank myGameTank;
    final MyGdxGame gdxGame;
    SpriteBatch batch;
    AppleList appleList;
    AppleList bltList;
    Bullet bullet;
    float y;
    float x;

    public MyGameScreen(final MyGdxGame gdxGame) {
        this.gdxGame = gdxGame;
        batch = gdxGame.batch;
        myGameTank = new MyGameTank(gdxGame.NewTankGame, 0.09f);
        appleList = new AppleList(gdxGame.pngegg);
        bullet = new Bullet(gdxGame.newBullet, 0.09f);
        bltList = new AppleList(gdxGame.newBullet);

    }


    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {
        //===============================
//        if (stateOfGame == WAIT_RESTART) {
//            fontLarge.draw(batch, "GAME OVER", 0, SCR_HEIGHT / 2 + fontLarge.getCapHeight() / 2,
//                    SCR_WIDTH, Align.center, true);}
//            for (int i = 0; i < nPlayers; i++) {
//                fontSmall.draw(batch, myGameTanks.get(i).name + ": " + myGameTanks.get(i).frags, 100, SCR_HEIGHT / 3 - i * 30);
//            }
            //===============================

            if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                System.out.println("Tank Died");
            }
            Gdx.gl.glClearColor(0, 0.7f, 0, 0.4f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            time += Gdx.graphics.getDeltaTime();
            appleList.spawn();
            appleList.move(time);
            batch.begin();
            myGameTank.draw(batch, time);
            appleList.draw(batch);

            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                bltList.move(time);
                bltList.spawn();
                bullet.draw(batch, time);
                bltList.draw(batch);
                System.out.println("Shoot");

            }

            batch.end();

            //Управление 1
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                myGameTank.move(myGameTank.UP, time);
                bullet.move(bullet.UP, time);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                myGameTank.move(myGameTank.DOWN, time);
                bullet.move(bullet.DOWN, time);

            }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                myGameTank.move(myGameTank.RIGHT, time);
                bullet.move(bullet.RIGHT, time);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                myGameTank.move(myGameTank.LEFT, time);
                bullet.move(bullet.LEFT, time);
            }


            //Управление 2
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                myGameTank.move(myGameTank.UP, time);
                bullet.move(bullet.UP, time);

            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                myGameTank.move(myGameTank.DOWN, time);
                bullet.move(bullet.DOWN, time);

            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                myGameTank.move(myGameTank.RIGHT, time);
                bullet.move(bullet.RIGHT, time);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                myGameTank.move(myGameTank.LEFT, time);
                bullet.move(bullet.LEFT, time);
            }


    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

//    void gameOver() {
//        Preferences prefs = Gdx.app.getPreferences("preferences");
//        for (int i = 0; i < nPlayers; i++) {
//            if (prefs.contains("Name" + i))
//                myGameTanks.get(i).name = prefs.getString("Name" + i, "noname"); // читаем
//             }


}


