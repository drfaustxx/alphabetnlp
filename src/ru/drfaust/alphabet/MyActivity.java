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
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class MyActivity extends Activity
{
    private int gameTime =  5 * 60 * 1000;
    private int gameTick = 1000;
    private MyGame game;

    public static final int MNU_RESTART = 102;
    public static final int MNU_SETTINGS = 100;
    public static final int MNU_INFO = 101;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setGameTime(extras.getInt("gameTime"));
            setGameTick(extras.getInt("gameTick"));
        }
        play();

    }

    public void play()
    {
        //чтобы экран не гас
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //полноэкранный режим
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        final TextView txt = (TextView)findViewById(R.id.txt1);

        game = new MyGame(txt, gameTime, gameTick);
    }

    public void setGameTime(int minutes) {
        gameTime = minutes * 60 * 1000;
    }

    public void setGameTick(int level) {

        switch (level) {
            case 1:
                gameTick = 1000;
                break;
            case 2:
                gameTick = 900;
                break;
            case 3:
                gameTick = 800;
                break;
            case 4:
                gameTick = 700;
                break;
            case 5:
                gameTick = 600;
                break;
            default:
                gameTick = 1000;
                break;
        }

    }

    

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(Menu.NONE, MNU_RESTART, Menu.NONE, "Play again").setIcon(android.R.drawable.ic_menu_rotate);
        menu.add(Menu.NONE, MNU_SETTINGS, Menu.NONE, "Settings").setIcon(android.R.drawable.ic_menu_manage);
        menu.add(Menu.NONE, MNU_INFO, Menu.NONE, "Information").setIcon(android.R.drawable.ic_menu_info_details);

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MNU_RESTART:
                game.stop();
                play();
                break;

            case MNU_SETTINGS:
                Intent mySettingsIntent = new Intent(getApplicationContext(), MySettings.class);
                startActivity(mySettingsIntent);
                break;

            case MNU_INFO:
                Intent myInfoIntent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(myInfoIntent);
                break;


            default:
                return false;
        }
        return true;
    }

    
}
