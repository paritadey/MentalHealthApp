package com.parita.mentalhealthapp.di

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("X-Api-Key", "XSsJcjkurgxQa606QIIk/g==Su0blR5MpZ8t5tZA")
            .build()

        return chain.proceed(modifiedRequest)
    }
}
