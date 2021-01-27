# String Replacer Problem

## Problem

```
Given a string str consisting of letters only and an integer n, the task is 
to replace every character of the given string by a character which
is n times more than it. If the letter exceeds ‘z’, then start 
checking from ‘a’ in a cyclic manner.

Examples:
Input: str = “abc”, n = 2
Output: cde
a is moved by 2 times which results in character c
b is moved by 2 times which results in character d
c is moved by 2 times which results in character e

Input: str = “abc”, n= 28
Output: cde
a is moved 25 times, z is reached. Then the 26th character will be a,
27th b and 28th c.
b is moved 24 times, z is reached. 28-th is d.
c is moved 23 times, z is reached. 28-th is f.

Questions:
a/ Write an algorithm to solve the above issue. Please consider the 
complexity of the algorithm.
b/ What is the disadvantage of using the ASCII value of the letters 
to solve this problem?
```

## Solution

The solution can be found [here](https://github.com/KryptKode/StringReplacerProblem/blob/master/src/main/kotlin/StringReplacer.kt)

```kotlin
class StringReplacerFunc {

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
```

- The complexity of the algorithm above is `O(n)` where `n` is the length of the input string
- ASCII would be disadvantageous to use because it supports only latin characters.

## Testing

Tests can be found [here](https://github.com/KryptKode/StringReplacerProblem/blob/master/src/test/kotlin/StringReplacerTest.kt). The solution is also hosted on [Repl.it](https://repl.it/@KryptKode/StringReplacerProblem)  and [LeetCode](https://leetcode.com/playground/m3ciwvzH) for convenience. 

```kotlin
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StringReplacerTest {
    private lateinit var sut: StringReplacer

    @Before
    fun setup(){
        sut = StringReplacer()
    }

    @Test
    fun test1(){
        val result = sut.replace("ABC", 2)
        assertThat(result, `is`("CDE"))
    }

    @Test
    fun test2(){
        val result = sut.replace("abc", 28)
        assertThat(result, `is`("cde"))
    }

    @Test
    fun test3(){
        val result = sut.replace("abc", 29)
        assertThat(result, `is`("def"))
    }

    @Test
    fun test4(){
        val result = sut.replace("ABC", 31)
        assertThat(result, `is`("FGH"))
    }
}
```
