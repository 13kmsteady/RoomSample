package com.i3kmsteady.roomsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.i3kmsteady.roomsample.database.UserDataBase
import com.i3kmsteady.roomsample.entity.User
import io.reactivex.Completable

class UserViewModel(
    private val database: UserDataBase
) : ViewModel() {

    fun insertUser(user: User): Completable =
        Completable.fromAction {
            database.userDao().insert(user)
        }
}

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(
    private val database: UserDataBase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        UserViewModel(database) as T
}