package com.example.bookstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookstore.adapter.BookResultsAdapter
import com.example.bookstore.databinding.FragmentBooksearchBinding
import com.example.bookstore.viewModel.BookViewModel
import androidx.lifecycle.ViewModelProviders




class BookFragment : Fragment() {

    /**
     *Layout Binding
     */
    private lateinit var binding: FragmentBooksearchBinding

    /**
     * ViewModel
     */
    private val viewModel: BookViewModel by viewModels()

    /**
     * Adapter
     */
    private val adapter = BookResultsAdapter()

    /**
     * OnCreateView
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBooksearchBinding.inflate(inflater, container, false).apply {

            viewModel?.getVolumesResponseLiveData()
                ?.observe(viewLifecycleOwner,
                    { volumesResponse ->
                        if (volumesResponse != null) {
                            adapter.setResults(volumesResponse.items!!)
                        }
                    })
        }
        binding.recyclerView.adapter
        return binding.root
    }

    /**
     * OnViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.btSearch.setOnClickListener {
            val keyword = binding.keyword.editableText.toString()
            val author = binding.author.editableText.toString()
            viewModel.searchVolumes(keyword, author)
        }
    }
}