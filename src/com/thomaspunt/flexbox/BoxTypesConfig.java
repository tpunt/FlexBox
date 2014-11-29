package com.thomaspunt.flexbox;

import java.util.ArrayList;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.thomaspunt.flexbox.boxtypesconfigloader.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Parse the box types configuration file using the classes created via code generation
 * from the Antlr tool. The data is pulled from traversing the abstract syntax tree (AST)
 * and populate a BoxType object, which is then inserted into the boxTypes instance
 * variable.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxTypesConfig
{
    /**
     * Holds all of the business logic (in BoxType objects) that is pull from traversing
     * the abstract syntax tree.
     */
    private ArrayList<BoxType> boxTypes = new ArrayList<>();

    /**
     * The default configuration file for storing box types (if one is not specified
     * on class instantiation).
     */
    private static final String boxTypesConfigFile = System.getProperty("user.dir")
                                            + "/src/com/thomaspunt/flexbox/config/boxTypes.dsl";

    /**
     * Parse the box types dsl file and populate the boxTypes arraylist with the valid box
     * types specified.
     *
     * @param  fileName               The name of the config file to be loaded in.
     * @throws FileNotFoundException  Thrown if the target config file cannot be found.
     * @throws IOException            Thrown if there is a problem parsing the config file.
     */
    public BoxTypesConfig(String fileName) throws FileNotFoundException, IOException
    {
        boxTypes = walkAST(loadAST(fileName));
    }
    
    /**
     * Provide an optional constructor so that the default config file can be loaded.
     *
     * @throws FileNotFoundException  Thrown if the box sizes config file cannot be found.
     * @throws IOException            Thrown if there is a problem parsing the config file.
     */
    public BoxTypesConfig() throws FileNotFoundException, IOException
    {
        this(boxTypesConfigFile);
    }
    
    /**
     * Get all the box types as an arraylist of BoxType objects.
     *
     * @return  The boxTypes instance variable containing all valid box types.
     */
    public ArrayList<BoxType> getBoxTypes()
    {
        return boxTypes;
    }

    /**
     * Take the input file (boxTypes.dsl), put it through the lexer to generate a token
     * stream, then feed the token stream to the parser to produce an abstract syntax
     * tree (which is in the form of a ParseTree object).
     *
     * @param  fileName               The name of the config file to be loaded in.
     * @return                        The abstract syntax tree as a ParseTree object.
     * @throws FileNotFoundException  Thrown if the box sizes config file cannot be found.
     * @throws IOException            Thrown if there is a problem parsing the config file.
     */
    private ParseTree loadAST(String fileName) throws FileNotFoundException, IOException
    {
        // create a CharStream that reads from the input file
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(fileName));

        // create a lexer that takes the input of the CharStream
        BoxTypesLexer lexer = new BoxTypesLexer(input);

        // create a buffer of tokens that have been pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that takes in the buffer of tokens
        BoxTypesParser parser = new BoxTypesParser(tokens);

        // set the parsing to begin at the root rule (boxtypes) and return the ParseTree
        return parser.boxTypes();
    }

    /**
     * Walk the abstract syntax tree to pull all of the business logic from it and
     * put it into an arraylist of BoxType objects.
     *
     * @param  pTree  The ParseTree object containing the abstract syntax tree.
     * @return        The business logic pulled from the abstract syntax tree.
     */
    private ArrayList<BoxType> walkAST(ParseTree pTree)
    {
        ParseTreeWalker astWalker = new ParseTreeWalker();

        PullBoxTypeInformation boxTypeInfo = new PullBoxTypeInformation();

        astWalker.walk(boxTypeInfo, pTree);
        
        return boxTypeInfo.boxTypes;
    }

    /**
     * This class extends the BoxTypesBaseListener class whose methods correspond to the
     * production rules specified in my EBNF grammar file (BoxTypes.g4). These methods are
     * automatically invoked as their corresponding nodes in the abstract syntax tree are
     * traversed.
     * <p>
     * I am overriding the relevant default implementation methods of the BoxTypesBaseListener
     * class to enable the pulling of values from the nodes to populate BoxType objects.
     */
    private final class PullBoxTypeInformation extends BoxTypesBaseListener
    {
        /**
         * Holds all of the business logic (in BoxType objects) that is pull from traversing
         * the abstract syntax tree.
         */
        private final ArrayList<BoxType> boxTypes = new ArrayList<>();

        /**
         * The current box number in the boxTypes arraylist. This is incremented upon
         * entering a new box type (from the enterBoxType() method).
         */
        private int currentBox = -1;

        /**
         * Get the box type value, create a new BoxType object, and insert this BoxType
         * object into the boxTypes arraylist instance variable.
         * <p>
         * This method is invoked upon entering the `boxType` production rule.
         */
        @Override
        public void enterBoxType(BoxTypesParser.BoxTypeContext ctx)
        {
            ++currentBox;

            boxTypes.add(new BoxType(Integer.parseInt(ctx.type().INT().toString())));
        }

        /**
         * Get the box grades and update the current BoxType object with it.
         * <p>
         * This method is invoked upon entering the `grades` production rule.
         */
        @Override
        public void enterGrades(BoxTypesParser.GradesContext ctx)
        {
            for(TerminalNode grade : ctx.ints().INT())
                boxTypes.get(currentBox).addGrade(Integer.parseInt(grade.toString()));
        }

        /**
         * Get the box colour print and update the current BoxType object with it.
         * <p>
         * This method is invoked upon entering the `colourPrint` production rule.
         */
        @Override
        public void enterColourPrint(BoxTypesParser.ColourPrintContext ctx)
        {
            boxTypes.get(currentBox).setPrint(Integer.parseInt(ctx.INT().toString()));
        }

        /**
         * Get whether the box has a reinforced bottom and update the current BoxType object
         * with it.
         * <p>
         * This method is invoked upon entering the `reinforcedBottom` production rule.
         */
        @Override
        public void enterReinforcedBottom(BoxTypesParser.ReinforcedBottomContext ctx)
        {
            boxTypes.get(currentBox).setReinforcedBottom(choiceEvaluater(ctx.choice().getText()));
        }

        /**
         * Get whether the box has reinforced corners and update the current BoxType object
         * with it.
         * <p>
         * This method is invoked upon entering the `reinforcedCorners` production rule.
         */
        @Override
        public void enterReinforcedCorners(BoxTypesParser.ReinforcedCornersContext ctx)
        {
            boxTypes.get(currentBox).setReinforcedCorners(choiceEvaluater(ctx.choice().getText()));
        }

        /**
         * Evaluate the choice string and return a boolean type.
         */
        private boolean choiceEvaluater(String choice)
        {
            return choice.equals("yes");
        }
    }
}