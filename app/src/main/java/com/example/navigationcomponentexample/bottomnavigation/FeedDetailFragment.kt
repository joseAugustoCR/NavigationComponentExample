package com.example.navigationcomponentexample.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

import com.example.navigationcomponentexample.R

/**
 * A simple [Fragment] subclass.
 */
class FeedDetailFragment : Fragment(R.layout.fragment_feed_detail) {
    val navController by lazy { findNavController(view!!) }





}
