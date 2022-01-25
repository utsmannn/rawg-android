package com.utsman.maingamesimpl.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utsman.maingamesimpl.R
import com.utsman.rawg.maingameapi.data.local.GamesDto

class MainGameAdapter : RecyclerView.Adapter<ItemGameViewHolder>() {
    private val _games: MutableList<GamesDto> = mutableListOf()
    private val games: List<GamesDto> = _games

    fun addGame(games: List<GamesDto>) {
        _games.clear()
        _games.addAll(games)
        notifyDataSetChanged()
    }

    fun clearGame() {
        _games.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        return ItemGameViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemGameViewHolder, position: Int) {
        val item = games[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return games.size
    }
}