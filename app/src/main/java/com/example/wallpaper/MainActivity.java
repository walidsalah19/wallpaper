package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.wallpaper.apis.Api;
import com.example.wallpaper.apis.retrofit;
import com.example.wallpaper.gson_class.gson_class;
import com.example.wallpaper.gson_class.searchmodel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<gson_class> arrayList;
    private SearchView search ;
    private CardView car, train , nature , bus , triending ;
    private recycler_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList=new ArrayList<>();
        get_api_data_method();

        bus_method();
        car_method();
        train_method();
        triending_method();
        nature_method();
        search_view_method();
        recyclerView_method();
    }



    private void recyclerView_method()
    {
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        adapter=new recycler_adapter(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
    private void search_view_method()
    {
      search=(SearchView) findViewById(R.id.searchView);
      search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              if(!query.isEmpty())
              {
                    api_search_method(query);
              }
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
              if(!newText.isEmpty())
              {
                  api_search_method(newText);
              }
              return false;
          }
      });
    }
    private void car_method()
    {
        car=findViewById(R.id.car);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api_search_method("Car");
            }
        });
    }
    private void triending_method()
    {
        triending=findViewById(R.id.trending);
        triending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api_search_method("Trending");
            }
        });
    }
    private void nature_method()
    {
        nature=findViewById(R.id.nuture);
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api_search_method("Nature");
            }
        });
    }
    private void train_method()
    {
        train=findViewById(R.id.train);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api_search_method("Train");
            }
        });
    }
    private void bus_method()
    {
        bus=findViewById(R.id.bus);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api_search_method("Bus");
            }
        });
    }
    private void get_api_data_method()
    {

        Api api= retrofit.getapi();
        Call<searchmodel> call=api.getdata(1,88);
         call.enqueue(new Callback<searchmodel>() {
             @Override
             public void onResponse(Call<searchmodel> call, Response<searchmodel> response) {

                 if (response.isSuccessful())
                 {
                     arrayList.addAll(response.body().getPhotos());
                     adapter.notifyDataSetChanged();
                 }
             }

             @Override
             public void onFailure(Call<searchmodel> call, Throwable t) {

             }
         });
    }
    private void api_search_method(String query)
    {

        Api api= retrofit.getapi();
        Call <searchmodel> search=api.search(query,1,88);
        search.enqueue(new Callback<searchmodel>() {
            @Override
            public void onResponse(Call<searchmodel> call, Response<searchmodel> response) {
                arrayList.clear();
                if (response.isSuccessful())
                {
                    arrayList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<searchmodel> call, Throwable t) {

            }
        });

    }
}