package com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases

import com.jetapptech.InAlpha.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }


}