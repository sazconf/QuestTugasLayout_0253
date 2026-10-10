package com.example.questlayout0253

import org.junit.Assert.assertNotEquals
import org.junit.Test

class StudentResourceContractTest {
    @Test
    fun eachStudentHasDistinctCardBackgroundResource() {
        val backgroundResources = studentUiModels().map { it.backgroundRes }

        assertNotEquals(backgroundResources[0], backgroundResources[1])
        assertNotEquals(backgroundResources[1], backgroundResources[2])
        assertNotEquals(backgroundResources[2], backgroundResources[3])
    }
}
