package com.example.navigationcomponentexample.fragments


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
import kotlinx.android.synthetic.main.fragment_first_step.*

/**
 * A simple [Fragment] subclass.
 */
class FirstStepFragment : Fragment(R.layout.fragment_first_step) {
    val navController by lazy { findNavController(activity!!, R.id.nav_controller) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()){
                val bundle = bundleOf("username" to editText.text.toString())
                navController?.navigate(R.id.action_firstStepFragment_to_secondStepFragment, bundle)
            }
        }
        // or you can create an onclick listener directly
        //  nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_firstStepFragment_to_secondStepFragment))


    }

}
