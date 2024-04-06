package com.example.androidlab2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.androidlab2.adapter.CelebrityAdapter
import com.example.androidlab2.databinding.FragmentCelebrityListBinding
import com.example.androidlab2.model.Celebrity
import com.example.androidlab2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CelebrityListFragment : Fragment() {
    companion object {
        fun newInstance() = CelebrityListFragment()
    }

    private var _binding: FragmentCelebrityListBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView

    private val adapter by lazy { CelebrityAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCelebrityListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        searchView = binding.search
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { fetchCelebrityByName(it) }
                return false
            }
        })



    }
    private fun setupUI() {
        with(binding) {
            catList.adapter = this@CelebrityListFragment.adapter
        }
    }



    private fun fetchCelebrityByName(query: String) {
        ApiClient.instance.fetchCelebrity(query).enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(call: Call<List<Celebrity>>, response: Response<List<Celebrity>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        adapter.submitList(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
            }
        })
    }
    private fun fetchCelebrityByGender(gender : String?) {
        ApiClient.instance.fetchCelebrity("", gender).enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(call: Call<List<Celebrity>>, response: Response<List<Celebrity>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        adapter.submitList(it)
                    }
                }
            }
            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
            }
        })
    }
}







