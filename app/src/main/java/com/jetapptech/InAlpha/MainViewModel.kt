package com.jetapptech.InAlpha

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.AppEntryUseCases
import com.jetapptech.InAlpha.presentation.nvgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUseCases: AppEntryUseCases,
    context         : Application
) : ViewModel() {


    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Routes.HomeScreen.routes)
        private set


    init{

        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen->
            if (!shouldStartFromHomeScreen){
                startDestination = Routes.OnBoardingScreen.routes
            }
            else{
                startDestination = Routes.HomeScreen.routes
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)

    }


}