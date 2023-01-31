package com.uli.data.utils

interface DataMapper<T> {
    fun toDomain(): T
}