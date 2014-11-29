// Generated from com/thomaspunt/flexbox/boxtypesconfigloader/BoxTypes.g4 by ANTLR 4.4
package com.thomaspunt.flexbox.boxtypesconfigloader;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoxTypesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, SEP=2, WS=3, COMMA=4, TYPE=5, GR=6, CP=7, RB=8, RC=9, YES=10, NO=11, 
		ANSWER=12;
	public static final String[] tokenNames = {
		"<INVALID>", "INT", "':'", "WS", "','", "'Type'", "'grades'", "'colourPrint'", 
		"'reinforcedBottom'", "'reinforcedCorners'", "'yes'", "'no'", "ANSWER"
	};
	public static final int
		RULE_ints = 0, RULE_type = 1, RULE_grades = 2, RULE_colourPrint = 3, RULE_reinforcedBottom = 4, 
		RULE_reinforcedCorners = 5, RULE_choice = 6, RULE_boxType = 7, RULE_boxTypes = 8;
	public static final String[] ruleNames = {
		"ints", "type", "grades", "colourPrint", "reinforcedBottom", "reinforcedCorners", 
		"choice", "boxType", "boxTypes"
	};

	@Override
	public String getGrammarFileName() { return "BoxTypes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BoxTypesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class IntsContext extends ParserRuleContext {
		public Token INT;
		public List<Token> element = new ArrayList<Token>();
		public TerminalNode INT(int i) {
			return getToken(BoxTypesParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoxTypesParser.COMMA); }
		public List<TerminalNode> INT() { return getTokens(BoxTypesParser.INT); }
		public TerminalNode COMMA(int i) {
			return getToken(BoxTypesParser.COMMA, i);
		}
		public IntsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterInts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitInts(this);
		}
	}

	public final IntsContext ints() throws RecognitionException {
		IntsContext _localctx = new IntsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); ((IntsContext)_localctx).INT = match(INT);
			((IntsContext)_localctx).element.add(((IntsContext)_localctx).INT);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(19); match(COMMA);
				setState(20); ((IntsContext)_localctx).INT = match(INT);
				((IntsContext)_localctx).element.add(((IntsContext)_localctx).INT);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(BoxTypesParser.TYPE, 0); }
		public TerminalNode INT() { return getToken(BoxTypesParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(TYPE);
			setState(27); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GradesContext extends ParserRuleContext {
		public TerminalNode GR() { return getToken(BoxTypesParser.GR, 0); }
		public IntsContext ints() {
			return getRuleContext(IntsContext.class,0);
		}
		public TerminalNode SEP() { return getToken(BoxTypesParser.SEP, 0); }
		public GradesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grades; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterGrades(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitGrades(this);
		}
	}

	public final GradesContext grades() throws RecognitionException {
		GradesContext _localctx = new GradesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_grades);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(GR);
			setState(30); match(SEP);
			setState(31); ints();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColourPrintContext extends ParserRuleContext {
		public TerminalNode SEP() { return getToken(BoxTypesParser.SEP, 0); }
		public TerminalNode INT() { return getToken(BoxTypesParser.INT, 0); }
		public TerminalNode CP() { return getToken(BoxTypesParser.CP, 0); }
		public ColourPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colourPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterColourPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitColourPrint(this);
		}
	}

	public final ColourPrintContext colourPrint() throws RecognitionException {
		ColourPrintContext _localctx = new ColourPrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_colourPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(CP);
			setState(34); match(SEP);
			setState(35); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReinforcedBottomContext extends ParserRuleContext {
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode SEP() { return getToken(BoxTypesParser.SEP, 0); }
		public TerminalNode RB() { return getToken(BoxTypesParser.RB, 0); }
		public ReinforcedBottomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reinforcedBottom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterReinforcedBottom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitReinforcedBottom(this);
		}
	}

	public final ReinforcedBottomContext reinforcedBottom() throws RecognitionException {
		ReinforcedBottomContext _localctx = new ReinforcedBottomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_reinforcedBottom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(RB);
			setState(38); match(SEP);
			setState(39); choice();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReinforcedCornersContext extends ParserRuleContext {
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode RC() { return getToken(BoxTypesParser.RC, 0); }
		public TerminalNode SEP() { return getToken(BoxTypesParser.SEP, 0); }
		public ReinforcedCornersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reinforcedCorners; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterReinforcedCorners(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitReinforcedCorners(this);
		}
	}

	public final ReinforcedCornersContext reinforcedCorners() throws RecognitionException {
		ReinforcedCornersContext _localctx = new ReinforcedCornersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_reinforcedCorners);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); match(RC);
			setState(42); match(SEP);
			setState(43); choice();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode YES() { return getToken(BoxTypesParser.YES, 0); }
		public TerminalNode NO() { return getToken(BoxTypesParser.NO, 0); }
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitChoice(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==YES || _la==NO) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoxTypeContext extends ParserRuleContext {
		public GradesContext grades() {
			return getRuleContext(GradesContext.class,0);
		}
		public ReinforcedBottomContext reinforcedBottom() {
			return getRuleContext(ReinforcedBottomContext.class,0);
		}
		public ColourPrintContext colourPrint() {
			return getRuleContext(ColourPrintContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BoxTypesParser.EOF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReinforcedCornersContext reinforcedCorners() {
			return getRuleContext(ReinforcedCornersContext.class,0);
		}
		public BoxTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boxType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterBoxType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitBoxType(this);
		}
	}

	public final BoxTypeContext boxType() throws RecognitionException {
		BoxTypeContext _localctx = new BoxTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boxType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); type();
			setState(48); grades();
			setState(49); colourPrint();
			setState(50); reinforcedBottom();
			setState(51); reinforcedCorners();
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(52); match(EOF);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoxTypesContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BoxTypesParser.EOF, 0); }
		public BoxTypeContext boxType(int i) {
			return getRuleContext(BoxTypeContext.class,i);
		}
		public List<BoxTypeContext> boxType() {
			return getRuleContexts(BoxTypeContext.class);
		}
		public BoxTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boxTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).enterBoxTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoxTypesListener ) ((BoxTypesListener)listener).exitBoxTypes(this);
		}
	}

	public final BoxTypesContext boxTypes() throws RecognitionException {
		BoxTypesContext _localctx = new BoxTypesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boxTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55); boxType();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TYPE );
			setState(60); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16A\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"8\n\t\3\n\6\n;\n\n\r\n\16\n<\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2"+
		"\3\3\2\f\r:\2\24\3\2\2\2\4\34\3\2\2\2\6\37\3\2\2\2\b#\3\2\2\2\n\'\3\2"+
		"\2\2\f+\3\2\2\2\16/\3\2\2\2\20\61\3\2\2\2\22:\3\2\2\2\24\31\7\3\2\2\25"+
		"\26\7\6\2\2\26\30\7\3\2\2\27\25\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31"+
		"\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34\35\7\7\2\2\35\36\7\3\2\2\36"+
		"\5\3\2\2\2\37 \7\b\2\2 !\7\4\2\2!\"\5\2\2\2\"\7\3\2\2\2#$\7\t\2\2$%\7"+
		"\4\2\2%&\7\3\2\2&\t\3\2\2\2\'(\7\n\2\2()\7\4\2\2)*\5\16\b\2*\13\3\2\2"+
		"\2+,\7\13\2\2,-\7\4\2\2-.\5\16\b\2.\r\3\2\2\2/\60\t\2\2\2\60\17\3\2\2"+
		"\2\61\62\5\4\3\2\62\63\5\6\4\2\63\64\5\b\5\2\64\65\5\n\6\2\65\67\5\f\7"+
		"\2\668\7\2\2\3\67\66\3\2\2\2\678\3\2\2\28\21\3\2\2\29;\5\20\t\2:9\3\2"+
		"\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\2\2\3?\23\3\2\2\2\5\31"+
		"\67<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}