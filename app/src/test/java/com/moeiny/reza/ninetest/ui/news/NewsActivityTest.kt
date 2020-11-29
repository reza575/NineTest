package com.moeiny.reza.ninetest.ui.news

import com.moeiny.reza.ninetest.model.RelatedImage
import com.nhaarman.mockito_kotlin.mock
import junit.framework.TestCase

class NewsActivityTest : TestCase() {

    fun `testFindSmallPhoto normal list`() {
        val relatedImage1 = mock<RelatedImage> {
            on { width }.then { 10 }
            on { height }.then { 20 }
            on { url }.then { "http1" }
        }
        val relatedImage2 = mock<RelatedImage> {
            on { width }.then { 50 }
            on { height }.then { 15 }
            on { url }.then { "http2" }
        }
        val relatedImage3 = mock<RelatedImage> {
            on { width }.then { 7 }
            on { height }.then { 21 }
            on { url }.then { "http3" }
        }
        val list = listOf(
            relatedImage1,
            relatedImage2,
            relatedImage3
        )
        val viewModel = NewsViewModel(mock())
        assertEquals(relatedImage2.url, viewModel.findSmallPhoto(list))

    }

    fun `testFindSmallPhoto when there is height 0 avaiable`(){
        val relatedImage1 = mock<RelatedImage> {
            on { width }.then { 10 }
            on { height }.then { 20 }
            on { url }.then { "http1" }
        }
        val relatedImage2 = mock<RelatedImage> {
            on { width }.then { 50 }
            on { height }.then { 0 }
            on { url }.then { "http2" }
        }
        val relatedImage3 = mock<RelatedImage> {
            on { width }.then { 5 }
            on { height }.then { 5 }
            on { url }.then { "http3" }
        }
        val list = listOf(
            relatedImage1,
            relatedImage2,
            relatedImage3
        )
        val viewModel = NewsViewModel(mock())
        assertEquals(relatedImage3.url, viewModel.findSmallPhoto(list))
    }

    fun `testFindSmallPhoto when there is width 0 avaiable`(){
        val relatedImage1 = mock<RelatedImage> {
            on { width }.then { 10 }
            on { height }.then { 20 }
            on { url }.then { "http1" }
        }
        val relatedImage2 = mock<RelatedImage> {
            on { width }.then { 0 }
            on { height }.then { 1 }
            on { url }.then { "http2" }
        }
        val relatedImage3 = mock<RelatedImage> {
            on { width }.then { 5 }
            on { height }.then { 5 }
            on { url }.then { "http3" }
        }
        val list = listOf(
            relatedImage1,
            relatedImage2,
            relatedImage3
        )
        val viewModel = NewsViewModel(mock())
        assertEquals(relatedImage3.url, viewModel.findSmallPhoto(list))
    }

    fun `testFindSmallPhoto when there is width - and hight - avaiable`(){
        val relatedImage1 = mock<RelatedImage> {
            on { width }.then { -1 }
            on { height }.then { 20 }
            on { url }.then { "http1" }
        }
        val relatedImage2 = mock<RelatedImage> {
            on { width }.then { 3 }
            on { height }.then { -2 }
            on { url }.then { "http2" }
        }
        val relatedImage3 = mock<RelatedImage> {
            on { width }.then { 0}
            on { height }.then { 0 }
            on { url }.then { "http3" }
        }
        val list = listOf(
            relatedImage1,
            relatedImage2,
            relatedImage3
        )
        val viewModel = NewsViewModel(mock())
        assertEquals("", viewModel.findSmallPhoto(list))
    }
}