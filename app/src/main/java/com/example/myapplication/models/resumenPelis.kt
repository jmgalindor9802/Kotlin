package com.example.myapplication.models

data class resumenPelis(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)