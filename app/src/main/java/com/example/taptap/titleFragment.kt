package com.example.taptap

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.taptap.databinding.TitleFragmentBinding


class titleFragment : Fragment() {


    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater,
            R.layout.title_fragment,container,false)

        binding.playButton.setOnClickListener { view : View ->
            binding.apply {
                if(playerName.text.toString() != ""){
                    view.findNavController().navigate(titleFragmentDirections.actionTitleFragmentToGameFragment(playerName.text.toString()))
                }
            }
        }

        binding.scoreButton.setOnClickListener { view : View ->
            binding.apply {
                view.findNavController().navigate(R.id.action_titleFragment_to_scoreboradFragment)
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
