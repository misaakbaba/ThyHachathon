package com.example.melkor.app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  LoginActivity extends AppCompatActivity {
    CrewPostInterface crewPostInterface;
    String mail;
    String password;
    Boolean goForward = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button btLogin = (Button)findViewById(R.id.login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mailEdit = (EditText)findViewById(R.id.mail);
                EditText passwordEdit = (EditText)findViewById(R.id.password);
                mail = mailEdit.getText().toString();
                password = passwordEdit.getText().toString();
                /*crewPostInterface=ApiClient.getClient().create(CrewPostInterface.class);
                Call<List<Response>> call = crewPostInterface.checkCrew(mail, password);
                //validate();
*/
                //crewPostInterface = ApiUtils.getAPIService();
                //sendPost(mail,password);
                if(goForward){
                    Intent intent = new Intent(LoginActivity.this,BriefingActivity.class);
                    intent.putExtra(mail,password);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void sendPost(String mail, String password){
        crewPostInterface.checkCrew(mail,password).enqueue(new Callback<Crew>() {
            @Override
            public void onResponse(Call<Crew> call, Response<Crew> response) {
                if(response.isSuccessful()) {
                    Log.i("Tag", "post submitted to API." + response.body().toString());
                }
                Log.d("hi", "onResponse: " );
                //JSONObject jsonObject = new JSONObject(response);


                //JsonParser jsonParser = new JsonParser();

                //if (goForwardString.equals("true")) {
                    goForward = true;
                //}
            }

            @Override
            public void onFailure(Call<Crew> call, Throwable t) {
                Log.e("test", "Unable to submit post to API.");
            }
        });

    }

    /*private void validate() {
        Call<List<Response>> call = crewPostInterface.checkCrew(mail, password);
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, Response<List<Response>> response) {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject) jsonParser.parse(response.toString());
                String goForwardString = jsonObject.get("success").getAsString();
                if (goForwardString.equals("true")) {
                    goForward = true;
                }
                Log.d("check", "inOnResponse");
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });
    }*/
        }

