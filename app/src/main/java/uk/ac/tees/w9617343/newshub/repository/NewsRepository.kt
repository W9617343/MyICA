package uk.ac.tees.w9617343.newshub.repository

import android.util.Log
import uk.ac.tees.w9617343.newshub.data.DataOrException
import uk.ac.tees.w9617343.newshub.models.NewsResponse
import uk.ac.tees.w9617343.newshub.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val api: NewsApi) {

    suspend fun getNews(
        page:Int = 1
    ):DataOrException<NewsResponse,Boolean,Exception> {
        val response = try {
             api.getNews(page = page)

        }catch (e:Exception){
            return DataOrException(loading = false,exception = e)
        }
        return DataOrException(response,false)

    }

    suspend fun searchNews(searchQuery:String,page: Int = 1):DataOrException<NewsResponse,Boolean,Exception> {
        val response = try {
            api.searchNews(searchQuery = searchQuery, page = page)

        }catch (e:Exception){
            return DataOrException(loading = false,exception = e)
        }
        return DataOrException(response,false)

    }


}