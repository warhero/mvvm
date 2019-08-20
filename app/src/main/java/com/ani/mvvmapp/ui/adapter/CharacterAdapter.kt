package com.ani.mvvmapp.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ani.mvvmapp.R
import com.ani.mvvmapp.ui.model.UiModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_character.view.*


class CharacterAdapter(
    private val list: List<UiModel>
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        Glide.with(holder.image).load(item.url).into(holder.image)
        holder.name.text = item.name
        holder.place.text = item.place
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val name = mView.tvName
        val place = mView.tvLocation
        val image: ImageView = mView.imgPlaces
    }
}
