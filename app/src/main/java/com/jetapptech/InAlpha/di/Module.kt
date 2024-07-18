package com.jetapptech.InAlpha.di

import android.app.Application
import com.jetapptech.InAlpha.data.manager.LocalUserManagerImp
import com.jetapptech.InAlpha.domain.manager.LocalUserManager
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.AppEntryUseCases
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases.ReadAppEntry
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.useCases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImp(context = application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases = AppEntryUseCases( saveAppEntry = SaveAppEntry(localUserManager) , readAppEntry = ReadAppEntry(localUserManager))

}