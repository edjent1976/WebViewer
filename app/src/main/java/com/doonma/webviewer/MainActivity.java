package com.doonma.webviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button button;
    private WebView webView;
    private EditText parsedUrl;
    private TextView prefix;
    private StringBuilder sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Typeface roboto_slim = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Light.ttf");

        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button_one);
        //button.setTypeface(roboto_slim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(context, "button pressed", Toast.LENGTH_LONG ).show();
                parsedUrl = (EditText) findViewById(R.id.entered_url);
                prefix = (TextView) findViewById(R.id.prefix);
                webView = (WebView) findViewById(R.id.web_view);
                webView.setWebViewClient(new MyWebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);

                sb = new StringBuilder(prefix.getText().toString());
                sb.append(parsedUrl.getText().toString());
                Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
                webView.loadUrl(sb.toString());

            }

        });

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
