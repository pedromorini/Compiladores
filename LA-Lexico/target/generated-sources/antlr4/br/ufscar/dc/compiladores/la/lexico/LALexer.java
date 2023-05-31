// Generated from br\u005Cufscar\dc\compiladores\la\lexico\LALexer.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO=1, COMENTARIO_ERRADO=2, WS=3, PALAVRA_CHAVE=4, NUM_INT=5, NUM_REAL=6, 
		DELIM=7, OP_ATR=8, OP_ARI=9, OP_REL=10, OP_LOG=11, PAR=12, COL=13, IDENT=14, 
		CADEIA=15, CADEIA_ERRADA=16, SIMBOLOS=17, SIMBOLOS_DESCONHECIDOS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMENTARIO", "COMENTARIO_ERRADO", "WS", "PALAVRA_CHAVE", "NUM_INT", 
			"NUM_REAL", "DELIM", "OP_ATR", "OP_ARI", "OP_REL", "OP_LOG", "PAR", "COL", 
			"IDENT", "CADEIA", "CADEIA_ERRADA", "ESC_SEQ", "SIMBOLOS", "SIMBOLOS_DESCONHECIDOS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "':'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO", "COMENTARIO_ERRADO", "WS", "PALAVRA_CHAVE", "NUM_INT", 
			"NUM_REAL", "DELIM", "OP_ATR", "OP_ARI", "OP_REL", "OP_LOG", "PAR", "COL", 
			"IDENT", "CADEIA", "CADEIA_ERRADA", "SIMBOLOS", "SIMBOLOS_DESCONHECIDOS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LALexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0182\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2"+
		"\3\3\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0132\n\5\3\6\6\6\u0135"+
		"\n\6\r\6\16\6\u0136\3\7\6\7\u013a\n\7\r\7\16\7\u013b\3\7\3\7\6\7\u0140"+
		"\n\7\r\7\16\7\u0141\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0153\n\13\3\f\3\f\3\f\5\f\u0158\n\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\7\17\u0160\n\17\f\17\16\17\u0163\13\17\3\20\3\20\3"+
		"\20\7\20\u0168\n\20\f\20\16\20\u016b\13\20\3\20\3\20\3\21\3\21\3\21\7"+
		"\21\u0172\n\21\f\21\16\21\u0175\13\21\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\5\23\u017f\n\23\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\23\'\24\3\2\13"+
		"\5\2\f\f\17\17\177\177\5\2\13\f\17\17\"\"\6\2\'\',-//\61\61\4\2>>@@\4"+
		"\2]]__\5\2C\\aac|\6\2\62;C\\aac|\5\2\f\f$$^^\6\2((..\60\60``\2\u01b2\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\3)\3\2\2\2\5\63\3\2\2\2\7<\3\2\2\2\t\u0131\3\2\2\2\13\u0134"+
		"\3\2\2\2\r\u0139\3\2\2\2\17\u0143\3\2\2\2\21\u0145\3\2\2\2\23\u0148\3"+
		"\2\2\2\25\u0152\3\2\2\2\27\u0157\3\2\2\2\31\u0159\3\2\2\2\33\u015b\3\2"+
		"\2\2\35\u015d\3\2\2\2\37\u0164\3\2\2\2!\u016e\3\2\2\2#\u0178\3\2\2\2%"+
		"\u017e\3\2\2\2\'\u0180\3\2\2\2)-\7}\2\2*,\n\2\2\2+*\3\2\2\2,/\3\2\2\2"+
		"-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\177\2\2\61\62\b\2\2"+
		"\2\62\4\3\2\2\2\63\67\7}\2\2\64\66\n\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67"+
		"\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7\f\2\2;\6\3\2\2\2<=\t"+
		"\3\2\2=>\b\4\3\2>\b\3\2\2\2?@\7c\2\2@A\7n\2\2AB\7i\2\2BC\7q\2\2CD\7t\2"+
		"\2DE\7k\2\2EF\7v\2\2FG\7o\2\2G\u0132\7q\2\2HI\7h\2\2IJ\7k\2\2JK\7o\2\2"+
		"KL\7a\2\2LM\7c\2\2MN\7n\2\2NO\7i\2\2OP\7q\2\2PQ\7t\2\2QR\7k\2\2RS\7v\2"+
		"\2ST\7o\2\2T\u0132\7q\2\2UV\7f\2\2VW\7g\2\2WX\7e\2\2XY\7n\2\2YZ\7c\2\2"+
		"Z[\7t\2\2[\u0132\7g\2\2\\]\7e\2\2]^\7q\2\2^_\7p\2\2_`\7u\2\2`a\7v\2\2"+
		"ab\7c\2\2bc\7p\2\2cd\7v\2\2d\u0132\7g\2\2ef\7v\2\2fg\7k\2\2gh\7r\2\2h"+
		"\u0132\7q\2\2ij\7n\2\2jk\7k\2\2kl\7v\2\2lm\7g\2\2mn\7t\2\2no\7c\2\2o\u0132"+
		"\7n\2\2pq\7k\2\2qr\7p\2\2rs\7v\2\2st\7g\2\2tu\7k\2\2uv\7t\2\2v\u0132\7"+
		"q\2\2wx\7t\2\2xy\7g\2\2yz\7c\2\2z\u0132\7n\2\2{|\7n\2\2|}\7q\2\2}~\7i"+
		"\2\2~\177\7k\2\2\177\u0080\7e\2\2\u0080\u0132\7q\2\2\u0081\u0082\7x\2"+
		"\2\u0082\u0083\7g\2\2\u0083\u0084\7t\2\2\u0084\u0085\7f\2\2\u0085\u0086"+
		"\7c\2\2\u0086\u0087\7f\2\2\u0087\u0088\7g\2\2\u0088\u0089\7k\2\2\u0089"+
		"\u008a\7t\2\2\u008a\u0132\7q\2\2\u008b\u008c\7h\2\2\u008c\u008d\7c\2\2"+
		"\u008d\u008e\7n\2\2\u008e\u008f\7u\2\2\u008f\u0132\7q\2\2\u0090\u0091"+
		"\7t\2\2\u0091\u0092\7g\2\2\u0092\u0093\7i\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7u\2\2\u0095\u0096\7v\2\2\u0096\u0097\7t\2\2\u0097\u0132\7q\2\2"+
		"\u0098\u0099\7h\2\2\u0099\u009a\7k\2\2\u009a\u009b\7o\2\2\u009b\u009c"+
		"\7a\2\2\u009c\u009d\7t\2\2\u009d\u009e\7g\2\2\u009e\u009f\7i\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7t\2\2"+
		"\u00a3\u0132\7q\2\2\u00a4\u00a5\7r\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7f\2\2\u00aa"+
		"\u00ab\7k\2\2\u00ab\u00ac\7o\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7p\2\2"+
		"\u00ae\u00af\7v\2\2\u00af\u0132\7q\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2"+
		"\7k\2\2\u00b2\u00b3\7o\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7r\2\2\u00b5"+
		"\u00b6\7t\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9\u00ba\7f\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd"+
		"\7g\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7v\2\2\u00bf\u0132\7q\2\2\u00c0"+
		"\u00c1\7h\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7e\2\2"+
		"\u00c4\u00c5\7c\2\2\u00c5\u0132\7q\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8"+
		"\7k\2\2\u00c8\u00c9\7o\2\2\u00c9\u00ca\7a\2\2\u00ca\u00cb\7h\2\2\u00cb"+
		"\u00cc\7w\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7c\2\2"+
		"\u00cf\u0132\7q\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7c\2\2\u00d2\u0132"+
		"\7t\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7k\2\2\u00d6"+
		"\u0132\7c\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7e\2\2"+
		"\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7x\2\2\u00dd\u0132"+
		"\7c\2\2\u00de\u00df\7u\2\2\u00df\u0132\7g\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"\u00e2\7p\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7c\2\2\u00e4\u0132\7q\2\2"+
		"\u00e5\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9"+
		"\7c\2\2\u00e9\u0132\7q\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7k\2\2\u00ec"+
		"\u00ed\7o\2\2\u00ed\u00ee\7a\2\2\u00ee\u00ef\7u\2\2\u00ef\u0132\7g\2\2"+
		"\u00f0\u00f1\7e\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7u\2\2\u00f3\u0132"+
		"\7q\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7l\2\2\u00f7"+
		"\u0132\7c\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7o\2\2"+
		"\u00fb\u00fc\7a\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff"+
		"\7u\2\2\u00ff\u0132\7q\2\2\u0100\u0101\7r\2\2\u0101\u0102\7c\2\2\u0102"+
		"\u0103\7t\2\2\u0103\u0132\7c\2\2\u0104\u0105\7c\2\2\u0105\u0106\7v\2\2"+
		"\u0106\u0132\7g\2\2\u0107\u0108\7h\2\2\u0108\u0109\7c\2\2\u0109\u010a"+
		"\7e\2\2\u010a\u0132\7c\2\2\u010b\u010c\7h\2\2\u010c\u010d\7k\2\2\u010d"+
		"\u010e\7o\2\2\u010e\u010f\7a\2\2\u010f\u0110\7r\2\2\u0110\u0111\7c\2\2"+
		"\u0111\u0112\7t\2\2\u0112\u0132\7c\2\2\u0113\u0114\7g\2\2\u0114\u0115"+
		"\7p\2\2\u0115\u0116\7s\2\2\u0116\u0117\7w\2\2\u0117\u0118\7c\2\2\u0118"+
		"\u0119\7p\2\2\u0119\u011a\7v\2\2\u011a\u0132\7q\2\2\u011b\u011c\7h\2\2"+
		"\u011c\u011d\7k\2\2\u011d\u011e\7o\2\2\u011e\u011f\7a\2\2\u011f\u0120"+
		"\7g\2\2\u0120\u0121\7p\2\2\u0121\u0122\7s\2\2\u0122\u0123\7w\2\2\u0123"+
		"\u0124\7c\2\2\u0124\u0125\7p\2\2\u0125\u0126\7v\2\2\u0126\u0132\7q\2\2"+
		"\u0127\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u012a\7v\2\2\u012a\u012b"+
		"\7q\2\2\u012b\u012c\7t\2\2\u012c\u012d\7p\2\2\u012d\u0132\7g\2\2\u012e"+
		"\u012f\7p\2\2\u012f\u0130\7c\2\2\u0130\u0132\7q\2\2\u0131?\3\2\2\2\u0131"+
		"H\3\2\2\2\u0131U\3\2\2\2\u0131\\\3\2\2\2\u0131e\3\2\2\2\u0131i\3\2\2\2"+
		"\u0131p\3\2\2\2\u0131w\3\2\2\2\u0131{\3\2\2\2\u0131\u0081\3\2\2\2\u0131"+
		"\u008b\3\2\2\2\u0131\u0090\3\2\2\2\u0131\u0098\3\2\2\2\u0131\u00a4\3\2"+
		"\2\2\u0131\u00b0\3\2\2\2\u0131\u00c0\3\2\2\2\u0131\u00c6\3\2\2\2\u0131"+
		"\u00d0\3\2\2\2\u0131\u00d3\3\2\2\2\u0131\u00d7\3\2\2\2\u0131\u00de\3\2"+
		"\2\2\u0131\u00e0\3\2\2\2\u0131\u00e5\3\2\2\2\u0131\u00ea\3\2\2\2\u0131"+
		"\u00f0\3\2\2\2\u0131\u00f4\3\2\2\2\u0131\u00f8\3\2\2\2\u0131\u0100\3\2"+
		"\2\2\u0131\u0104\3\2\2\2\u0131\u0107\3\2\2\2\u0131\u010b\3\2\2\2\u0131"+
		"\u0113\3\2\2\2\u0131\u011b\3\2\2\2\u0131\u0127\3\2\2\2\u0131\u012e\3\2"+
		"\2\2\u0132\n\3\2\2\2\u0133\u0135\4\62;\2\u0134\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\f\3\2\2\2\u0138"+
		"\u013a\4\62;\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\7\60\2\2\u013e"+
		"\u0140\4\62;\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\16\3\2\2\2\u0143\u0144\7<\2\2\u0144\20"+
		"\3\2\2\2\u0145\u0146\7>\2\2\u0146\u0147\7/\2\2\u0147\22\3\2\2\2\u0148"+
		"\u0149\t\4\2\2\u0149\24\3\2\2\2\u014a\u0153\7?\2\2\u014b\u014c\7>\2\2"+
		"\u014c\u0153\7@\2\2\u014d\u0153\t\5\2\2\u014e\u014f\7@\2\2\u014f\u0153"+
		"\7?\2\2\u0150\u0151\7>\2\2\u0151\u0153\7?\2\2\u0152\u014a\3\2\2\2\u0152"+
		"\u014b\3\2\2\2\u0152\u014d\3\2\2\2\u0152\u014e\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0153\26\3\2\2\2\u0154\u0158\7g\2\2\u0155\u0156\7q\2\2\u0156\u0158"+
		"\7w\2\2\u0157\u0154\3\2\2\2\u0157\u0155\3\2\2\2\u0158\30\3\2\2\2\u0159"+
		"\u015a\4*+\2\u015a\32\3\2\2\2\u015b\u015c\t\6\2\2\u015c\34\3\2\2\2\u015d"+
		"\u0161\t\7\2\2\u015e\u0160\t\b\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\36\3\2\2\2\u0163\u0161"+
		"\3\2\2\2\u0164\u0169\7$\2\2\u0165\u0168\5#\22\2\u0166\u0168\n\t\2\2\u0167"+
		"\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c"+
		"\u016d\7$\2\2\u016d \3\2\2\2\u016e\u0173\7$\2\2\u016f\u0172\5#\22\2\u0170"+
		"\u0172\n\t\2\2\u0171\u016f\3\2\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2"+
		"\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0176\u0177\7\f\2\2\u0177\"\3\2\2\2\u0178\u0179\7^\2\2"+
		"\u0179\u017a\7$\2\2\u017a$\3\2\2\2\u017b\u017f\t\n\2\2\u017c\u017d\7\60"+
		"\2\2\u017d\u017f\7\60\2\2\u017e\u017b\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"&\3\2\2\2\u0180\u0181\13\2\2\2\u0181(\3\2\2\2\21\2-\67\u0131\u0136\u013b"+
		"\u0141\u0152\u0157\u0161\u0167\u0169\u0171\u0173\u017e\4\3\2\2\3\4\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}