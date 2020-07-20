package com.example.bookwala;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout,null);
        ProductViewHolder holder = new ProductViewHolder(view);
                return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewSubject.setText(product.getSubject());
        holder.textViewPublication.setText(product.getPublication());
        holder.textViewYear.setText(String.valueOf(product.getYear()));
        holder.textViewSemester.setText(String.valueOf(product.getSemester()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage(),null));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewSemester,textViewSubject,textViewPublication,textViewYear,textViewPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewPublication = itemView.findViewById(R.id.textViewPublication);
            textViewYear = itemView.findViewById(R.id.textViewYear);
            textViewSemester = itemView.findViewById(R.id.textViewSemester);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
