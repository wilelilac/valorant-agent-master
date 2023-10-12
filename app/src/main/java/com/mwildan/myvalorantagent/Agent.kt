package com.mwildan.myvalorantagent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Agent(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable