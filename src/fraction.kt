fun main() {
    val f1 = Fraction(1F, 2F)
    val f2 = Fraction(3F, 4F)

//    println(f1 == f2)
//    println(f1.toString())
    f1.shorten()
    f1.add(f2)
    f1.multiply(f2)
}

class Fraction(n: Float, d: Float) {

    private var numerator: Float = n
    private var denominator: Float = d

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {

        return "$numerator/$denominator"
    }

    // ვიცი, რომ ეს მიდგომა ბოლომდე სწორი არ არის, მაგრამ ვერ მოვიფიქრე როგორ მეპოვა ყველა მარტივი რიცხვი
    // MATH ბიბლიოთეკასაც არ აქვს მსგავსი ფუნქციები და გარე ბიბლიოთეკების დაიმპორტება არ მინდოდა.
    fun shorten() {
        val arr = floatArrayOf(29f,27f,23f,19f,17f,13f,11f,7f,5f,3f,2f)
        for (i in arr) {
            if (numerator % i == 0f && denominator % i == 0f ) {
                this.numerator = numerator / i
                this.denominator = denominator / i
            }
        }
        println("$numerator/$denominator")
    }

    fun add(other: Any?) {
        var combineFraction = Fraction(0f, 0f)
        if (other is Fraction) {
            val combineDenominator = other.denominator * this.denominator
            val combineNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            combineFraction = Fraction(combineNumerator, combineDenominator)
        }
        return combineFraction.shorten()
    }

    fun multiply(other: Any?) {
        var combineFraction = Fraction(0f, 0f)
        if (other is Fraction) {
            val combineDenominator = other.denominator * this.denominator
            val combineNumerator = this.numerator * other.numerator
            combineFraction = Fraction(combineNumerator, combineDenominator)
        }
        return combineFraction.shorten()
    }
}