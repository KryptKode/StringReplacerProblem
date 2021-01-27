class StringReplacer {

    fun replace(string: String, steps: Int): String {
        val numOfAlphabets = 26
        return string.map { char->
            println("UNICODE of $char is ${char.toInt()}")
            val isUpperCase = char.isUpperCase()
            val upperBound = if(isUpperCase) 'Z' else 'z'
            val lowerBound = if(isUpperCase) 'A' else 'a'
            if (char.plus(steps) > upperBound) { //handle overflow
                var newSteps = steps - (upperBound.toInt() - char.toInt())
                newSteps %= numOfAlphabets
                lowerBound.minus(1).plus(newSteps)
            } else {
                char.plus(steps)
            }
        }.joinToString("")
    }
}
        