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