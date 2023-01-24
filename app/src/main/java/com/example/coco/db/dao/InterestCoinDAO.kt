package com.example.coco.db.dao

import androidx.room.*
import com.example.coco.db.entity.InterestCoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InterestCoinDAO {

    // getAllData
    // https://medium.com/androiddevelopers/room-flow-273acffe5b57
    // 데이터의 변경 사항을 감지하기 좋다
    @Query("SELECT * FROM interest_coin_table")
    fun getAllData() : Flow<List<InterestCoinEntity>>

    // Insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(interestCoinEntity: InterestCoinEntity)

    // update
    // 사용자가 코인 데이터를 선택했다가 다시 취소할 수도 있고, 반대로 선택안된 것을 선택할 수도 있게 함
    @Update
    fun update(interestCoinEntity: InterestCoinEntity)

    // getSelectedCoinList -> 내가 관심이어한 코인 데이터를 가져오는 것
    // coin1 / coin2 / coin3 -> coin1 data / coin2 data / coin3 data
    @Query("SELECT * FROM interest_coin_table WHERE selected = :selected")
    fun getSelectedData(selected : Boolean = true) : List<InterestCoinEntity>

}