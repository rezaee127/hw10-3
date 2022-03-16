package com.example.hw10_3

data class Items(var id:Int,var pictureId:Int,var title:String,var description:Int) {

}

object Storage{
    var editFlag=false
    //var item=4
    var arrayOfItems=arrayOf(
        Items(1,R.drawable.m1,"طبیعت 1", R.string.string1),
        Items(2,R.drawable.m2,"طبیعت 2", R.string.string2),
        Items(3,R.drawable.m3,"طبیعت 3", R.string.string3),
        Items(4,R.drawable.m4,"طبیعت 4", R.string.string4),
        Items(5,R.drawable.m5,"طبیعت 5", R.string.string5),
        Items(6,R.drawable.m6,"طبیعت 6", R.string.string6))
}