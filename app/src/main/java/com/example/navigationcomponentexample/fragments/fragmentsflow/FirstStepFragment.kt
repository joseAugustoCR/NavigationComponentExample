package com.example.navigationcomponentexample.fragments.fragmentsflow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation.findNavController
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.fragments.FirstStepFragmentDirections
import kotlinx.android.synthetic.main.fragment_first_step.*

/**
 * A simple [Fragment] subclass.
 */
class FirstStepFragment : Fragment(R.layout.fragment_first_step) {
    val navController by lazy { findNavController(activity!!, R.id.nav_host_fragment) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()){
                navController?.navigate(
                    FirstStepFragmentDirections.actionFirstStepFragmentToSecondStepFragment(
                        editText.text.toString()
                    )
                )
            }
        }
        // or you can create an onclick listener directly
        //  nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_firstStepFragment_to_secondStepFragment))


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
