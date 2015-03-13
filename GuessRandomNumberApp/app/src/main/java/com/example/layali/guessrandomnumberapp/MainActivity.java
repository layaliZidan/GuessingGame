package com.example.layali.guessrandomnumberapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int rNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

public void generate_Random(View view)
  {
    Random r = new Random();
      rNumber= r.nextInt(1000);
      EditText text = (EditText)findViewById(R.id.editTextNumber);
      text.setText("");
      Toast.makeText(this,"now start to guess numbers ",Toast.LENGTH_LONG).show();
  }



    public void checkNumber(View view)
    {
        int enteredNumber;
        EditText text = (EditText)findViewById(R.id.editTextNumber);
      try {
          enteredNumber = Integer.parseInt(text.getText().toString());

          if( enteredNumber == rNumber)
          {
              Toast.makeText(this,"congratulation :D good job ",Toast.LENGTH_LONG).show();
              Toast.makeText(this,"tab play to play again ",Toast.LENGTH_LONG).show();
          }
          else if((enteredNumber-rNumber)>5)
          {
              Toast.makeText(this,"Greater , please try smaller number  ",Toast.LENGTH_LONG).show();
          }
          else if((rNumber-enteredNumber)>5)
          {
              Toast.makeText(this,"smaller , please enter greater number ",Toast.LENGTH_LONG).show();
          }
          else if ((enteredNumber - rNumber) <=5 || (rNumber - enteredNumber) <= 5)
          {
              Toast.makeText(this,"very close :D  ",Toast.LENGTH_LONG).show();
          }

      } catch(final NumberFormatException e)
      {
          Toast.makeText(this,"Please enter number!! ",Toast.LENGTH_LONG).show();
      }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
