package com.example.homeworkpers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
        val firstName: String,
        val lastName: String,
        val eMail: String,
        val year: String,
        val gender: String
):Parcelable {

}