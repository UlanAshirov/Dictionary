package com.uli.data.base

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uli.data.utils.DataMapper
import retrofit2.HttpException
import java.io.IOException

private const val START_PAGE_INDEX = 1

abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> BaseMainResponse<ValueDto>,
) : PagingSource<Int, Value>() {

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorOffset = state.closestPageToPosition(anchorPosition)
            anchorOffset?.prevKey?.plus(1) ?: anchorOffset?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: START_PAGE_INDEX
        return try {
            val response = request(position)
            val nextOffset = when (response.next) {
                null -> null
                else -> Uri.parse(response.next).getQueryParameter("offset")?.toInt()
            }

            LoadResult.Page(
                data = response.results.map { it.toDomain() },
                prevKey = null,
                nextKey = nextOffset
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (httpException: HttpException) {
            LoadResult.Error(httpException)
        }
    }
}