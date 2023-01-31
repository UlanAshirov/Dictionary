package com.uli.data.base

data class BaseMainResponse<T>(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<T>
)
