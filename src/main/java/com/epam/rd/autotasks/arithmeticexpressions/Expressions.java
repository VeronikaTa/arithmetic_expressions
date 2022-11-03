package com.epam.training.student_veronika_tarasova.arithmetic_expressions.src.main.java.com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression expression = new Expression(){
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return value < 0 ? "("+value+")" : String.valueOf(value);
            }
        };
        return expression;
    }

    public static Expression sum(Expression... members){
        Expression expression = new Expression(){
            @Override
            public int evaluate() {
                int sum = 0;
                for(Expression value : members){
                    sum += value.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String expressionToString = "";
                int length = members.length;
                for(int i = 0; i < length; i++){
                    if(i == 0){
                       expressionToString = expressionToString.concat("(" ).concat(members[i].toExpressionString()).concat(" + ");
                    }
                    else if(i == length -1){
                      expressionToString = expressionToString.concat(members[i].toExpressionString()).concat(")");
                    }
                    else{
                       expressionToString = expressionToString.concat(members[i].toExpressionString()).concat(" + ");
                    }
                }
                return expressionToString;
            }
        };
        return expression;
    }

    public static Expression product(Expression... members){
       Expression expression = new Expression(){
           @Override
           public int evaluate() {
               int product = 1;
               for(Expression expression : members){
                   product *= expression.evaluate();
               }
               return product;
           }

           @Override
           public String toExpressionString() {
               String expressionToString = "";
               int length = members.length;
               for(int i =0 ; i < length; i++){
                   if(i == 0){
                   expressionToString =  expressionToString.concat("(").concat(members[i].toExpressionString()).concat(" * ");
                   }
                   else if(i == length-1){
                    expressionToString =  expressionToString.concat(members[i].toExpressionString()).concat(")");
                   }
                   else{
                      expressionToString = expressionToString.concat(members[i].toExpressionString()).concat(" * ");
                   }
               }
               return expressionToString;
           }
       };
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression expression = new Expression(){
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " " + "-" + " " + subtrahend.toExpressionString() + ")";
            }
        };
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        Expression expression = new Expression (){
            @Override
            public int evaluate() {
                if(divisor.evaluate() == 0){
                    throw new ArithmeticException();
                }
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " " + "/" + " " + divisor.toExpressionString() + ")";
            }
        };
        return expression;
    }

}
