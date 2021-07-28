package com.example.studentbeanstest.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.studentbeanstest.data.ImageResults
import com.example.studentbeanstest.databinding.ItemImageBinding

/**
 * adapter class to popululate recycler view
 */
class ImageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var images = mutableListOf<ImageResults>()

        fun setImageList(images: List<ImageResults>) {
            this.images = images.toMutableList()
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val binding =
                ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ImageViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder) {
                is ImageViewHolder -> {
                    holder.bind(images[position])
                }

            }
        }

        override fun getItemCount(): Int {
            return images.size
        }

        class ImageViewHolder
        constructor(
            private val binding: ItemImageBinding
        ): RecyclerView.ViewHolder(binding.root){


            fun bind(images: ImageResults){

                binding.apply {

                    val title = titleView
                    val imageView = imageView



                   val imageLink = images.thumbnailUrl
                    imageView.load(imageLink){
                        crossfade(true)
                        crossfade(1000)

                    }
                    title.text = images.title

                }



            }

        }

    }
