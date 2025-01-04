package com.whitemonkeys.botcreator.networking.utils

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    NO_INTERNET,
    SERVER_ERROR,
    CLIENT_ERROR,
    UNKNOWN;
}