package com.ani.mvvmapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ani.mvvmapp.R
import com.ani.mvvmapp.ui.adapter.CharacterAdapter
import com.ani.mvvmapp.ui.model.UiModel
import com.ani.mvvmapp.ui.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterFragment : Fragment() {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner, Observer { updateViews(it) })
    }

    private fun updateViews(list: List<UiModel>) {
        rvCharacter.apply {
            setHasFixedSize(true)
            adapter = CharacterAdapter(list)
        }
    }
}
