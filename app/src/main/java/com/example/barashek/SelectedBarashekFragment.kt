
package com.example.barashek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barashek.databinding.FragmentSelectedBarashekBinding

class SelectedBarashekFragment : Fragment() {

    private lateinit var binding: FragmentSelectedBarashekBinding
    private val items = arrayListOf<Barashek>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedBarashekBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedPhotos = arguments?.getSerializable(SelectBarashekFragment.firstFragSecFragImage) as? ArrayList<Barashek>
        if (selectedPhotos.isNullOrEmpty()) {
            binding.recyclerView.visibility = View.GONE
        } else {
            items.addAll(selectedPhotos)
            val adapter = SelectedBarashekAdapter(items)
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                this.adapter = adapter
            }
        }
    }
}