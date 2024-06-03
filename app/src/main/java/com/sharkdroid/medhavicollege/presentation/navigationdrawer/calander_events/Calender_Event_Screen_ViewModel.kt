package com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.components.EventItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalenderEventScreenViewModel @Inject constructor():ViewModel(){


  private  val _eventItem= mutableStateOf<List<EventItem>>(emptyList())
    val eventItem:State<List<EventItem>> =_eventItem

    init {

        viewModelScope.launch {
            _eventItem.value= listOf(

             EventItem("First Term Exam","7 Jun 2024"),
            EventItem("Bhanu Bhakta Jyanti","13 Jul 2024"),
                EventItem("Teachers Day","21 Jul 2024"),
                EventItem("Raksha Bandhan","19 Aug 2024"),
                EventItem("Constitution Day","19 Sep 2024")

            )
        }
    }

}