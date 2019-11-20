package com.example.taptap

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.taptap.databinding.ScoreboradFragmentBinding


class scoreboardFragment : Fragment() {


    private lateinit var viewModel: ScoreboardViewModel
    private lateinit var viewModelFactory: ScoreboardModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).scoreDatabaseDao

        viewModelFactory = ScoreboardModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreboardViewModel::class.java)

        val binding = DataBindingUtil.inflate<ScoreboradFragmentBinding>(inflater,
            R.layout.scoreborad_fragment,container,false)

        var adapter = ScoreboardAdapter()
        binding.scoreTable.adapter = adapter

        viewModel.scoreList?.observe(this, Observer {
            adapter.submitList(it)
        })
        Log.i("ScoreboradFragment","ScoreboradFragment on Create")

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ScoreboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
