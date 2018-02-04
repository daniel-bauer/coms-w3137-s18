object Collatz{  // Singleton object 

    def main(args : Array[String]) : Unit = {
        collatz(17);
    }


    def collatz(n : Int) : Unit = {
        // Iterative version
        var m = n; 
        while (m > 1) {
            println(m);
            m = if (m % 2 == 0) m/2 else 3*m+1
        }
        println(m)
   
    }

    def collatz_rec(n : Int) : Unit  = {
        // recursive version
        if (n==1) {
            println(n); // this is the only side effect
        } else { 
            println(n); // this is the only side effect
            if (n % 2 == 0)
                collatz_rec(n/2)
            else
                collatz_rec(3 * n + 1)
        }
    } 

}
