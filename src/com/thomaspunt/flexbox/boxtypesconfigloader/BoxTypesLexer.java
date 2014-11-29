// Generated from com/thomaspunt/flexbox/boxtypesconfigloader/BoxTypes.g4 by ANTLR 4.4
package com.thomaspunt.flexbox.boxtypesconfigloader;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoxTypesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, SEP=2, WS=3, COMMA=4, TYPE=5, GR=6, CP=7, RB=8, RC=9, YES=10, NO=11, 
		ANSWER=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"INT", "SEP", "WS", "COMMA", "TYPE", "GR", "CP", "RB", "RC", "YES", "NO", 
		"ANSWER"
	};


	public BoxTypesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BoxTypes.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3\3\4\6\4$\n\4\r"+
		"\4\16\4%\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\5\rp\n\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\3\2\4\3\2\62;\5\2\13\f\17\17\"\"s\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\3\34\3\2\2\2\5 \3\2\2\2\7#\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r\60\3\2\2"+
		"\2\17\67\3\2\2\2\21C\3\2\2\2\23T\3\2\2\2\25f\3\2\2\2\27j\3\2\2\2\31o\3"+
		"\2\2\2\33\35\t\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3"+
		"\2\2\2\37\4\3\2\2\2 !\7<\2\2!\6\3\2\2\2\"$\t\3\2\2#\"\3\2\2\2$%\3\2\2"+
		"\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\b\4\2\2(\b\3\2\2\2)*\7.\2\2*\n\3"+
		"\2\2\2+,\7V\2\2,-\7{\2\2-.\7r\2\2./\7g\2\2/\f\3\2\2\2\60\61\7i\2\2\61"+
		"\62\7t\2\2\62\63\7c\2\2\63\64\7f\2\2\64\65\7g\2\2\65\66\7u\2\2\66\16\3"+
		"\2\2\2\678\7e\2\289\7q\2\29:\7n\2\2:;\7q\2\2;<\7w\2\2<=\7t\2\2=>\7R\2"+
		"\2>?\7t\2\2?@\7k\2\2@A\7p\2\2AB\7v\2\2B\20\3\2\2\2CD\7t\2\2DE\7g\2\2E"+
		"F\7k\2\2FG\7p\2\2GH\7h\2\2HI\7q\2\2IJ\7t\2\2JK\7e\2\2KL\7g\2\2LM\7f\2"+
		"\2MN\7D\2\2NO\7q\2\2OP\7v\2\2PQ\7v\2\2QR\7q\2\2RS\7o\2\2S\22\3\2\2\2T"+
		"U\7t\2\2UV\7g\2\2VW\7k\2\2WX\7p\2\2XY\7h\2\2YZ\7q\2\2Z[\7t\2\2[\\\7e\2"+
		"\2\\]\7g\2\2]^\7f\2\2^_\7E\2\2_`\7q\2\2`a\7t\2\2ab\7p\2\2bc\7g\2\2cd\7"+
		"t\2\2de\7u\2\2e\24\3\2\2\2fg\7{\2\2gh\7g\2\2hi\7u\2\2i\26\3\2\2\2jk\7"+
		"p\2\2kl\7q\2\2l\30\3\2\2\2mp\5\25\13\2np\5\27\f\2om\3\2\2\2on\3\2\2\2"+
		"p\32\3\2\2\2\6\2\36%o\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}