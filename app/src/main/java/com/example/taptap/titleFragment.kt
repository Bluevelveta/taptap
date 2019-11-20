package com.example.taptap

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taptap.databinding.TitleFragmentBinding
import com.google.android.material.snackbar.Snackbar


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

        binding.logoButton.setOnClickListener{view :View ->
            binding.apply {
                Snackbar.make(view, "Taptap!!! version 1.0.0.1", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
        setHasOptionsMenu(true)

        Log.i("TitleFragment","Title on Create")

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
