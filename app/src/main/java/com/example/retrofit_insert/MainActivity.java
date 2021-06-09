package com.example.retrofit_insert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit_insert.api.ApiRequestBiodata;
import com.example.retrofit_insert.api.Retroserver;
import com.example.retrofit_insert.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText nama_v, salary_v, desig_v;
    Button btnsave, btnview, btnupdate,btndelete;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama_v = (EditText) findViewById(R.id.edt_nama);
        salary_v = (EditText) findViewById(R.id.edt_usia);
        desig_v = (EditText) findViewById(R.id.edtdomisili);
        btnview = (Button) findViewById(R.id.btnviewdata);
        btnupdate =(Button) findViewById(R.id.btnUpdate);
        btnsave = (Button) findViewById(R.id.btn_insertdata);
        btndelete=(Button) findViewById(R.id.btnhapus);
        pd = new ProgressDialog(this);



        //-----------------insert

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();

                String snama = nama_v.getText().toString();
                String salary = salary_v.getText().toString();
                String sdesig = desig_v.getText().toString();
                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

                Call<ResponsModel> sendbio = api.sendBiodata(snama,salary,sdesig);
                sendbio.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String code = response.body().getCode();

                        if(code.equals("1"))
                        {
                            Toast.makeText(MainActivity.this, "Data save successfully", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(MainActivity.this, "Data Error pls entry correctly", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                    }
                });
            }
        });

        //-----------------insert



    }
}