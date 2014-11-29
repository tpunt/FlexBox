// Generated from com/thomaspunt/flexbox/boxtypesconfigloader/BoxTypes.g4 by ANTLR 4.4
package com.thomaspunt.flexbox.boxtypesconfigloader;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BoxTypesParser}.
 */
public interface BoxTypesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#reinforcedBottom}.
	 * @param ctx the parse tree
	 */
	void enterReinforcedBottom(@NotNull BoxTypesParser.ReinforcedBottomContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#reinforcedBottom}.
	 * @param ctx the parse tree
	 */
	void exitReinforcedBottom(@NotNull BoxTypesParser.ReinforcedBottomContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#ints}.
	 * @param ctx the parse tree
	 */
	void enterInts(@NotNull BoxTypesParser.IntsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#ints}.
	 * @param ctx the parse tree
	 */
	void exitInts(@NotNull BoxTypesParser.IntsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#colourPrint}.
	 * @param ctx the parse tree
	 */
	void enterColourPrint(@NotNull BoxTypesParser.ColourPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#colourPrint}.
	 * @param ctx the parse tree
	 */
	void exitColourPrint(@NotNull BoxTypesParser.ColourPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#boxType}.
	 * @param ctx the parse tree
	 */
	void enterBoxType(@NotNull BoxTypesParser.BoxTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#boxType}.
	 * @param ctx the parse tree
	 */
	void exitBoxType(@NotNull BoxTypesParser.BoxTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#boxTypes}.
	 * @param ctx the parse tree
	 */
	void enterBoxTypes(@NotNull BoxTypesParser.BoxTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#boxTypes}.
	 * @param ctx the parse tree
	 */
	void exitBoxTypes(@NotNull BoxTypesParser.BoxTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#grades}.
	 * @param ctx the parse tree
	 */
	void enterGrades(@NotNull BoxTypesParser.GradesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#grades}.
	 * @param ctx the parse tree
	 */
	void exitGrades(@NotNull BoxTypesParser.GradesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull BoxTypesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull BoxTypesParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#reinforcedCorners}.
	 * @param ctx the parse tree
	 */
	void enterReinforcedCorners(@NotNull BoxTypesParser.ReinforcedCornersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#reinforcedCorners}.
	 * @param ctx the parse tree
	 */
	void exitReinforcedCorners(@NotNull BoxTypesParser.ReinforcedCornersContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoxTypesParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(@NotNull BoxTypesParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoxTypesParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(@NotNull BoxTypesParser.ChoiceContext ctx);
}