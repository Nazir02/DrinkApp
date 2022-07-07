package com.example.drinkapp.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.drinkapp.R
import com.example.drinkapp.db.details.detail
import com.example.drinkapp.model.ApiClient
import com.example.drinkapp.model.ApiInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val mBundle: String? = arguments?.getString("id")
        val mBundleImg: String? = arguments?.getString("img")
        val query = ApiClient.getInstance().create(ApiInterface::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            Picasso.get().load(mBundleImg).into(imgDetail)
            val text = query.getDetail(mBundle.toString()).body()?.drinks.toString()
            val a = text.substring(1, text.length - 1).replace(",", "\n")
                .replace("(", "\n")
                .replace(")", "\n")
                .replace("DrinkDetail", "")
            tv_Detail.text = a
        }
        setHasOptionsMenu(false)
        return view
    }

}