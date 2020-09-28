package tech.jknair.workalarmmanagersample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Session(
    val id: Int
): Parcelable