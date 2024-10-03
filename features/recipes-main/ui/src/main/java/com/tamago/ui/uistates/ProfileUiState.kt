package com.tamago.ui.uistates

import com.tamago.firebase.domain.model.User

/**
 * Created by Igor Khoroshun on 21.09.2024.
 */
data class ProfileUiState(
    var user: User = User(),
    var isImageUploading: Boolean = false,
    var isLoading: Boolean = false,
    var error: String = ""
)
