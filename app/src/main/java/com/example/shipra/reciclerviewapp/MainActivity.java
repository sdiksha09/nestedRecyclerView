package com.example.shipra.reciclerviewapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<listProvider> arrayList = new ArrayList<listProvider>();
    String[] language={"header"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.programmingList);


        layoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
       // layoutManager = new LinearLayoutManager(this);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
      //  recyclerView.setNestedScrollingEnabled(true);






       // recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager( context,LinearLayoutManager.VERTICAL, false));


        recyclerView.setHasFixedSize(true);

        language = getResources().getStringArray(R.array.languages);
        int count = 0;

        for (String NAME : language) {
            listProvider listProvider = new listProvider(NAME);
            arrayList.add(listProvider);
            count++;


            adapter = new programmingAdapter(arrayList);
            recyclerView.setAdapter(adapter);

            // innerItem();
        }
    }
}




/*public void innerItem()

{

    RecyclerView itemList= (RecyclerView) findViewById(R.id.recycler_view_list);
    itemList.setLayoutManager(new LinearLayoutManager(this));

    String[] item={"c","c++","java","python","ruby","java script","php",".net","c#","kotlin"};

    itemList.setAdapter(new SingleItemAdapter(item));


}

       // programminglist.setLayoutManager(new LinearLayoutManager(this));
       // String[] languages={"c","c++","java","c#","python","kotlin","ruby",".net","javaScript","php"};
       // programminglist.setAdapter(new programmingAdapter(languages));




}
*/