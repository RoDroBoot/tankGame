package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends Game{
    SpriteBatch batch;
	BitmapFont font;
	Texture NewTankGame;
	Texture newBullet;
	Texture pngegg;
	Texture bullet;
	TextureRegion[] currFrame;

	@Override
	public void create(){
		batch = new SpriteBatch();
		NewTankGame =  new Texture("NewTankGame.png");
		pngegg  = new Texture("pngegg.png");
		newBullet = new Texture("bullet.png");
		font = new BitmapFont();
		setScreen(new MyGameMenu(this));

	}


	@Override
	public void render(){
		super.render();

	}

	@Override
	public void dispose() {
		batch.dispose();
		NewTankGame.dispose();
		pngegg.dispose();
		bullet.dispose();
		font.dispose();
	}

}
