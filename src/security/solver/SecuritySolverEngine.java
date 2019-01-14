package security.solver;

import checkers.inference.solver.SolverEngine;
import checkers.inference.solver.backend.SolverFactory;
import checkers.inference.solver.backend.maxsat.MaxSatSolverFactory;

public class SecuritySolverEngine extends SolverEngine {
    @Override
    protected SolverFactory createSolverFactory() {
        return new MaxSatSolverFactory();
    }
}