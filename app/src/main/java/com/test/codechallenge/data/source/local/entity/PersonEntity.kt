package com.test.codechallenge.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "photo_url") val photoUrl: String,
    val gender: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "birth_place") val birthPlace: String,
    @ColumnInfo(name = "dob") val dob: String,
    @ColumnInfo(name = "house_number") val houseNumber: String,
    val community: String,
    val occupation: String,
    val district: String,
    val region: String,
    @ColumnInfo(name = "marital_status") val maritalStatus: String,
    val bio: String
    )