package com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.AppEntryUseCases
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.data.events.Events
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {



    fun onEvent(
        event : Events
    ){
        when(event){
            is Events.saveAppEntryEvent -> {
                saveAppEntry()
            }

        }
    }



    private fun saveAppEntry(){
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }

}