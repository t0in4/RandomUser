package com.shift.randomuser.model.response

data class UserResults (
    val results: List<Results>

){
    fun oneResult(results: List<Results>): Results {
        return results[0]

    }
}
