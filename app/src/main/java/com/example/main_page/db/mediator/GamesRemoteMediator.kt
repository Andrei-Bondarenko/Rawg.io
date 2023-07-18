package com.example.main_page.db.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.main_page.api.MainApi
import retrofit2.HttpException
import java.io.IOException

//@OptIn(ExperimentalPagingApi::class)
//class GamesRemoteMediator(
//    private val gamesDb: AppDatabase,
//    private val gamesApi: MainApi
//): RemoteMediator<Int, GamesEntity>() {
//
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, GamesEntity>
//    ): MediatorResult {
//        return try {
//            val loadKey = when(loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if (lastItem == null) {
//                        1
//                    } else {
//                        (lastItem.id / state.config.pageSize) + 1
//                    }
//                }
//            }
//            val games = gamesApi.getGamesData(
//                    genre = "action",
//                    page = loadKey
//                )
//
//
//            gamesDb.withTransaction {
//                if (loadType == LoadType.REFRESH) {
//                    gamesDb.dao.clearAll()
//                }
//                val gamesEntities = games.results.map { it.toGamesEntity() }
//                gamesDb.dao.upsertAll(gamesEntities)
//                MediatorResult.Success(
//                    endOfPaginationReached = games.results.isEmpty()
//                )
//            }
//
//        }catch (e: IOException) {
//            MediatorResult.Error(e)
//        }catch (e: HttpException) {
//            MediatorResult.Error(e)
//        }
//    }
//}