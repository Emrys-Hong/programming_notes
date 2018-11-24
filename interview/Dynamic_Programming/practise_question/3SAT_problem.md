# 3SAT questions in general using dynamic programming
## Question description
This question generally uses the dynamic programming. and there are some levels checking whether a clause is satisfiable or not. similar like this question. it is like:
1. first, try the first function if fail it calls the second choice.
1. try the second function. if also fail return false
1. this function usually have recursion in the if statement.
## solution for sat

```java
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
```
