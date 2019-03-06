package com.i3kmsteady.roomsample.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.i3kmsteady.roomsample.entity.User
import io.reactivex.Flowable

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)

    @Query("SELECT * FROM user")
    abstract fun getAllUsers(): Flowable<List<User>>

    @Query("SELECT * FROM user")
    abstract fun getAllUser(): LiveData<List<User>>


    @Query("SELECT * FROM user WHERE id=:userId")
    abstract fun getUserById(userId: Int): Flowable<User>

    @Update
    abstract fun updateUser(user: User)

    @Delete
    abstract fun deleteUser(user: User)

    /**
     * 删除表
     */
    @Query("DELETE FROM user")
    abstract fun deleteAllUsers()
}