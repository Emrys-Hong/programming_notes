package sat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import sat.env.*;
import sat.formula.*;

public class SATSolverTest {
    Literal a = PosLiteral.make("a");
    Literal b = PosLiteral.make("b");
    Literal c = PosLiteral.make("c");
    Literal na = a.getNegation();
    Literal nb = b.getNegation();
    Literal nc = c.getNegation();

    public static void main(String[] args)
    {
        BufferedReader reader = null;
        int noOfVar = 0;
        ArrayList<Literal> tempLits = new ArrayList<>();
        ArrayList<Clause> clauseArray = new ArrayList<>();

        try
        {
            File file = new File("C:\\Users\\khong\\Documents\\Term 4 2D\\50.001-20181016T022158Z-001\\50.001\\project-2d-starting\\sampleCNF\\s8Sat.cnf");
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("p") || line.startsWith("c")){
                    continue;
                }

                if (line.startsWith(" ")){
                    line = line.trim();
                }

                if (line.isEmpty()){
                    continue;
                }

                String[] lits = line.split("\\s+");

                for (String s : lits) {

                    if (!s.startsWith("\\s+")) {
                        if (s.startsWith("p") || s.startsWith("c")) {
                            continue;
                        }
                        else {
                            if (!s.equals("0")) {
                                if (s.charAt(0) == '-') {
                                    String newS = s.substring(1);
                                    tempLits.add(NegLiteral.make(newS));
                                }
                                else {
                                    tempLits.add(PosLiteral.make(s));
                                }
                            }
                            else {
                                Literal[] literal = tempLits.toArray(new Literal[tempLits.size()]);
                                clauseArray.add(makeCl(literal));
                                tempLits.clear();
                            }
                        }
                    }
                }
            }
            makeFm(clauseArray.toArray(new Clause[clauseArray.size()]));
            Formula formula = makeFm(clauseArray.toArray(new Clause[clauseArray.size()]));

            System.out.println("SAT solver starts!!!");
            long started = System.nanoTime();

            Environment answer = SATSolver.solve(formula);

            long time = System.nanoTime();
            long timeTaken = time - started;
            System.out.println("time " + timeTaken/1000000.0 + "ms");

            if (answer != null){
                System.out.println("satisfiable");

                BufferedWriter writer = new BufferedWriter(new FileWriter("BoolAssignment.txt"));
                String stringAns = answer.toString();
                stringAns = stringAns.replace("->",":");
                stringAns = stringAns.replace("Environment:["," ");
                stringAns = stringAns.replace("]","");
                String[] slist = stringAns.split(",");
                String[] slist2 = new String[slist.length];

                for (int i = 1; i <= slist.length ; i++) {
                    for (String s : slist){
                        if (s.contains(" " + i + ":")){
                            slist2[i-1] = s.replace(" ", "");
                        }
                    }
                }

                String retstring = Arrays.toString(slist2);
                retstring = retstring.replace("[","");
                retstring = retstring.replace("]","");
                retstring = retstring.replace(", ","\n");
                writer.write(retstring);
                writer.close();
            }

            else {
                System.out.println("not satisfiable");
            }

        }
        catch (IOException exc){
            exc.printStackTrace();
            System.out.println("File I/O error!");
        }
    }


    public void testSATSolver1(){
        Environment e = SATSolver.solve(makeFm(makeCl(a,b))	);
    }


    public void testSATSolver2(){
        Environment e = SATSolver.solve(makeFm(makeCl(na)));
    }

    private static Formula makeFm(Clause... e) {
        Formula f = new Formula();
        for (Clause c : e) {
            f = f.addClause(c);
        }
        return f;
    }

    private static Clause makeCl(Literal... e) {
        Clause c = new Clause();
        for (Literal l : e) {
            c = c.add(l);
        }
        return c;
    }
}