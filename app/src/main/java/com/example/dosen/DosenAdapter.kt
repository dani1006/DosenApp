package com.example.dosen

import android.app.Activity
import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DosenAdapter(private val listDosen : ArrayList<Dosen>) : RecyclerView.Adapter<DosenAdapter.CardViewHolder>()  {
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNIP: TextView = itemView.findViewById(R.id.tv_item_nip)
        var tvKeahlian: TextView = itemView.findViewById(R.id.tv_item_keahlian)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_dosen, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dosen = listDosen[position]

        Glide.with(holder.itemView.context)
            .load(dosen.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = dosen.name
        holder.tvNIP.text = dosen.nip
        holder.tvKeahlian.text = dosen.keahlian

        holder.itemView.setOnClickListener (View.OnClickListener {
                val activity = holder.itemView.context as Activity
                val detail = Intent(activity, Detail::class.java)
                detail.putExtra(Detail.EXTRA_PHOTO, dosen.photo)
                detail.putExtra(Detail.EXTRA_NAME, dosen.name)
                detail.putExtra(Detail.EXTRA_NIP, dosen.nip)
                detail.putExtra(Detail.EXTRA_KEAHLIAN, dosen.keahlian)
                activity.startActivity(detail)
            })
    }


        override fun getItemCount(): Int {
            return listDosen.size
        }
    }