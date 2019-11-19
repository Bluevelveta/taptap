package com.example.taptap



import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.taptap.databinding.ScoreRowBinding


class ScoreboardAdapter() : ListAdapter<Score,

        ScoreboardAdapter.ScoreViewHolder>(DiffCallback) {



    override fun getItemViewType(position: Int): Int {

        return position

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {

        val binding =

            ScoreRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ScoreViewHolder(binding)

    }



    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {

        val score = getItem(position)

        holder.bind(score)

    }



    companion object DiffCallback : DiffUtil.ItemCallback<Score>() {

        override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {

            return oldItem === newItem

        }



        override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {

            return oldItem.scoreId == newItem.scoreId

        }

    }



    class ScoreViewHolder(private var binding:

                          ScoreRowBinding):

        RecyclerView.ViewHolder(binding.root) {



        fun bind(score: Score) {

            binding.scoreData = score

            binding.executePendingBindings()

        }

    }

}