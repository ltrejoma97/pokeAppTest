package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.presentation.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//As long the app is living this object would be living  that is
//the translate of this annotation
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Singleton
//    @Provides
//    fun provideApplication(@ApplicationContext app : Context) : MainApplication {
//        return app as MainApplication
//    }
//
//    @Singleton
//    @Provides
//    fun provideRandomString(): String{
//        return "Hey look a tramdom Streing asfdasd"
//    }
//
//}