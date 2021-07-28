package com.example.studentbeanstest.ui

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.studentbeanstest.R
import com.example.studentbeanstest.databinding.FragmentImageListBinding
import com.example.studentbeanstest.util.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * android entry point for dagger/hilt injection
 */
@AndroidEntryPoint
class ImageList: Fragment(R.layout.fragment_image_list) {

    private val viewModel by  viewModels<ImageListViewModel>()


    private var _binding: FragmentImageListBinding? = null
    //only valid in onCreateView and onDestroy
    private val binding get() = _binding!!

    // kills application through back press

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity!!.finishAndRemoveTask()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentImageListBinding.bind(view)

        val adapter = ImageAdapter()


        //sets up recycler view

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        // recycler adapter observed here as data is passed here
        viewModel.images.observe(viewLifecycleOwner){


            adapter.setImageList(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}