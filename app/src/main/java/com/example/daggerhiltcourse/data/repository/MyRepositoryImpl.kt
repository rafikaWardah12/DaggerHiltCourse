package com.example.daggerhiltcourse.data.repository

import android.app.Application
import com.example.daggerhiltcourse.R
import com.example.daggerhiltcourse.data.remote.MyApi
import com.example.daggerhiltcourse.domain.repository.MyRepository

//repository bisa banyak contoh repository networking, Car repository dsb
//Semisal singleton dihpus maka, dan 2 repository membutuhkan primary constructor dri MyApi akan membuat 2 instance baru
//Karena itu kita hanya ingin semua repository hnya memiliki 1 instance. Butuh singleton
class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {
    //penulisan 1
//    val appName: String

    init {
        //penulisan 2. Cbak cek type datanya pasti string mskipun g ditulis
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}