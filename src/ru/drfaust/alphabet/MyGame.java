/**
 * Говнокоооод
 */
package ru.drfaust.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: adel
 * Date: 8/11/12
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyGame {

    /**
     * alphabet
     */
    private String alf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * alphabet array
     */
    private String[] arrAlf = alf.split("");

    /**
     * last action letter
     */
    private int lastAction1 = 0;

    /**
     * last action letter that was before lastAction1
     */
    private int lastAction2 = 0;

    CountDownTimer tmr;

    private String letter(int num)
    {
        return arrAlf[num];
    }


//    private int gameTime =  5 * 60 * 1000;
//    private int gameTick = 1000;
//    private TextView txt;
    /**
     * Action letter
     *
     * @return String
     */
    private String action()
    {
        String[] act = new String[3];
        act[0] = "L";
        act[1] = "R";
        act[2] = "T";

        return act[rnd3()];
    }

    /**
     * generating random number between 0-2
     * never repeat random more than 2 times
     *
     * @return int [0,1,2]
     */
    private int rnd3()
    {
        java.util.Random rn = new Random();
        int i =	rn.nextInt(3);
        if (lastAction1 == i && lastAction2 == i) {
            i = rnd3();
        }
        lastAction2 = lastAction1;
        lastAction1 = i;
        return i;
    }

    public MyGame(final TextView txt, int gameTime, int gameTick) {
        start(txt, gameTime, gameTick);

    }
    
    private void start(final TextView txt, int gameTime, int gameTick)
    {
        tmr = new CountDownTimer(gameTime, gameTick) {
            int i=1;
            public void onTick(long millisUntilFinished) {
                txt.setText(letter(i) +"\r\n" + action());
                i++;
                if (i == arrAlf.length) {
                    i=1;
                }
            }

            public void onFinish() {
                txt.setText("done!");
            }
        };

        tmr.start();
    }

    public void stop()
    {
        tmr.cancel();
    }


}
