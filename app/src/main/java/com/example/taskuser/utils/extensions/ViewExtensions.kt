package com.example.taskuser.utils.extensions

import android.view.View

fun View.setVisibility(visibility : Boolean){
    if(visibility) setVisibility(View.VISIBLE)
    else setVisibility(View.GONE)
}