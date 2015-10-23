package com.example.alumno.clase9;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Titulo");
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView wv = (WebView)this.findViewById(R.id.webViweMain);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);


        wv.setWebViewClient(new WebViewClient());
        /*Load Game from GIT*/
        //wv.loadUrl("http://gabrielecirulli.github.io/2048/");

        wv.loadUrl("file:///assets/2048-master/index.html");
    }


    @Override
    /*"Algo" llama al metodo de creacion del menu*/
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); /*Arma a partir del archivo xml los items del menu*/

        SearchView sv = (SearchView) menu.findItem(R.id.campo_buscar).getActionView();
        sv.setOnQueryTextListener(this);

        return true; /*retorno true para que los items y el menu aparezca*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch ( id ) {
            case R.id.action_settings:
                Toast.makeText(getBaseContext(), "Item " + item.getItemId(), Toast.LENGTH_LONG).show();
                return true;
                //break;
            case android.R.id.home:
                this.finish(); /*cierra la activity. nunca deberia estar en la Activity asi puesta*/
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    /*Podria utilizarlo para busca en algun onjeto o internet algun resultado que escribo en mi ActionBar*/
    public boolean onQueryTextSubmit(String query) {
        Log.d("QrySubmit", query);
        return false;
    }

    @Override
    /*Se ejecuta cada vez que presiono una tecla*/
    public boolean onQueryTextChange(String newText) {
        Log.d("QrySubmit", newText);
        return false;
    }
}
