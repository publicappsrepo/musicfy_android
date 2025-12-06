/*
 * Copyright (c) 2024 Christians Martínez Alvarado
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.play_pause.musicplayer.fragments.about

import android.content.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.play_pause.musicplayer.BuildConfig
import com.play_pause.musicplayer.R
import com.play_pause.musicplayer.databinding.FragmentAboutBinding
import com.play_pause.musicplayer.dialogs.MarkdownDialog
import com.play_pause.musicplayer.extensions.MIME_TYPE_PLAIN_TEXT
import com.play_pause.musicplayer.extensions.applyBottomWindowInsets
import com.play_pause.musicplayer.extensions.openWeb
import com.play_pause.musicplayer.extensions.showToast
import com.play_pause.musicplayer.model.DeviceInfo

/**
 * @author Christians M. A. (mardous)
 */
class AboutFragment : Fragment(R.layout.fragment_about), View.OnClickListener {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    private lateinit var deviceInfo: DeviceInfo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        deviceInfo = DeviceInfo(requireActivity())
        _binding = FragmentAboutBinding.bind(view)
        view.applyBottomWindowInsets()
        setupVersion()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupVersion() {
        binding.cardApp.version.text = BuildConfig.VERSION_NAME
    }

    private fun setupListeners() {
        binding.cardApp.privacyPolicy.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.cardApp.privacyPolicy -> {
                openUrl("https://sites.google.com/view/musicfyprivacypolicy/home")
            }
        }
    }

    private fun openUrl(url: String) {
        startActivity(url.openWeb())
    }
}