package com.sharkdroid.medhavicollege.presentation.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.news.components.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {

    private val _newsItems = mutableStateOf<List<NewsItem>>(emptyList())
    val newsItems: State<List<NewsItem>> = _newsItems


    init {

        viewModelScope.launch {
            _newsItems.value = listOf(
                NewsItem(
                    R.drawable.admissionopen,
                    "Admission Open for BCSIT, BBA, BHA Programs",
                    "Enroll now in our BCSIT, BBA, and BHA programs! Apply today to start your journey toward a successful career."
                ),
                NewsItem(
                    R.drawable.workshop_canva,
                    "Master Canva: Hands-On Workshop for Professional Design",
                    "A Canva workshop is a hands-on training session where participants learn to use Canva for creating professional designs, including social media posts, presentations, and flyers. The workshop covers basics, template usage, and customization techniques."
                ),
                NewsItem(
                    R.drawable.congratulation,
                    "Congratulations on Your +2 Achievement!",
                    "Congratulations on completing your +2! Your hard work and dedication have paid off, paving the way for exciting new opportunities. Wishing you continued success in all your future endeavors!"
                ),
                NewsItem(
                    R.drawable.chhath_puja,
                    "Chhath Puja: Honoring the Sun God and Nature's Harmony",
                    "Chhath Puja is a Hindu festival dedicated to worshiping the Sun God and Chhathi Maiya, observed with fasting, prayers, and offerings near water bodies."
                ),
                NewsItem(
                    R.drawable.library,
                    "Exploring Knowledge: The Library's Gateway",
                    "A library is a place where you can access books and resources for learning and research."
                ),

                )
        }


    }


}