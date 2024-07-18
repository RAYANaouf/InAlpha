package com.jetapptech.InAlpha.domain.usecases.appEntryUseCases

import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases.ReadAppEntry
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases.SaveAppEntry
import javax.inject.Inject

data class AppEntryUseCases constructor(
    val saveAppEntry: SaveAppEntry,
    val readAppEntry: ReadAppEntry
)