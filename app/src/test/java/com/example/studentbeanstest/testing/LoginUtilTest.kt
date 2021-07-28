package com.example.studentbeanstest.testing

import android.util.Patterns
import com.google.common.truth.Truth.assertThat

import org.junit.Test


class LoginUtilTest{


    @Test
    fun `not empty email returns true`() {
        val result = LoginUtil.loginValidation(
            "jbkbkjb",
            ""
        )

        assertThat(result).isTrue()

    }

    @Test
    fun `not empty password returns true`() {
        val result = LoginUtil.loginValidation(
            "",
            "fds"
        )

        assertThat(result).isTrue()

    }
    @Test
    fun `valid email returns true`() {
        val result = LoginUtil.loginValidation(
            "jbkbkjb@klk.com",
            ""
        )

        assertThat(result).isTrue()

    }

}