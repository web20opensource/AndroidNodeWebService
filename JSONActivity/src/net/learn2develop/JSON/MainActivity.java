package net.learn2develop.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private RelativeLayout myRelativeLayout;
    private EditText id;
    private Button send;
    private TextView labelId;
    private TextView labelButton;
    private int mHeight = 0;
    private int mWidth = 0;
    private View mView;


    private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

    //See more at: http://thedeveloperworldisyours.com/android/add-a-textview-and-a-button-to-linear-layout-programmatically/#sthash.M0ScYDTE.dpuf
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        int orientation = this.getResources().getConfiguration().orientation;


        if  ( orientation ==  2 ){

                View layout1 = inflater.inflate(R.layout.buap,
                        (ViewGroup) findViewById(R.id.toast_layout_root_buap_hor));

                TextView textBuap = (TextView) layout1.findViewById(R.id.textView1_hor);

                Toast toastBuap = new Toast(getApplicationContext());
                toastBuap.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toastBuap.setDuration(Toast.LENGTH_LONG);
                toastBuap.setView(layout1);
                toastBuap.show();

                View layout2 = inflater.inflate(R.layout.dae,
                        (ViewGroup) findViewById(R.id.toast_layout_root_dae_hor));

                TextView textDae = (TextView) layout2.findViewById(R.id.textView2_hor);

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout2);
                toast.show();
        }
        else{ // PORTRAIT
                View layout1 = inflater.inflate(R.layout.buap,
                        (ViewGroup) findViewById(R.id.toast_layout_root_buap_ver));


                TextView textBuap = (TextView) layout1.findViewById(R.id.textView1);
                textBuap.setText("BIENVENIDOS");

                Toast toastBuap = new Toast(getApplicationContext());
                toastBuap.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toastBuap.setDuration(Toast.LENGTH_LONG);
                toastBuap.setView(layout1);
                toastBuap.show();

                View layout2 = inflater.inflate(R.layout.dae,
                        (ViewGroup) findViewById(R.id.toast_layout_root_dae));

                TextView textDae = (TextView) layout2.findViewById(R.id.textView2);

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout2);
                toast.show();

        }



        mHandler.postDelayed(new Runnable() {
            public void run() {
                setContentView(R.layout.fragment_search_id);
                //lay.setVisibility(VISIBLE);
            }
        }, 7000);

    }
	
	public void onClick(View v){
		
		TextView id = (TextView) findViewById(R.id.id);
        InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
        imm.showSoftInput(id, InputMethodManager.SHOW_IMPLICIT);
		//new ReadJSONFeedTask().execute(getString(R.string.webService),id.getText().toString().trim());
        new ReadJSONFeedTask().execute("http://67.207.139.8:1337/?id=",id.getText().toString().trim());
	}


	public String readJSONFeed(String URL, String id) {
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();

        String url = URL + id;
		HttpGet httpGet = new HttpGet(url);
        Log.i("url", url);
		/*try{
			httpGet.setHeader("Charset","UTF-8");
		}catch (Exception e){
			
		}*/
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
                    Log.i("URL",line);
				}
			} else {
				Log.e("JSON", statusCode + " --" + statusLine.getReasonPhrase());
				Log.e("JSON", "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
    private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0], urls[1]);
        }
        
        protected void onPostExecute(String result) {
    			//resultJSON = result;
    			Intent i = new Intent("net.calificaciones.show");
    			i.putExtra("results", result);
    			startActivity(i);
        }
    }
	
	
	
	
	


}
