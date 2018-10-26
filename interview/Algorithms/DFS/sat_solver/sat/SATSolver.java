package sat;

import immutable.EmptyImList;
import immutable.ImList;
import java.util.Iterator;

import sat.env.Bool;
import sat.env.Environment;
import sat.formula.Clause;
import sat.formula.Formula;
import sat.formula.Literal;
import sat.formula.NegLiteral;
import sat.formula.PosLiteral;

/**
 * A simple DPLL SAT solver. See http://en.wikipedia.org/wiki/DPLL_algorithm
 */
public class SATSolver {
    /**
     * Solve the problem using a simple version of DPLL with backtracking and
     * unit propagation. The returned environment binds literals of class
     * bool.Variable rather than the special literals used in clausification of
     * class clausal.Literal, so that clients can more readily use it.
     *
     * @return an environment for which the problem evaluates to Bool.TRUE, or
     *         null if no such environment exists.
     */
    public static Environment solve(Formula formula) {
        return solve(formula.getClauses(), new Environment());      //calls solve(clauses, env)
    }

    /**
     * Takes a partial assignment of variables to values, and recursively
     * searches for a complete satisfying assignment.
     *
     * @param clauses
     *            formula in conjunctive normal form
     * @param env
     *            assignment of some or all variables in clauses to true or
     *            false values.
     * @return an environment for which all the clauses evaluate to Bool.TRUE,
     *         or null if no such environment exists.
     */
    private static Environment solve(ImList<Clause> clauses, Environment env) {
        // Data:
        Clause emptyClause = new Clause();      // used to check for an empty clause

        // Finding minimum clause size
        int i = 100;
        Iterator<Clause> iterCl = clauses.iterator();
        while(iterCl.hasNext()) {
            i = Math.min(iterCl.next().size(), i);
        }

        // Case 1:
        if (clauses.isEmpty()){         // checking if there are no clauses left.
            return env;
        }

        // Case 2:
        else if (clauses.contains(emptyClause)){        // checking if there are any clauses which are empty.
            return null;    // returning null cause this Problem can't be solved.
        }

        // Case 3:
        else {
            Iterator<Clause> clauseIter = clauses.iterator();   // creates an iterator for ImList<Clause>
            while (clauseIter.hasNext()){
                Clause currentClause = clauseIter.next();
                if (currentClause.size() == i){         // checks if the size of the clause is i.
                    Literal chosenLit = currentClause.chooseLiteral();      // chooses a random literal from the clause
                    if (chosenLit instanceof PosLiteral) {      // if the chosen lit is positive, put itself into the environment.
                        env = env.putTrue(chosenLit.getVariable());
                    }
                    else {                                      // if the chosen lit is negative, put its negation into the environment.
                        env = env.putFalse(chosenLit.getVariable());
                    }

                    ImList<Clause> newclauses = substitute(clauses, chosenLit);     // calls substitute

                    Environment output = solve(newclauses, env);

                    if ((output == null) && (env.get(chosenLit.getVariable())==Bool.TRUE)){         //chosenLit instanceof PosLiteral
                        Literal negatedChosenLit = chosenLit.getNegation();
                        if (chosenLit instanceof PosLiteral) {
                            env = env.putFalse(chosenLit.getVariable());
                        }
                        else {
                            env = env.putTrue(chosenLit.getVariable());
                        }

                        ImList<Clause> newerclauses = substitute(clauses, negatedChosenLit);
                        return solve(newerclauses, env);
                    }
                    else if ((output == null) && (env.get(chosenLit.getVariable())==Bool.FALSE)){        //chosenLit instanceof NegLiteral
                        return null;
                    }

                    else {
                        return output;
                    }
                }
            }
        }
        return null;
    }

    /**
     * given a clause list and literal, produce a new list resulting from
     * setting that literal to true
     *
     * @param clauses
     *            , a list of clauses
     * @param l
     *            , a literal to set to true
     * @return a new list of clauses resulting from setting l to true
     */
    private static ImList<Clause> substitute(ImList<Clause> clauses,
                                             Literal l) {
        // declare ImList as output first
        ImList<Clause> output = new EmptyImList<>();
        Iterator<Clause> iterCl = clauses.iterator();

        // iterate on Clauses
        while (iterCl.hasNext()) {
            Clause eachC = iterCl.next();
            boolean containL = false;
            boolean containNotL = false;
            Iterator<Literal> iterLi = eachC.iterator();

            // iterate on literal
            while (iterLi.hasNext()) {
                Literal eachL = iterLi.next();
                if (eachL == l) {
                    containL = true;
                } else if (eachL.negates(l)) {
                    containNotL = true;
                }
            }

            // adding Clause or not
            if (containL) {
                ;
            } else {
                if (containNotL) {
                    eachC = eachC.reduce(l);
                }
                output = output.add(eachC);
            }
        }
        return output;
    }

}