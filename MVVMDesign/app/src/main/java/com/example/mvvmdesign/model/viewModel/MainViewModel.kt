package com.example.mvvmdesign.model.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdesign.model.Blog

class MainViewModel: ViewModel() {
    var list = MutableLiveData<List<Blog>>()
    var newList = arrayListOf<Blog>()

    fun add(blog: Blog) {
        newList.add(blog)
        list.value = newList
    }

    fun remove(blog: Blog) {
        newList.remove(blog)
        list.value = newList
    }
}