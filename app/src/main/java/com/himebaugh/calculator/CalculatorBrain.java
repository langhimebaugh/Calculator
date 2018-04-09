package com.himebaugh.calculator;

public class CalculatorBrain {
    // 3 + 6 = 9
    // 3 & 6 are called the operand.
    // The + is called the operator.
    // 9 is the result of the operation.
    private double mOperand;
    private double mWaitingOperand;
    private String mWaitingOperator;
    private double mCalculatorMemory;

    // operator types
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static final String CLEAR = "C";
    private static final String CLEARMEMORY = "MC";
    private static final String ADDTOMEMORY = "M+";
    private static final String SUBTRACTFROMMEMORY = "M-";
    private static final String RECALLMEMORY = "MR";
    private static final String SQUAREROOT = "√";
    private static final String SQUARED = "x²";
    private static final String INVERT = "1/x";
    private static final String TOGGLESIGN = "+/-";
    private static final String SINE = "sin";
    private static final String COSINE = "cos";
    private static final String TANGENT = "tan";
    // public static final String EQUALS = "=";

    // constructor
    protected CalculatorBrain() {
        // initialize variables upon start
        mOperand = 0;
        mWaitingOperand = 0;
        mWaitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        mOperand = operand;
    }

    public double getResult() {
        return mOperand;
    }

    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(mOperand);
    }

    protected double performOperation(String operator) {

        switch (operator) {
            case CLEAR:
                mOperand = 0;
                mWaitingOperator = "";
                mWaitingOperand = 0;
                break;
            case CLEARMEMORY:
                mCalculatorMemory = 0;
                break;
            case ADDTOMEMORY:
                mCalculatorMemory = mCalculatorMemory + mOperand;
                break;
            case SUBTRACTFROMMEMORY:
                mCalculatorMemory = mCalculatorMemory - mOperand;
                break;
            case RECALLMEMORY:
                mOperand = mCalculatorMemory;
                break;
            case SQUAREROOT:
                mOperand = Math.sqrt(mOperand);
                break;
            case SQUARED:
                mOperand = mOperand * mOperand;
                break;
            case INVERT:
                if (mOperand != 0) {
                    mOperand = 1 / mOperand;
                }
                break;
            case TOGGLESIGN:
                mOperand = -mOperand;
                break;
            case SINE:
                mOperand = Math.sin(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            case COSINE:
                mOperand = Math.cos(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            case TANGENT:
                mOperand = Math.tan(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            default:
                performWaitingOperation();
                mWaitingOperator = operator;
                mWaitingOperand = mOperand;
                break;
        }

        return mOperand;
    }

    private void performWaitingOperation() {

        switch (mWaitingOperator) {
            case ADD:
                mOperand = mWaitingOperand + mOperand;
                break;
            case SUBTRACT:
                mOperand = mWaitingOperand - mOperand;
                break;
            case MULTIPLY:
                mOperand = mWaitingOperand * mOperand;
                break;
            case DIVIDE:
                if (mOperand != 0) {
                    mOperand = mWaitingOperand / mOperand;
                }
                break;
        }

    }

}
