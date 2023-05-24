package com.test.codechallenge.data.source.repository

import androidx.lifecycle.LiveData
import com.test.codechallenge.data.model.Person
import com.test.codechallenge.data.source.local.DatabaseResource
import com.test.codechallenge.data.source.local.dao.PersonDao
import com.test.codechallenge.data.source.local.entity.PersonEntity
import com.test.codechallenge.data.source.remote.ApiResponse
import com.test.codechallenge.data.source.remote.ApiService
import com.test.codechallenge.data.source.remote.NetworkBoundResource
import com.test.codechallenge.utils.asLiveData
import com.test.codechallenge.data.source.remote.Resource
import kotlinx.coroutines.CoroutineScope


class PersonRepositoryImpl(private val personDao: PersonDao, private val apiService: ApiService) :
    PersonRepository {

    override fun getPersonEntities(scope: CoroutineScope): NetworkBoundResource<List<PersonEntity>, Person> {
        return object : NetworkBoundResource<List<PersonEntity>, Person>(scope) {
            override fun saveCallResult(item: Person) {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<PersonEntity>?): Boolean {
                TODO("Not yet implemented")
            }

            override fun loadFromDb(): LiveData<List<PersonEntity>> {
                TODO("Not yet implemented")
            }

            override fun createCall(): LiveData<ApiResponse<Person>> {
                TODO("Not yet implemented")
            }
        }
    }

    override fun insertEntity(scope: CoroutineScope, entity: PersonEntity): LiveData<Resource<Int>> {
        return object : DatabaseResource<Int>(scope) {
            override fun performDbOperation(): LiveData<Int> {
                val rowId = personDao.insert(entity)
                return rowId.toInt().asLiveData()
            }

        }.asLiveData()
    }
}