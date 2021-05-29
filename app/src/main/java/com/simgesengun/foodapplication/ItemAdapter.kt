package com.simgesengun.foodapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.foodapplication.databinding.CardDesignBinding
import com.squareup.picasso.Picasso

class ItemAdapter (var mContext : Context, var itemList : List<Item>, var viewModel:HomepageViewModel) : RecyclerView.Adapter<ItemAdapter.ItemCardDesignHolder>() {

    inner class ItemCardDesignHolder(itemCardDesignBinding: CardDesignBinding) : RecyclerView.ViewHolder(itemCardDesignBinding.root){
        var design : CardDesignBinding

        init {
            this.design = itemCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)

        return ItemCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: ItemCardDesignHolder, position: Int) {
        val item = itemList.get(position)
        val url = ApiUtils.BASE_URL + "yemekler/resimler/" +item.yemek_resim_adi

        holder.design.item = item

        val image = holder.design.imageViewCard

        Picasso.get().load(url).into(image)
        holder.design.cardView.setOnClickListener {
            val nav = HomepageFragmentDirections.toDetails(item)
            Navigation.findNavController(it).navigate(nav)
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}