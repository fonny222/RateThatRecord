package christopherfontana.ratethatrecord;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    // create instance of the mediaplayer class
    MediaPlayer mpBuble, mpTrouble, mpWonder;

    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // create instance of the buttons to play the music
        final Button michaelBuble = (Button) findViewById(R.id.btnBuble);
        final Button vinTrouble = (Button) findViewById(R.id.btnTrouble);
        final Button stevWonder = (Button) findViewById(R.id.btnWonder);

        // create instances of media player
        mpBuble = new MediaPlayer();
        mpTrouble = new MediaPlayer();
        mpWonder = new MediaPlayer();

        // assign songs to mpBuble mpTrouble and mpWonder
        mpBuble = MediaPlayer.create(this, R.raw.thebestisyettocome);
        mpTrouble = MediaPlayer.create(this, R.raw.runliketheriver);
        mpWonder = MediaPlayer.create(this, R.raw.superstition);

        // instance of image view
        final ImageView mBuble = (ImageView) findViewById(R.id.mainImage);
        final ImageView vTrouble = (ImageView) findViewById(R.id.mainImage);
        final ImageView sWonder = (ImageView) findViewById(R.id.mainImage);

        // creates an image view and sets it to invisible
        final ImageView mImage = (ImageView) findViewById(R.id.mainImage);

        // this sets the image view to invisible to start
        mImage.setVisibility(View.INVISIBLE);

        playing = 0;

        // create listener for each button
        michaelBuble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mImage.setVisibility(View.VISIBLE);
                        mpBuble.start();
                        playing = 1;
                        michaelBuble.setText("Pause The Best Is Yet To Come");
                        mBuble.setImageResource(R.drawable.michaelbubleresized);
                        vinTrouble.setVisibility(View.INVISIBLE);
                        stevWonder.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mImage.setVisibility(View.INVISIBLE);
                        mpBuble.pause();
                        playing = 0;
                        michaelBuble.setText("Play The Best Is Yet To Come");
                        vinTrouble.setVisibility(View.VISIBLE);
                        stevWonder.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        vinTrouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mImage.setVisibility(View.VISIBLE);
                        mpTrouble.start();
                        playing = 1;
                        vinTrouble.setText("Pause Run Like The River");
                        vTrouble.setImageResource(R.drawable.vtroubleresized);
                        michaelBuble.setVisibility(View.INVISIBLE);
                        stevWonder.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mImage.setVisibility(View.INVISIBLE);
                        mpTrouble.pause();
                        playing = 0;
                        vinTrouble.setText("Play Run Like The River");
                        michaelBuble.setVisibility(View.VISIBLE);
                        stevWonder.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });

        stevWonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    switch (playing) {
                        case 0:
                            mImage.setVisibility(View.VISIBLE);
                            mpWonder.start();
                            playing = 1;
                            stevWonder.setText("Pause Superstition");
                            sWonder.setImageResource(R.drawable.steviewonderresized);
                            michaelBuble.setVisibility(View.INVISIBLE);
                            vinTrouble.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            mImage.setVisibility(View.INVISIBLE);
                            mpWonder.pause();
                            playing = 0;
                            stevWonder.setText("Play Superstition");
                            michaelBuble.setVisibility(View.VISIBLE);
                            vinTrouble.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });


        // create an instance of the button to take you to the rankings class
        Button rankings = (Button) findViewById(R.id.btnRankings);

        // creates listener that loads the new class when a button is pressed
        rankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Rankings.class));
            }
        });

    }
}
