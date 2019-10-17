package com.example.navigationcomponentexample.fragments.result


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.Navigation

import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.fragments.StartResultFragmentDirections
import com.example.navigationcomponentexample.utils.NavigationResult
import kotlinx.android.synthetic.main.fragment_start_result.*

/**
 * A simple [Fragment] subclass.
 */
class StartResultFragment : Fragment(R.layout.fragment_start_result), NavigationResult{
    val navController by lazy { Navigation.findNavController(view!!) }

    override fun setResult(result: Int) {
        Toast.makeText(activity as Context, result.toString(), Toast.LENGTH_SHORT).show()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        nextBtn.setOnClickListener {
            navController.navigate(
                StartResultFragmentDirections.actionStartResultFragmentToEndResultFragment(
                    this
                )
            )
        }
    }

}
