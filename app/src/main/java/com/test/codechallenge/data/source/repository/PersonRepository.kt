package com.test.codechallenge.data.source.repository

import androidx.lifecycle.LiveData
import com.test.codechallenge.data.model.Person
import com.test.codechallenge.data.source.local.entity.PersonEntity
import com.test.codechallenge.data.source.remote.NetworkBoundResource
import com.test.codechallenge.data.source.remote.Resource
import kotlinx.coroutines.CoroutineScope


interface PersonRepository {

    fun getPersonEntities(scope: CoroutineScope): NetworkBoundResource<List<PersonEntity>, Person>
    fun insertEntity(scope: CoroutineScope, entity: PersonEntity): LiveData<Resource<Int>>
}