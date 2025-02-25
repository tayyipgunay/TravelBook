package com.tayyipgunay.travelbook

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import kotlinx.android.parcel.Parcelize
import java.io.Serial
import java.io.Serializable
@kotlinx.parcelize.Parcelize
 // singleton olduğu için gerek kalmadı serializable'ye

// Landmark sınıfı, Android'de bir Intent veya Bundle ile veri taşımak için Parcelable arabirimini uyguluyor
class Landmark(val name: String, val country: String, val image: Int) : Parcelable