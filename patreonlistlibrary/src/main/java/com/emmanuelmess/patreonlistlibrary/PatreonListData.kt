package com.emmanuelmess.patreonlistlibrary

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PatreonListData (val backers: List<Backer>, val completeList: Uri): Parcelable

@Parcelize
data class Backer(val name: String, val category: Int? = null) : Parcelable