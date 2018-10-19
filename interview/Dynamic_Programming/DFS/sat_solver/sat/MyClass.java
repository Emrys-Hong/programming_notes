package sat;

import java.lang.reflect.Array;
import java.util.ArrayList;

import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.NegLiteral;
import sat.formula.PosLiteral;

public class MyClass {

    public static void main(String[] args) {
        Literal a = PosLiteral.make("a");
        Literal b = PosLiteral.make("b");
        Literal c = PosLiteral.make("c");
        Literal d = PosLiteral.make("d");
        Literal e = PosLiteral.make("e");
        Literal na = a.getNegation();
        Literal nb = b.getNegation();
        Literal nc = c.getNegation();
        Literal nd = d.getNegation();
        Literal ne = e.getNegation();



        Clause haha = new Clause();
        haha = haha.add(NegLiteral.make("1"));
        haha = haha.add(nc);
//        System.out.println(haha);

        ArrayList<Literal> test = new ArrayList<>();
        test.add(a);
        test.add(c);
        test.add(nd);
        Literal[] arr = test.toArray(new Literal[test.size()]);

//        Clause c1 = SATSolverTest_Derrick.makeCl(arr);

        Clause c2 = new Clause();
        c2 = c2.add(d);

        Clause c3 = new Clause();
        c3 = c3.add(b);
        c3 = c3.add(nc);

        Clause c4 = new Clause();
        c4 = c4.add(na);
        c4 = c4.add(b);

        Clause c5 = new Clause();
        c5 = c5.add(b);

        Clause c6 = new Clause();
        c6 = c6.add(nb);
        c6 = c6.add(c);

        Clause c7 = new Clause();
        c7 = c7.add(nc);
        c7 = c7.add(d);

        Clause c8 = new Clause();
        c8 = c8.add(nd);

//        Formula f = SATSolverTest_Derrick.makeFm(c1,c2,c3);

        Formula f2 = new Formula();
        f2 = f2.addClause(c4);
        f2 = f2.addClause(c5);
        f2 = f2.addClause(c6);
        f2 = f2.addClause(c7);
        f2 = f2.addClause(c8);

//        Clause bt1 = SATSolverTest.makeCl(b, a);
//        Clause bt2 = SATSolverTest.makeCl(na, c, d);
//        Clause bt3 = SATSolverTest.makeCl(nc, nd);
//        Clause bt4 = SATSolverTest.makeCl(nc, d);
//        Clause bt5 = SATSolverTest.makeCl(c, nd);
//        Clause bt6 = SATSolverTest.makeCl(nb, nc, nd);
////        Clause bt7 = SATSolverTest.makeCl(e, nc, nd);
//
//        Formula btformula = SATSolverTest.makeFm(bt2, bt3, bt4, bt5, bt6, bt1);
//        System.out.println(btformula);

        System.out.println("SAT solver starts!");
        long started = System.nanoTime();

//        System.out.println(btformula);
//        System.out.println(SATSolver.solve(btformula));
        //System.out.println(SATSolver.substitute(f.getClauses(),d));


        long time = System.nanoTime();
        long timeTaken = time - started;
        System.out.println("time " + timeTaken/1000000.0 + "ms");

        //System.out.println(a);
        //System.out.println(c1);
        //System.out.println(f);



    }
}
