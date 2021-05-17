package com.example.roadmapp.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roadmapp.R
import com.example.roadmapp.databinding.SettingsFragmentBinding


class SettingsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate binding
        val binding: SettingsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.settings_fragment, container, false)

        // Return layout
        return binding.root
    }
}
