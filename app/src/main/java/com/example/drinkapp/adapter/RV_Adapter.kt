package com.example.drinkapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.drinkapp.R
import com.example.drinkapp.db.drinksCoctel.Cocktail
import com.example.drinkapp.model.DrinkModel
import com.example.drinkapp.view.DetailFragment
import com.squareup.picasso.Picasso


class RV_Adapter(drinks: List<DrinkModel>) : RecyclerView.Adapter<RV_Adapter.ViewHolder>() {
    private var rvDrink = drinks

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagItem: ImageView = itemView.findViewById(R.id.img_item)
        var nameDrink: TextView = itemView.findViewById(R.id.tv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_drink_rv, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { v ->
            val activity = v?.context as AppCompatActivity
            val bundle = Bundle()
            bundle.putString("id", rvDrink[position].drinkString)
            bundle.putString("img", rvDrink[position].strDrinkThumb)
            val fragment = DetailFragment()
            fragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment,fragment).addToBackStack(null).commit()
        }

        holder.nameDrink.text = rvDrink[position].drinkString
        val picasso = Picasso.get()
        picasso.setIndicatorsEnabled(true)
        picasso.load(rvDrink[position].strDrinkThumb).into(holder.imagItem)
    }

    override fun getItemCount() = rvDrink.size
}