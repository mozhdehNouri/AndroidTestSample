package com.example.androidtestsample.api

import android.content.Context
import androidx.room.Room
import com.example.androidtestsample.roomdatabase.ShopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ShoppModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ShopDatabase::class.java,
            "Shopp_data_base"
        ).build()

    @Provides
    @Singleton
    fun provideDao(database: ShopDatabase) = database.shoppDao()


    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
//        .addConverterFactory(Json.asConverterFactory("application/json".))
        .baseUrl("https://jsonplaceholder.typicode.com/").build()


    @Provides
    @Singleton
    fun provideShoppApi(retrofit: Retrofit) =
        retrofit.create(ShoppApi::class.java)
}