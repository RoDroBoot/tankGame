package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public  class MyGameMenu implements Screen {
    final MyGdxGame gdxGame;
    BitmapFont font;
    SpriteBatch batch;
    OrthographicCamera camera;

    public MyGameMenu(final MyGdxGame gdxGame) {
        this.gdxGame = gdxGame;
        font = gdxGame.font;
        batch = gdxGame.batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,640,480);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0.4f,0.3f,0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        gdxGame.batch.setProjectionMatrix(camera.combined);

        batch.begin();
        font.draw(batch, "*Start 1 level*",280,270);
        font.draw(batch, "<Start 2 level>",278,240);
        font.draw(batch, "<Start 3 level>",278,210);
        font.draw(batch, "MENU GAME",278,455);
        batch.end();
        if(Gdx.input.isTouched()){
            gdxGame.setScreen(new MyGameScreen(gdxGame));
            dispose();
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
}