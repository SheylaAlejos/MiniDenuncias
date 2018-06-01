package com.sheyla.minidenuncias.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sheyla.minidenuncias.ApiService;
import com.sheyla.minidenuncias.ApiServiceGenerate;
import com.sheyla.minidenuncias.R;
import com.sheyla.minidenuncias.ResponseMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sheyla on 25/05/2018.
 */

public class RegisterUsuarioActivity extends AppCompatActivity {

    private static final String TAG = RegisterUsuarioActivity.class.getSimpleName();
    private EditText nombreInput;
    private EditText apellidoInput;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText distritoInput;
    private static final int REGISTER_FORM_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_usuario);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        nombreInput = (EditText) findViewById(R.id.nombre_input);
        apellidoInput = (EditText) findViewById(R.id.apellido_input);
        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        distritoInput = (EditText) findViewById(R.id.distrito_input);


    }
    public void callRegister(View view) {

        String nombre = nombreInput.getText().toString();
        String apellido = apellidoInput.getText().toString();
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String distrito = distritoInput.getText().toString();


        if (nombre.isEmpty() || apellido.isEmpty()|| username.isEmpty()|| password.isEmpty()|| distrito.isEmpty()) {
            Toast.makeText(this, "Todos los campos son campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService service = ApiServiceGenerate.createService(ApiService.class);

        Call<ResponseMessage> call = null;
        call = service.createUsuarios(nombre, apellido, username, password,distrito,1);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        Toast.makeText(RegisterUsuarioActivity.this, responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                        finish();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(RegisterUsuarioActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(RegisterUsuarioActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }

        });
        startActivityForResult(new Intent(this, MainActivity.class), REGISTER_FORM_REQUEST);

    }


    public void showRegisterusuario(View view){
    }

}
