//package com.mygdx.game;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.InputListener;
//
//public class WalkingControl extends MyGameTank{
//
//    //размер джоя
//    public static  float SIZE = 4f;
//    //размер движущейся части (khob)
//    public static  float CSIZE = 3f;
//
//    public static  float CIRCLERADIUS = 1.5f;
//    public static float  CONTRLRADIUS = 3F;
//    //public static float Coefficient = 1F;
//
//    //угол для определения направления
//    float angle;
//    //public static int Opacity = 1;
//    MyGdxGame mygdxGame;
//
//    //координаты отклонения khob
//    protected Vector2 offsetPosition = new Vector2();
//
//    protected Vector2 position = new Vector2();
//    protected Rectangle bounds = new Rectangle();
//
//    public WalkingControl(Vector2 pos, MyGdxGame mygdxGame){
//        this.position = pos;
//        this.bounds.width = SIZE;
//        this.bounds.height = SIZE;
//        this.mygdxGame = mygdxGame;
//
//        getOffsetPosition().x = 0;
//        getOffsetPosition().y = 0;
//
//        setHeight(SIZE*mygdxGame.ppuY);
//        setWidth(SIZE*mygdxGame.ppuX);
//        setX(position.x*mygdxGame.ppuX);
//        setY(position.y*mygdxGame.ppuY);
//
//        addListener(new InputListener() {
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                return true;
//            }
//
//            //при перетаскивании
//            public void touchDragged(InputEvent event, float x, float y, int pointer){
//
//                withControl(x,y);
//            }
//
//            //убираем палец с экрана
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//
//                getOffsetPosition().x = 0;
//                getOffsetPosition().y = 0;
//            }
//
//        });
//    }
//
//
//
//    //отрисовка
//    @Override
//    public void draw(SpriteBatch batch, float parentAlfa) {
//
//
//
//        batch.draw(mygdxGame.textureRegions.get("navigation-arrows"), getX(), getY(),getWidth(), getHeight());
//        batch.draw(mygdxGame.textureRegions.get("khob"),
//                (float)(position.x+WalkingControl.SIZE/2-WalkingControl.CSIZE/2+getOffsetPosition().x)*mygdxGame.ppuX,
//                (float)(position.y+WalkingControl.SIZE/2-WalkingControl.CSIZE/2+getOffsetPosition().y)*mygdxGame.ppuY,
//                WalkingControl.CSIZE * mygdxGame.ppuX, WalkingControl.CSIZE * mygdxGame.ppuY);
//
//    }
//
//
//    public MyGdxGame hit(float x, float y, boolean touchable) {
//        //Процедура проверки. Если точка в прямоугольнике актёра, возвращаем актёра.
//        return x > 0 && x < getWidth() && y> 0 && y < getHeight()?this:null;
//    }
//
//
//    public Vector2 getPosition() {
//        return position;
//    }
//    public Vector2 getOffsetPosition() {
//        return offsetPosition;
//    }
//
//    public Rectangle getBounds() {
//        return bounds;
//    }
//
//
//
//
//    public void withControl(float x, float y){
//
//        //точка касания относительно центра джойстика
//        float calcX = x/mygdxGame.ppuX -SIZE/2;
//        float calcY = y/mygdxGame.ppuY -SIZE/2;
//
//        //определяем лежит ли точка касания в окружности джойстика
//        if(((calcX*calcX + calcY* calcY)<=WalkingControl.CONTRLRADIUS*WalkingControl.CONTRLRADIUS)
//        ){
//
//            mygdxGame.resetSelected();
//
//            //пределяем угол касания
//            double angle = Math.atan(calcY/calcX)*180/Math.PI;
//
//            //угол будет в диапозоне [-90;90]. Удобнее работать, если он в диапозоне [0;360]
//            //поэтому пошаманим немного
//            if(angle>0 &&calcY<0)
//                angle+=180;
//            if(angle <0)
//                if(calcX<0)
//                    angle=180+angle;
//                else
//                    angle+=360;
//
//            //в зависимости от угла указываем направление, куда двигать игрока
//            if(angle>40 && angle<140)
//                ((MyGameTank)mygdxGame.selectedActor).upPressed();
//
//            if(angle>220 && angle<320)
//                ((MyGameTank)mygdxGame.selectedActor).downPressed();
//
//
//            if(angle>130 && angle<230)
//                ((MyGameTank)mygdxGame.selectedActor).leftPressed();
//
//            if(angle<50 || angle>310)
//                ((MyGameTank)mygdxGame.selectedActor).rightPressed();
//
//
//            //двигаем игрока
//            ((MyGameTank)mygdxGame.selectedActor).processInput();
//
//
//            angle = (float)(angle*Math.PI/180);
//            getOffsetPosition().x = (float)((calcX*calcX + calcY* calcY>1F)? Math.cos(angle)*0.75F: calcX);
//            getOffsetPosition().y = (float)((calcX*calcX + calcY* calcY>1F)? Math.sin(angle)*0.75F: calcY);
//
//        }
//        else{
//
//            mygdxGame.resetSelected();
//            getOffsetPosition().x = 0;
//            getOffsetPosition().y = 0;
//        }
//
//    }
//}