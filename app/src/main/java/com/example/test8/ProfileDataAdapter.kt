package com.example.test8

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.test8.databinding.ItemListBinding

class ProfileDataAdapter(private var profileDataList: List<ProfileData>) : RecyclerView.Adapter<ProfileDataAdapter.AdapterViewHolder>() {

    open class AdapterViewHolder(var binding: ItemListBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        holder.binding.txtFullName.text = profileDataList[position].fullName
        holder.binding.txtDepartment.text = profileDataList[position].department

        Glide
            .with(holder.itemView.context)
            .load("https://cdn.webtekno.com/media/cache/content_detail_v2/article/29121/android-kotlin-1495097437.jpg")
            .into(holder.binding.imgProfilePhoto)

        val clickable = holder.itemView.findViewById<LinearLayout>(R.id.clickable)
        clickable.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Click", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return profileDataList.size
    }


}