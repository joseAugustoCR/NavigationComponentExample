package com.example.navigationcomponentexample.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.models.FeedItem
import kotlinx.android.synthetic.main.fragment_feed.*

/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment(R.layout.fragment_feed), FeedAdapter.Interaction {
    override fun onItemSelected(position: Int, item: FeedItem) {
        val bundle = bundleOf("title" to item.title)
        navController.navigate(R.id.action_feedFragment_to_feedDetailFragment, bundle)
    }

    //get the current navController (nested nav controller)
//    val navController by lazy { findNavController(activity!!, R.id.fragment) }
    val navController by lazy { findNavController(view!!) }
    //get the main navController
    val mainNavController by lazy { findNavController(activity!!, R.id.nav_controller) }
    lateinit var feedAdapter:FeedAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backToWelcomeBtn.setOnClickListener {
            mainNavController.navigateUp()
        }

        setupRecycler()
        populateRecycler()
    }



    fun setupRecycler(){
        feedAdapter = FeedAdapter(this)
        recycler.apply {
            setHasFixedSize(true)
            adapter = feedAdapter
        }
    }

    fun populateRecycler(){
        var items = ArrayList<FeedItem>()
        for (i in 0..20){
            items.add(FeedItem(i, "Post $i"))
        }
        feedAdapter.submitList(items)

    }


}
