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
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.taptap.databinding.GameFragmentBinding


class gameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory
    var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GameFragmentBinding>(
            inflater,
            R.layout.game_fragment, container, false
        )

        viewModelFactory = GameViewModelFactory(gameFragmentArgs.fromBundle(arguments!!).name)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GameViewModel::class.java)
        //viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)


        viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished)
                view?.findNavController()?.
                    navigate(
                        gameFragmentDirections.
                            actionGameFragmentToScoreFragment(viewModel.name,viewModel.score.value?:0))

        })

        binding.lifecycleOwner = this
        binding.gameViewModel = viewModel

        Log.i("GameFragment","GameFragment on Create")
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        // TODO: Use the ViewModel
    }



}