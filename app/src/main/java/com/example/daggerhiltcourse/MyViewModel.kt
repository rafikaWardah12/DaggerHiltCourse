package com.example.daggerhiltcourse

import androidx.lifecycle.ViewModel
import com.example.daggerhiltcourse.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//Mempunyai instance di dlm viewModel constuctor
//Untuk inject disni sedikit tricky krna butuh factory, jdi hrus bkin viewModel factory
//ViewModel membutuhkan constuctor argument sehingga memberitahu factory bgmna cara viewModel dibuat
//Jadii membuatnya susah saat dibuat dibelakang layar dg flexible
//Solusi: memakai dagger-hilt. Dagger 2 susah gmpng Hilt

@HiltViewModel
//HiltViewModel = Artinya, aku ingin menginject dependencies dg daggerHilt
//@Inject = kita ingin inject/nyuntik constuctor
//Dagger inject dong smua dependencies yg kita punya di constuctor dn lihat di dalam modul.
//Cek in dong, jika kamu nemuin (private val repository: MyRepository)/constructor argument
//Maka Go ahead go ahead(dagger hilt)
class MyViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {
}