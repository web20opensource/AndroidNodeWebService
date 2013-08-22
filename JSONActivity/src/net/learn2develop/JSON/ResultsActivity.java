package net.learn2develop.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.util.Log;


public class ResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.status);

		try {
			JSONArray j = new JSONArray(getIntent().getStringExtra("results"));

            Log.i("JSON","Elements in json: "+j.length());

            int orientation = this.getResources().getConfiguration().orientation;
            //VERTICAL
            if  ( orientation == 2 ){
// LANDSCAPE
                /*View backgroundimageHor = findViewById(R.id.background_hori);
                Drawable backgroundHori = backgroundimageHor.getBackground();
                backgroundHori.setAlpha(30);*/

                TextView matricula = (TextView) findViewById(R.id.matricula_hor);
                matricula.setText(j.getJSONObject(0).getString("matricula") );
                //matricula.setText(j.getJSONObject(0).get(getString(R.string.id)).toString());

                TextView carrera = (TextView) findViewById(R.id.carrera_hor);
                //carrera.setText(j.getJSONObject(0).get(getString(R.string.career)).toString());
                carrera.setText(j.getJSONObject(0).getString("carrera") ) ;

                TextView puntaje = (TextView) findViewById(R.id.puntaje_hor);
                //puntaje.setText(j.getJSONObject(0).get(getString(R.string.score)).toString());
                puntaje.setText(j.getJSONObject(0).getString("puntaje"));
                String mensaje, status;
                //if (j.getJSONObject(0).get(getString(R.string.status)).toString().equals("A") ){
                if (j.getJSONObject(0).getString("status").equals("A") ){
                    status =  getString(R.string.StatusA);
                    mensaje = getString(R.string.messageStatusA);
                }
                else{
                    status = getString(R.string.StatusN);
                    mensaje = getString(R.string.messageStatusN);
                }

                TextView tStatus = (TextView) findViewById(R.id.status_hor);
                tStatus.setText(status);

                Toast.makeText(getBaseContext(), mensaje,Toast.LENGTH_LONG).show();

            }else{

               /* View backgroundimage = findViewById(R.id.background_ver);
                Drawable background = backgroundimage.getBackground();
                background.setAlpha(30);*/

                TextView matricula = (TextView) findViewById(R.id.matricula);
                matricula.setText(j.getJSONObject(0).getString("matricula") );
                //matricula.setText(j.getJSONObject(0).get(getString(R.string.id)).toString());

                TextView carrera = (TextView) findViewById(R.id.carrera);
                //carrera.setText(j.getJSONObject(0).get(getString(R.string.career)).toString());
                carrera.setText(j.getJSONObject(0).getString("carrera") ) ;

                TextView puntaje = (TextView) findViewById(R.id.puntaje);
                //puntaje.setText(j.getJSONObject(0).get(getString(R.string.score)).toString());
                puntaje.setText(j.getJSONObject(0).getString("puntaje"));
                String mensaje, status;
                //if (j.getJSONObject(0).get(getString(R.string.status)).toString().equals("A") ){
                if (j.getJSONObject(0).getString("status").equals("A") ){
                    status =  getString(R.string.StatusA);
                    mensaje = getString(R.string.messageStatusA);
                }
                else{
                    status = getString(R.string.StatusN);
                    mensaje = getString(R.string.messageStatusN);
                }

                TextView tStatus = (TextView) findViewById(R.id.status);
                tStatus.setText(status);

                Toast.makeText(getBaseContext(), mensaje,Toast.LENGTH_LONG).show();

            }




			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
			
		
		
		
		
		
		
			}

	

}
