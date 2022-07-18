package com.example.drinkapp.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.drinkapp.R

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val mBundle: String? = arguments?.getString("id")
        val mBundleImg: String? = arguments?.getString("img")
            Log.d("fddg",mBundle.toString())
//        val query = ApiClient.getInstance().create(ApiInterface::class.java)
//
//        CoroutineScope(Dispatchers.Main).launch {
//            Picasso.get().load(mBundleImg).into(imgDetail)
//            val text = query.getDetail(mBundle.toString()).body()?.drinks.toString()
//            val a = text.substring(1, text.length - 1).replace(",", "\n")
//                .replace("(", "\n")
//                .replace(")", "\n")
//                .replace("DrinkDetail", "")
//            tv_Detail.text = a
//        }
        setHasOptionsMenu(false)
        return view
    }

}