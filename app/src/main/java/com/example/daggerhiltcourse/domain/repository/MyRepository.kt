package com.example.daggerhiltcourse.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}