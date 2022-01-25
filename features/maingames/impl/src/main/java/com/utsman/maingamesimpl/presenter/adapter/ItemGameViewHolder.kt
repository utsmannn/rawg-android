package com.utsman.maingamesimpl.presenter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utsman.maingamesimpl.R
import com.utsman.rawg.core.findImageView
import com.utsman.rawg.core.findTextView
import com.utsman.rawg.maingameapi.data.local.GamesDto

class ItemGameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(gamesDto: GamesDto) = itemView.run {
        val imageBg = findImageView(R.id.img_bg)
        val nameItem = findTextView(R.id.tv_name)

        nameItem.text = gamesDto.name
        Glide.with(imageBg.context)
            .load(gamesDto.backgroundImage)
            .into(imageBg)
    }
}