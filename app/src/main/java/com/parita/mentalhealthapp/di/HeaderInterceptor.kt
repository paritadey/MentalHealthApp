package com.parita.mentalhealthapp.di

import com.parita.mentalhealthapp.util.Constants.Companion.APIKEY
import com.parita.mentalhealthapp.util.Constants.Companion.XAPIKEY
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header(XAPIKEY, APIKEY)
            .build()

        return chain.proceed(modifiedRequest)
    }
}
