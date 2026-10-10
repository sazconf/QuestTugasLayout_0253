package com.example.questlayout0253

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StudentDataTest {
    @Test
    fun studentRecordsKeepRequiredOrderAndStyles() {
        val students = studentUiModels()

        assertEquals(4, students.size)
        assertEquals(R.string.student_bambang_name, students[0].nameRes)
        assertEquals(R.string.student_gibran_name, students[1].nameRes)
        assertEquals(R.string.student_zhila_name, students[2].nameRes)
        assertEquals(R.string.student_ahmad_name, students[3].nameRes)
        assertTrue(students[0].useScriptName)
    }
}
