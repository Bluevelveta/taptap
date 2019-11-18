package com.example.taptap

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.taptap.databinding.ScoreFragmentBinding


class scoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater,
            R.layout.score_fragment,container,false)


        viewModelFactory = ScoreViewModelFactory(scoreFragmentArgs.fromBundle(arguments!!).score,scoreFragmentArgs.fromBundle(arguments!!).name)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)

        viewModel.eventTaptap.observe(this,Observer<Boolean>{
            if(it){
                replay()
            }
        })
        viewModel.eventPost.observe(this,Observer<Boolean>{
            if (it){
                shareSuccess()
                viewModel.onPostinComplete()
            }
        })

        Toast.makeText(context, "คุณได้คะแนน: ${viewModel.score.value} คะแนน", Toast.LENGTH_LONG).show()

        binding.lifecycleOwner = this
        binding.scoreViewModel = viewModel
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val args = scoreFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.shareText, args.score))
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    fun replay(){
        val action = scoreFragmentDirections.actionScoreFragmentToGameFragment(viewModel.nameString)
        NavHostFragment.findNavController(this).navigate(action)
    }
}
