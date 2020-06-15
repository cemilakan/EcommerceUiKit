package com.example.ecommerceuikit;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private ArrayList<ProductItem> productItemArrayList;

    public ProductAdapter(Context context, ArrayList<ProductItem> productArrayList) {
        this.context = context;
        this.productItemArrayList = productArrayList;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public ImageView product_image;
        public ConstraintLayout product_parent;
        public TextView product_name,product_price,product_color,product_size;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=itemView.findViewById(R.id.product_name);
            product_price=itemView.findViewById(R.id.product_price);
            product_color=itemView.findViewById(R.id.product_color);
            product_size=itemView.findViewById(R.id.product_size);
            product_image=itemView.findViewById(R.id.product_image);
            product_parent=itemView.findViewById(R.id.product_parent);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        holder.product_name.setText(productItemArrayList.get(position).getTitle());
        holder.product_price.setText("₺" + productItemArrayList.get(position).getPrice());
        holder.product_color.setText(productItemArrayList.get(position).getColor());
        holder.product_size.setText("Size: " + productItemArrayList.get(position).getSize());
        holder.product_image.setBackgroundResource(productItemArrayList.get(position).getImage());
        holder.product_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, productItemArrayList.get(position).getId() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productItemArrayList.size();
    }
}
