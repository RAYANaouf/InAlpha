package com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases

import com.jetapptech.InAlpha.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

}