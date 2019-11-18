package com.example.taptap

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.taptap.databinding.GameFragmentBinding


class gameFragment : Fragment() {

    companion object {
        fun newInstance() = gameFragment()
    }

    private lateinit var viewModel: GameViewModel
    var count = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(inflater,
                R.layout.game_fragment,container,false)


        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        binding.lifecycleOwner = this
        binding.gameViewModel = viewModel
        return binding.root

    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
