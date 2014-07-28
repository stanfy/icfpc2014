// Generated from /Users/hdf/projects/icfp2014/src/main/antlr/Clojure.g4 by ANTLR 4.4
package com.stanfy.icfp2014.clojure;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClojureLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, STRING=18, NUMBER=19, CHARACTER=20, NIL=21, BOOLEAN=22, KEYWORD=23, 
		SYMBOL=24, PARAM_NAME=25, WS=26, COMMENT=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"STRING", "NUMBER", "CHARACTER", "NIL", "BOOLEAN", "KEYWORD", "SYMBOL", 
		"PARAM_NAME", "NAME", "SYMBOL_HEAD", "SYMBOL_REST", "WS", "COMMENT"
	};


	public ClojureLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Clojure.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\7\23j\n\23\f\23\16\23m\13\23"+
		"\3\23\3\23\3\24\5\24r\n\24\3\24\6\24u\n\24\r\24\16\24v\3\24\3\24\6\24"+
		"{\n\24\r\24\16\24|\5\24\177\n\24\3\24\3\24\5\24\u0083\n\24\3\24\6\24\u0086"+
		"\n\24\r\24\16\24\u0087\5\24\u008a\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u009c\n\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u00a5\n\31\5\31\u00a7\n\31\3\32\3"+
		"\32\3\32\7\32\u00ac\n\32\f\32\16\32\u00af\13\32\5\32\u00b1\n\32\3\33\3"+
		"\33\7\33\u00b5\n\33\f\33\16\33\u00b8\13\33\3\33\3\33\6\33\u00bc\n\33\r"+
		"\33\16\33\u00bd\7\33\u00c0\n\33\f\33\16\33\u00c3\13\33\3\34\3\34\3\35"+
		"\3\35\5\35\u00c9\n\35\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u00d1\n\37\f"+
		"\37\16\37\u00d4\13\37\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\2\67\29\2;\34=\35\3\2\t\3\2$$\3\2\62;\4\2GGgg\n\2"+
		"##&&,-//>AC\\aac|\5\2((\60\60\62;\7\2\13\f\17\17\"\"..^^\4\2\f\f\17\17"+
		"\u00e6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5"+
		"B\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21"+
		"O\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31X\3\2\2\2\33Z\3\2\2\2"+
		"\35]\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#c\3\2\2\2%e\3\2\2\2\'q\3\2\2\2)\u008b"+
		"\3\2\2\2+\u008e\3\2\2\2-\u009b\3\2\2\2/\u009d\3\2\2\2\61\u00a6\3\2\2\2"+
		"\63\u00a8\3\2\2\2\65\u00b2\3\2\2\2\67\u00c4\3\2\2\29\u00c8\3\2\2\2;\u00ca"+
		"\3\2\2\2=\u00ce\3\2\2\2?@\7%\2\2@A\7`\2\2A\4\3\2\2\2BC\7%\2\2CD\7)\2\2"+
		"D\6\3\2\2\2EF\7}\2\2F\b\3\2\2\2GH\7]\2\2H\n\3\2\2\2IJ\7\177\2\2J\f\3\2"+
		"\2\2KL\7_\2\2L\16\3\2\2\2MN\7`\2\2N\20\3\2\2\2OP\7\u0080\2\2P\22\3\2\2"+
		"\2QR\7B\2\2R\24\3\2\2\2ST\7b\2\2T\26\3\2\2\2UV\7\u0080\2\2VW\7B\2\2W\30"+
		"\3\2\2\2XY\7%\2\2Y\32\3\2\2\2Z[\7%\2\2[\\\7*\2\2\\\34\3\2\2\2]^\7(\2\2"+
		"^\36\3\2\2\2_`\7)\2\2` \3\2\2\2ab\7*\2\2b\"\3\2\2\2cd\7+\2\2d$\3\2\2\2"+
		"ek\7$\2\2fj\n\2\2\2gh\7^\2\2hj\7$\2\2if\3\2\2\2ig\3\2\2\2jm\3\2\2\2ki"+
		"\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7$\2\2o&\3\2\2\2pr\7/\2\2qp\3"+
		"\2\2\2qr\3\2\2\2rt\3\2\2\2su\t\3\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2w~\3\2\2\2xz\7\60\2\2y{\t\3\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}"+
		"\3\2\2\2}\177\3\2\2\2~x\3\2\2\2~\177\3\2\2\2\177\u0089\3\2\2\2\u0080\u0082"+
		"\t\4\2\2\u0081\u0083\7/\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084\u0086\t\3\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u0080\3\2\2\2\u0089\u008a\3\2\2\2\u008a(\3\2\2\2\u008b\u008c\7^\2\2\u008c"+
		"\u008d\13\2\2\2\u008d*\3\2\2\2\u008e\u008f\7p\2\2\u008f\u0090\7k\2\2\u0090"+
		"\u0091\7n\2\2\u0091,\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7w\2\2\u0095\u009c\7g\2\2\u0096\u0097\7h\2\2\u0097\u0098\7c\2\2"+
		"\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009c\7g\2\2\u009b\u0092"+
		"\3\2\2\2\u009b\u0096\3\2\2\2\u009c.\3\2\2\2\u009d\u009e\7<\2\2\u009e\u009f"+
		"\5\61\31\2\u009f\60\3\2\2\2\u00a0\u00a7\4\60\61\2\u00a1\u00a4\5\65\33"+
		"\2\u00a2\u00a3\7\61\2\2\u00a3\u00a5\5\65\33\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a1\3\2"+
		"\2\2\u00a7\62\3\2\2\2\u00a8\u00b0\7\'\2\2\u00a9\u00ad\4\63;\2\u00aa\u00ac"+
		"\4\62;\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a9\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\64\3\2\2\2\u00b2\u00b6\5\67\34\2\u00b3"+
		"\u00b5\59\35\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00c1\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bb\7<\2\2\u00ba\u00bc\59\35\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00b9\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\66\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\t\5\2\2\u00c58\3"+
		"\2\2\2\u00c6\u00c9\5\67\34\2\u00c7\u00c9\t\6\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9:\3\2\2\2\u00ca\u00cb\t\7\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cc\u00cd\b\36\2\2\u00cd<\3\2\2\2\u00ce\u00d2\7=\2\2\u00cf\u00d1\n"+
		"\b\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\b\37"+
		"\2\2\u00d6>\3\2\2\2\26\2ikqv|~\u0082\u0087\u0089\u009b\u00a4\u00a6\u00ad"+
		"\u00b0\u00b6\u00bd\u00c1\u00c8\u00d2\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}