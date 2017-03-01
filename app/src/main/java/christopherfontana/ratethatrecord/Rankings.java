package christopherfontana.ratethatrecord;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Rankings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        // takes whats in each spinner applies it to a variable
        final Spinner rank1 = (Spinner) findViewById(R.id.txtSongs);
        final Spinner rank2 = (Spinner) findViewById(R.id.txtSongs2);
        final Spinner rank3 = (Spinner) findViewById(R.id.txtSongs3);

        // create instance of the submit button
        Button submit = (Button) findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {

            // create instance of the textView txtResult to allow the text to change
            final TextView result = ((TextView)findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {

                // converts the choices from the spinners to a string
                String spinner1Text =  rank1.getSelectedItem().toString();
                String spinner2Text = rank2.getSelectedItem().toString();
                String spinner3Text = rank3.getSelectedItem().toString();

                // if statement makes sure you cannot choose the same song for each or leave it at the default text
               if(spinner1Text.equals(spinner2Text) || spinner1Text.equals(spinner3Text) || spinner2Text.equals(spinner3Text)){
                   result.setText("Please choose a Different song for each!");
               }
               if(spinner1Text.equals("Pick A Song")|| spinner2Text.equals("Pick A song") || spinner3Text.equals("Pick A Song")){
                   result.setText("Please choose a Different song for each!");
               }
                else {

                   // display the results in the textView  txtResult in variable result
                   result.setText(spinner1Text + "\r\n" + spinner2Text + "\r\n" + spinner3Text);
               }
            }
        });

    }

}
