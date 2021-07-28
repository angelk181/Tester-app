package com.example.studentbeanstest.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.studentbeanstest.R
import com.example.studentbeanstest.databinding.FragmentLoginBinding
import com.example.studentbeanstest.util.LogInHandler
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


/**
 * constructor used to inflate layout without using onCreateView
 * Login Handler for log in button
 * nav graph sorts out navigation
 */
@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login), LogInHandler {

    lateinit var binding: FragmentLoginBinding

    var navController: NavController? = null

    private val viewModel by  viewModels<LoginViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root



    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = Navigation.findNavController(view)

        // Setting binding params
        binding.viewModel = viewModel
        binding.handler = this


        // Watching for login result
        viewModel.getLogInResult().observe(viewLifecycleOwner) { result ->
            Toast.makeText(this@LoginFragment.requireActivity(), result, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onLogInClicked() {
     if (viewModel.loginValidation()) {
         navController!!.navigate(R.id.action_loginFragment_to_imageList)
     }

    }
}




