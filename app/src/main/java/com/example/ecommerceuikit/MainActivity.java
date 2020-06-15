package com.example.ecommerceuikit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView btnBack, btnSearch, btnProfile;
    RelativeLayout payment_btn;
    ArrayList<ProductItem> productItems;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    TextView total_price;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initData();
        setStuff();
        clickButtons();
        setAdapter();
    }

    private void setAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(MainActivity.this, productItems);
        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(productAdapter);
    }

    private void initData() {
        productItems = new ArrayList<>();
        productItems.add(new ProductItem(543534, "I'm Happy Printed Short", "Purple", "M", R.drawable.item1, 56));
        productItems.add(new ProductItem(678463, "V-Neck Short Sleeve T-Shirt", "White", "S", R.drawable.item2, 42));
        productItems.add(new ProductItem(879678, "Short Sleeve T-shirt", "Hake", "L", R.drawable.item3, 48));
        productItems.add(new ProductItem(546588, "Basic Short Sleeve T-Shirt", "Black", "S", R.drawable.item4, 56));
        productItems.add(new ProductItem(976546, "Mickey & Minnie Printed Short Sleeve T-Shirt", "Grey", "M", R.drawable.item5, 82));
    }

    private void setStuff() {
        btnBack = findViewById(R.id.btnBack);
        btnSearch = findViewById(R.id.btnSearch);
        btnProfile = findViewById(R.id.btnProfile);
        payment_btn = findViewById(R.id.payment_btn);
        total_price = findViewById(R.id.total_price);
        writePrice();
    }

    private void writePrice() {
        float price = 0;
        for (int i = 0; i <= productItems.size() - 1; i++) {
            price += productItems.get(i).getPrice();
            Log.e("TAG", "setStuff: " + i);
        }
        total_price.setText("₺" + price);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            productItems.remove(viewHolder.getAdapterPosition());
            productAdapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "dsadasd" + productItems.size(), Toast.LENGTH_SHORT).show();
            writePrice();
        }
    };

    private void clickButtons() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search Button", Toast.LENGTH_SHORT).show();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Profile Button", Toast.LENGTH_SHORT).show();
            }
        });

        payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Payment Button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}