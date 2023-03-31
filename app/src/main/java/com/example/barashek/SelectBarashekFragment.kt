package com.example.barashek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barashek.databinding.FragmentSelectBarashekBinding


class SelectBarashekFragment : Fragment() {

    private lateinit var binding: FragmentSelectBarashekBinding
    private lateinit var adapter: BarashekAdapter
    private val list = arrayListOf<Barashek>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectBarashekBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.clear()
        loadData()
        adapter = BarashekAdapter(list, this::onClick)
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
            recyclerView.adapter = adapter
        }
    }

    private fun onClick(position: Int) {
        binding.sendBtn.setOnClickListener {
            val selectedPhotos = adapter.getSelectedPhotos()
            val bundle = Bundle().apply {
                putSerializable(firstFragSecFragImage, ArrayList(selectedPhotos))
            }
            findNavController().navigate(R.id.selectedBarashekFragment, bundle)
        }
    }


    private fun loadData() {
        list.add(Barashek(getString(R.string.barashek1), isSelected = false))
        list.add(Barashek(getString(R.string.barashek2), isSelected = false))
        list.add(Barashek(getString(R.string.barashek3), isSelected = false))
        list.add(Barashek(getString(R.string.barashek4), isSelected = false))
        list.add(Barashek(getString(R.string.barashek5), isSelected = false))
        list.add(Barashek(getString(R.string.barashek6), isSelected = false))
        list.add(Barashek(getString(R.string.barashek7), isSelected = false))
        list.add(Barashek(getString(R.string.barashek8), isSelected = false))
        list.add(Barashek(getString(R.string.barashek9), isSelected = false))
        list.add(Barashek(getString(R.string.barashek4), isSelected = false))
        list.add(Barashek(getString(R.string.barashek5), isSelected = false))
        list.add(Barashek(getString(R.string.barashek6), isSelected = false))
        list.add(Barashek(getString(R.string.barashek7), isSelected = false))
        list.add(Barashek(getString(R.string.barashek8), isSelected = false))
        list.add(Barashek(getString(R.string.barashek9), isSelected = false))
    }

    companion object {
        const val firstFragSecFragImage = "DATA"
    }
}