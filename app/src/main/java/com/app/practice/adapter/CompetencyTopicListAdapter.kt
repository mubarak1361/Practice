package com.app.practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.practice.databinding.ListItemBinding
import com.app.practice.model.CompetencyTopic

class CompetencyTopicListAdapter(val topics: List<CompetencyTopic>): RecyclerView.Adapter<CompetencyTopicListAdapter.CompetencyTopicViewHolder>() {

    class CompetencyTopicViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(topic: CompetencyTopic) {
            setItemExpand(topic)

            binding.root.setOnClickListener{
                setItemExpand(topic)

            }
            binding.topic = topic
            binding.executePendingBindings()
        }

        private fun setItemExpand(topic: CompetencyTopic){
            if(!topic.expand){
                topic.expand = true
                binding.groupDetail.visibility = View.GONE
                binding.imageDropDown.animate().rotation(270f).setDuration(500).start()
            }else{
                topic.expand = false
                binding.groupDetail.visibility = View.VISIBLE
                binding.imageDropDown.animate().rotation(360f).setDuration(500).start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetencyTopicViewHolder {
        return CompetencyTopicViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: CompetencyTopicViewHolder, position: Int) {
        holder.bind(topics[position])
    }
}