package com.i3kmsteady.roomsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.i3kmsteady.roomsample.R
import com.i3kmsteady.roomsample.database.UserDataBase
import com.i3kmsteady.roomsample.entity.Book
import com.i3kmsteady.roomsample.entity.User
import com.i3kmsteady.roomsample.viewmodel.UserViewModel
import com.i3kmsteady.roomsample.viewmodel.UserViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private val disposable = CompositeDisposable()

    private val bookList: MutableList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(
            this, UserViewModelFactory(UserDataBase.getInstance(this))
        ).get(UserViewModel::class.java)

        btnAdd.setOnClickListener {
            insertUser()
        }

        bookList.add(Book("红楼梦"))
        bookList.add(Book("三国演义"))
        bookList.add(Book("水浒传"))
        bookList.add(Book("西游记"))
    }

    private fun insertUser() {
        val i = (1..10000).shuffled().last()
        disposable.add(
            userViewModel.insertUser(User(i, "13kmsteady$i", bookList))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}
