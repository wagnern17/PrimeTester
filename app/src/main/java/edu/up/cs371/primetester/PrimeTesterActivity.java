package edu.up.cs371.primetester;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class PrimeTesterActivity extends ActionBarActivity {

    // instance variables
    private String primeString; // "Prime number."
    private String notPrimeString; // "Not a prime number."
    EditText inputField; // input field
    TextView answerField; // field where results is displayed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_tester);

// initialize our resource instance variables
        primeString = this.getString(R.string.is_prime);
        notPrimeString = this.getString(R.string.not_prime);
        answerField = (TextView) findViewById(R.id.resultTextView);
        inputField = (EditText) findViewById(R.id.inputField);

// define event callback: when 'enter' key (e.g., "done"), we call the isPrime method
// in the PrimeTesterActivity class, and set the result field to be the appropriate message.
        inputField.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String input = String.valueOf(inputField.getText());
                    String result;
                    try {
                        long value = Long.valueOf(input);
                        result = PrimeTester.isPrime(value) ? primeString : notPrimeString;
                    } catch (NumberFormatException nfx) {
                        result = notPrimeString;
                    }
                    answerField.setText(result);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prime_tester, menu);
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
