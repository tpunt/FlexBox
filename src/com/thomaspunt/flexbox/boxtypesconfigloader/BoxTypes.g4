grammar BoxTypes;

/*
 * This file was used to generate the Antlr lexer, parser, and default parse tree listeners with the following commands:
 * antlr4 com/thomaspunt/flexbox/boxtypesconfigloader/BoxTypes.g4 -package com.thomaspunt.flexbox.boxtypesconfigloader
 * javac com/thomaspunt/flexbox/boxtypesconfigloader/BoxTypes*.java
 *
 * The abstract syntax tree for the output of the parser can be seen by executing the following command:
 * grun com.thomaspunt.flexbox.boxtypesconfigloader.BoxTypes boxTypes < com/thomaspunt/flexbox/config/boxTypes.dsl -gui
 */

/* Parser Rules */

ints : element+=INT (COMMA element+=INT)* ;

type : TYPE INT ;
grades : GR SEP ints ;
colourPrint : CP SEP INT ;
reinforcedBottom : RB SEP choice ;
reinforcedCorners : RC SEP choice ;

choice : YES | NO ;

boxType : type grades colourPrint reinforcedBottom reinforcedCorners EOF? ;

boxTypes : boxType+ EOF ;


/* Lexer Rules */

INT : [0-9]+ ;
SEP : ':' ;
WS : [ \n\r\t]+ -> skip ;
COMMA : ',' ;
TYPE : 'Type' ;
GR : 'grades' ;
CP : 'colourPrint' ;
RB : 'reinforcedBottom' ;
RC : 'reinforcedCorners' ;
YES : 'yes' ;
NO : 'no' ;
ANSWER : YES | NO ;