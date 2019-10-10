package com.example.navigationcomponentexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_first_step.*

/**
 * A simple [Fragment] subclass.
 */
class FirstStepFragment : Fragment() {
    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

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
