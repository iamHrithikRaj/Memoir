package com.project.memoir.model.repository

import com.project.memoir.common.Result
import com.project.memoir.model.User

interface IUserRepository {
    suspend fun getCurrentUser(): Result<Exception, User?>

    suspend fun signOutCurrentUser(): Result<Exception, Unit>

    suspend fun signInGoogleUser(idToken: String): Result<Exception, Unit>
}