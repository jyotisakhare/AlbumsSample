package com.jyoti.albumssample.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jyoti.albumssample.R
import com.jyoti.albumssample.adapter.AlbumRecyclerViewAdapter
import com.jyoti.albumssample.databinding.AlbumListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlbumListFragment : Fragment() {

    companion object {
        fun newInstance() = AlbumListFragment()
    }

    private var binding: AlbumListFragmentBinding? = null
    private lateinit var viewModel: AlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.album_list_fragment, container, false)
        viewModel = ViewModelProvider(this)[AlbumViewModel::class.java]
        viewModel.loadAlbums()
        viewModel.albums.observe( viewLifecycleOwner) { result ->
            binding?.rlAlbumList?.layoutManager = LinearLayoutManager(activity)
            val sortedList = result.sortedWith(Comparator { o1, o2 ->  o1.title.compareTo(o2.title)})
            binding?.rlAlbumList?.adapter = AlbumRecyclerViewAdapter(sortedList, activity)
        }
        return binding?.root
    }


}