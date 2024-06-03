package com.sharkdroid.medhavicollege.presentation.home.components

import androidx.lifecycle.ViewModel
import com.sharkdroid.medhavicollege.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollegePhotoSliderViewModel @Inject constructor() :ViewModel() {


        val imageList: List<Int> = listOf(
            R.drawable.medhaviconvocation,
            R.drawable.medhavifront,
            R.drawable.mou,
            R.drawable.medhavi_playground,
        )






}