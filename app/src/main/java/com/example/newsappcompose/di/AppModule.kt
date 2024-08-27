package com.example.newsappcompose.di

import com.example.newsappcompose.data.AppConstant
import com.example.newsappcompose.data.api.ApiInterface
import com.example.newsappcompose.data.datasource.NewsDataSource
import com.example.newsappcompose.data.datasource.NewsDataSourceImpl
import com.example.newsappcompose.ui.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    fun providerRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }
        httpClient.apply {
            readTimeout(30, TimeUnit.SECONDS)
        }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(AppConstant.APP_BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providerNewsSource(apiInterface: ApiInterface) : NewsDataSource {
        return NewsDataSourceImpl(apiInterface)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(newsDataSource: NewsDataSource) : NewsRepository {
        return NewsRepository(newsDataSource)
    }


}