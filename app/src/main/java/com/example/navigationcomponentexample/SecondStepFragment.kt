package com.example.navigationcomponentexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second_step.*

/**
 * A simple [Fragment] subclass.
 */
class SecondStepFragment : Fragment() {
    var navController: NavController? = null
    lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments?.getString("username").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()) {
                val bundle = bundleOf(
                    "username" to username,
                    "description" to editText.text.toString()
                    )
                navController?.navigate(R.id.action_secondStepFragment_to_thirdFragment, bundle)
            }
        }

        titleText.text = "Hi, $username!\nThis is just a navigation component example. Tell me what's on your mind?"
    }

}
