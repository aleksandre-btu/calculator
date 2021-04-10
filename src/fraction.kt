fun main() {
    val f1 = Fraction(1F, 3F)

    val f2 = Fraction(2F, 6F)

    println(f1 == f2)
    println(f1.toString())
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


}