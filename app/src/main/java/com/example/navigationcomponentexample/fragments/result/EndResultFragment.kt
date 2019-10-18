package com.example.navigationcomponentexample.fragments.result


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_end_result.*

/**
 * A simple [Fragment] subclass.
 */
class EndResultFragment : Fragment(R.layout.fragment_end_result) {
    val navController by lazy { Navigation.findNavController(view!!) }
    val args: EndResultFragmentArgs by navArgs()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()){
                args.callback.setResult(editText.text.toString().toInt())
                navController.navigate(EndResultFragmentDirections.actionEndResultFragmentToStartResultFragment())
            }
        }
    }

}
