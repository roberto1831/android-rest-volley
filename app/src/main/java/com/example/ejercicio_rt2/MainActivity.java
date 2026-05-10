package com.example.ejercicio_rt2;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtTitulo, txtCuerpo;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtCuerpo = findViewById(R.id.txtCuerpo);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //leerRest();
               /*insertarRest(txtTitulo.getText().toString(),
                        txtCuerpo.getText().toString(),
                        txtUsuario.getText().toString());*/
               /* updateRest(txtTitulo.getText().toString(),
                        txtCuerpo.getText().toString(),
                        txtUsuario.getText().toString());*/
                eliminarRest();
            }
        });
    }

    /*
     * LEER DATOS DESDE LA WEB
     */
    private void leerRest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest getRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUsuario.setText(jsonObject.getString("userId"));
                    txtTitulo.setText(jsonObject.getString("title"));
                    txtCuerpo.setText(jsonObject.getString("body"));
                    Toast.makeText(MainActivity.this, "Datos cargados con éxito", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Error al procesar los datos", Toast.LENGTH_SHORT).show();
                    Log.e("error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(getRequest);
    }

    /*
     * INSERTAR DATOS
     */
    private void insertarRest(final String usuario, final String titulo, final String cuerpo) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest postRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Datos insertados: " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Error al procesar la respuesta", Toast.LENGTH_SHORT).show();
                    Log.e("error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error al insertar los datos", Toast.LENGTH_SHORT).show();
                Log.e("error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("title", titulo);
                param.put("body", cuerpo);
                param.put("userid", usuario);
                return param;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    /*
     * ACTUALIZAR DATOS
     */
    private void updateRest(final String usuario, final String titulo, final String cuerpo) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest putRequest = new StringRequest(
                Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Datos actualizados: " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Error al procesar la respuesta", Toast.LENGTH_SHORT).show();
                    Log.e("error", e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error al actualizar los datos", Toast.LENGTH_SHORT).show();
                Log.e("error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("id", "1");
                param.put("title", titulo);
                param.put("body", cuerpo);
                param.put("userid", usuario);
                return param;
            }
        };
        Volley.newRequestQueue(this).add(putRequest);
    }

    /*
     * ELIMINAR DATOS
     */
    private void eliminarRest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest deleteRequest = new StringRequest(
                Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Datos eliminados: " + response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String errorMsg = error.getMessage() != null ? error.getMessage() : "Error desconocido";
                        Log.e("Error", errorMsg);
                        Toast.makeText(MainActivity.this, "Error al eliminar: " + errorMsg, Toast.LENGTH_LONG).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(deleteRequest);
    }
}
