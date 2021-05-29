package com.simgesengun.foodapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.simgesengun.foodapplication.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var design : FragmentDetailsBinding
    private lateinit var viewModel: HomepageViewModel
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        design.detail = this

        // Bundle
        val bundle : DetailsFragmentArgs by navArgs()
        val item = bundle.item

        design.item = item

        val url = ApiUtils.BASE_URL + "yemekler/resimler/" +item.yemek_resim_adi
        val image = design.imageView
        Picasso.get().load(url).into(image)

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}