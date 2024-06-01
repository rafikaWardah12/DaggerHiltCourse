package com.example.daggerhiltcourse.data.di

import android.app.Application
import com.example.daggerhiltcourse.data.remote.MyApi
import com.example.daggerhiltcourse.data.repository.MyRepositoryImpl
import com.example.daggerhiltcourse.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import java.nio.file.attribute.AclEntry.Builder
import javax.inject.Singleton

@Module
//SingletonComponent = menentukan lifeTime dari dependencies di dalam appModule. Ada bnyk macamnya, cek dokumentasi
//sehingga smua depencies akan bertahan selama ada singleton annotation
//singleton = injector applikasi
@InstallIn(SingletonComponent::class)
object AppModule {

    //Provide = Menyediakan dependencies
    @Provides
    //Singleton = bhwa function ini hanya dpt menghasilkan 1 instance
    //Misal dihapus singleton, maka saat kita  meg-inject MyApi. Cek di MyRepositoryImpl
    @Singleton
    fun provideMyApi(): MyApi {
    return Retrofit.Builder()
        .baseUrl("https://test.com")
        .build()
        .create(MyApi::class.java)
    }

    //Di viewModel butuh repository di dalam modul
    //What to do? MyRepositoryImpl -> AppModule. Juga memberitahukan dagger hilt, bagaimana membuat repositoryImpl
    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi, app: Application): MyRepository{
        return MyRepositoryImpl(api, app)
    }
}

class Car{
    private val engine = Engine()

    fun start(){
        engine.let { start() }
    }
}

class Engine(){
}

fun main(){
    val car = Car()
    car.start()
}