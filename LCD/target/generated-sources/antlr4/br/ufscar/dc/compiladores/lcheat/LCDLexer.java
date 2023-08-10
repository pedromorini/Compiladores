// Generated from br\u005Cufscar\dc\compiladores\lcheat\LCD.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.lcheat;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LCDLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, WS=28, PALAVRA_CHAVE=29, IDENT=30, INDICE=31, 
		CADEIA=32, CADEIA_ERRADA=33, SIMBOLOS=34, SIMBOLOS_DESCONHECIDOS=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "WS", "PALAVRA_CHAVE", "IDENT", "INDICE", "CADEIA", 
			"CADEIA_ERRADA", "ESC_SEQ", "SIMBOLOS", "SIMBOLOS_DESCONHECIDOS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nome'", "':'", "'capa'", "'console'", "'ps1'", "'ps2'", "'cheat'", 
			"'<-'", "';'", "','", "'R1'", "'R2'", "'L1'", "'L2'", "'T'", "'Q'", "'X'", 
			"'O'", "'cima'", "'baixo'", "'esquerda'", "'direita'", "'fase'", "'instrucao'", 
			"'fim_instrucao'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "WS", "PALAVRA_CHAVE", "IDENT", "INDICE", "CADEIA", 
			"CADEIA_ERRADA", "SIMBOLOS", "SIMBOLOS_DESCONHECIDOS"
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


	public LCDLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LCD.g4"; }

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
		case 27:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 skip(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0167\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u013d\n\36\3\37\3\37\7\37\u0141\n\37\f\37\16\37\u0144\13\37\3 \3"+
		" \3!\3!\3!\7!\u014b\n!\f!\16!\u014e\13!\3!\3!\3\"\3\"\3\"\7\"\u0155\n"+
		"\"\f\"\16\"\u0158\13\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\5$\u0164\n$\3%"+
		"\3%\2\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E\2G$I%\3\2\b\5\2\13\f\17\17\"\"\6\2QQSSVVZZ\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\3\2$$\6\2..<<]]__\2\u0180\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5P\3\2\2\2\7"+
		"R\3\2\2\2\tW\3\2\2\2\13_\3\2\2\2\rc\3\2\2\2\17g\3\2\2\2\21m\3\2\2\2\23"+
		"p\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31w\3\2\2\2\33z\3\2\2\2\35}\3\2\2\2"+
		"\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088"+
		"\3\2\2\2)\u008d\3\2\2\2+\u0093\3\2\2\2-\u009c\3\2\2\2/\u00a4\3\2\2\2\61"+
		"\u00a9\3\2\2\2\63\u00b3\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2\2\29\u00c5"+
		"\3\2\2\2;\u013c\3\2\2\2=\u013e\3\2\2\2?\u0145\3\2\2\2A\u0147\3\2\2\2C"+
		"\u0151\3\2\2\2E\u015b\3\2\2\2G\u0163\3\2\2\2I\u0165\3\2\2\2KL\7p\2\2L"+
		"M\7q\2\2MN\7o\2\2NO\7g\2\2O\4\3\2\2\2PQ\7<\2\2Q\6\3\2\2\2RS\7e\2\2ST\7"+
		"c\2\2TU\7r\2\2UV\7c\2\2V\b\3\2\2\2WX\7e\2\2XY\7q\2\2YZ\7p\2\2Z[\7u\2\2"+
		"[\\\7q\2\2\\]\7n\2\2]^\7g\2\2^\n\3\2\2\2_`\7r\2\2`a\7u\2\2ab\7\63\2\2"+
		"b\f\3\2\2\2cd\7r\2\2de\7u\2\2ef\7\64\2\2f\16\3\2\2\2gh\7e\2\2hi\7j\2\2"+
		"ij\7g\2\2jk\7c\2\2kl\7v\2\2l\20\3\2\2\2mn\7>\2\2no\7/\2\2o\22\3\2\2\2"+
		"pq\7=\2\2q\24\3\2\2\2rs\7.\2\2s\26\3\2\2\2tu\7T\2\2uv\7\63\2\2v\30\3\2"+
		"\2\2wx\7T\2\2xy\7\64\2\2y\32\3\2\2\2z{\7N\2\2{|\7\63\2\2|\34\3\2\2\2}"+
		"~\7N\2\2~\177\7\64\2\2\177\36\3\2\2\2\u0080\u0081\7V\2\2\u0081 \3\2\2"+
		"\2\u0082\u0083\7S\2\2\u0083\"\3\2\2\2\u0084\u0085\7Z\2\2\u0085$\3\2\2"+
		"\2\u0086\u0087\7Q\2\2\u0087&\3\2\2\2\u0088\u0089\7e\2\2\u0089\u008a\7"+
		"k\2\2\u008a\u008b\7o\2\2\u008b\u008c\7c\2\2\u008c(\3\2\2\2\u008d\u008e"+
		"\7d\2\2\u008e\u008f\7c\2\2\u008f\u0090\7k\2\2\u0090\u0091\7z\2\2\u0091"+
		"\u0092\7q\2\2\u0092*\3\2\2\2\u0093\u0094\7g\2\2\u0094\u0095\7u\2\2\u0095"+
		"\u0096\7s\2\2\u0096\u0097\7w\2\2\u0097\u0098\7g\2\2\u0098\u0099\7t\2\2"+
		"\u0099\u009a\7f\2\2\u009a\u009b\7c\2\2\u009b,\3\2\2\2\u009c\u009d\7f\2"+
		"\2\u009d\u009e\7k\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1"+
		"\7k\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7c\2\2\u00a3.\3\2\2\2\u00a4\u00a5"+
		"\7h\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\60\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7u\2\2\u00ac"+
		"\u00ad\7v\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7e\2\2"+
		"\u00b0\u00b1\7c\2\2\u00b1\u00b2\7q\2\2\u00b2\62\3\2\2\2\u00b3\u00b4\7"+
		"h\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7o\2\2\u00b6\u00b7\7a\2\2\u00b7\u00b8"+
		"\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7e\2\2\u00be\u00bf\7c\2\2"+
		"\u00bf\u00c0\7q\2\2\u00c0\64\3\2\2\2\u00c1\u00c2\7]\2\2\u00c2\66\3\2\2"+
		"\2\u00c3\u00c4\7_\2\2\u00c48\3\2\2\2\u00c5\u00c6\t\2\2\2\u00c6\u00c7\b"+
		"\35\2\2\u00c7:\3\2\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb"+
		"\7o\2\2\u00cb\u013d\7g\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7r\2\2\u00cf\u013d\7c\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2\7q\2\2"+
		"\u00d2\u00d3\7p\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6"+
		"\7n\2\2\u00d6\u013d\7g\2\2\u00d7\u00d8\7r\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"\u013d\7\63\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7u\2\2\u00dc\u013d\7\64"+
		"\2\2\u00dd\u00de\7e\2\2\u00de\u00df\7j\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1"+
		"\7c\2\2\u00e1\u013d\7v\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7p\2\2\u00e4"+
		"\u00e5\7u\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7w\2\2"+
		"\u00e8\u00e9\7e\2\2\u00e9\u00ea\7c\2\2\u00ea\u013d\7q\2\2\u00eb\u00ec"+
		"\7h\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7o\2\2\u00ee\u00ef\7a\2\2\u00ef"+
		"\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7v\2\2"+
		"\u00f3\u00f4\7t\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7e\2\2\u00f6\u00f7"+
		"\7c\2\2\u00f7\u013d\7q\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7u\2\2\u00fa"+
		"\u00fb\7e\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7x\2\2"+
		"\u00fe\u013d\7c\2\2\u00ff\u0100\7h\2\2\u0100\u0101\7c\2\2\u0101\u0102"+
		"\7u\2\2\u0102\u013d\7g\2\2\u0103\u0104\7T\2\2\u0104\u013d\7\63\2\2\u0105"+
		"\u0106\7T\2\2\u0106\u013d\7\64\2\2\u0107\u0108\7N\2\2\u0108\u013d\7\63"+
		"\2\2\u0109\u010a\7N\2\2\u010a\u013d\7\64\2\2\u010b\u013d\t\3\2\2\u010c"+
		"\u010d\7e\2\2\u010d\u010e\7k\2\2\u010e\u010f\7o\2\2\u010f\u013d\7c\2\2"+
		"\u0110\u0111\7d\2\2\u0111\u0112\7c\2\2\u0112\u0113\7k\2\2\u0113\u0114"+
		"\7z\2\2\u0114\u013d\7q\2\2\u0115\u0116\7g\2\2\u0116\u0117\7u\2\2\u0117"+
		"\u0118\7s\2\2\u0118\u0119\7w\2\2\u0119\u011a\7g\2\2\u011a\u011b\7t\2\2"+
		"\u011b\u011c\7f\2\2\u011c\u013d\7c\2\2\u011d\u011e\7f\2\2\u011e\u011f"+
		"\7k\2\2\u011f\u0120\7t\2\2\u0120\u0121\7g\2\2\u0121\u0122\7k\2\2\u0122"+
		"\u0123\7v\2\2\u0123\u013d\7c\2\2\u0124\u0125\7o\2\2\u0125\u0126\7g\2\2"+
		"\u0126\u0127\7k\2\2\u0127\u0128\7c\2\2\u0128\u0129\7a\2\2\u0129\u012a"+
		"\7n\2\2\u012a\u012b\7w\2\2\u012b\u012c\7c\2\2\u012c\u012d\7a\2\2\u012d"+
		"\u012e\7g\2\2\u012e\u012f\7u\2\2\u012f\u013d\7s\2\2\u0130\u0131\7o\2\2"+
		"\u0131\u0132\7g\2\2\u0132\u0133\7k\2\2\u0133\u0134\7c\2\2\u0134\u0135"+
		"\7a\2\2\u0135\u0136\7n\2\2\u0136\u0137\7w\2\2\u0137\u0138\7c\2\2\u0138"+
		"\u0139\7a\2\2\u0139\u013a\7f\2\2\u013a\u013b\7k\2\2\u013b\u013d\7t\2\2"+
		"\u013c\u00c8\3\2\2\2\u013c\u00cc\3\2\2\2\u013c\u00d0\3\2\2\2\u013c\u00d7"+
		"\3\2\2\2\u013c\u00da\3\2\2\2\u013c\u00dd\3\2\2\2\u013c\u00e2\3\2\2\2\u013c"+
		"\u00eb\3\2\2\2\u013c\u00f8\3\2\2\2\u013c\u00ff\3\2\2\2\u013c\u0103\3\2"+
		"\2\2\u013c\u0105\3\2\2\2\u013c\u0107\3\2\2\2\u013c\u0109\3\2\2\2\u013c"+
		"\u010b\3\2\2\2\u013c\u010c\3\2\2\2\u013c\u0110\3\2\2\2\u013c\u0115\3\2"+
		"\2\2\u013c\u011d\3\2\2\2\u013c\u0124\3\2\2\2\u013c\u0130\3\2\2\2\u013d"+
		"<\3\2\2\2\u013e\u0142\t\4\2\2\u013f\u0141\t\5\2\2\u0140\u013f\3\2\2\2"+
		"\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143>\3"+
		"\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\4\62;\2\u0146@\3\2\2\2\u0147\u014c"+
		"\7$\2\2\u0148\u014b\5E#\2\u0149\u014b\n\6\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7$\2\2\u0150"+
		"B\3\2\2\2\u0151\u0156\7$\2\2\u0152\u0155\5E#\2\u0153\u0155\n\6\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159"+
		"\u015a\7\f\2\2\u015aD\3\2\2\2\u015b\u015c\7^\2\2\u015c\u015d\7$\2\2\u015d"+
		"F\3\2\2\2\u015e\u0164\t\7\2\2\u015f\u0160\7>\2\2\u0160\u0164\7/\2\2\u0161"+
		"\u0162\7>\2\2\u0162\u0164\7@\2\2\u0163\u015e\3\2\2\2\u0163\u015f\3\2\2"+
		"\2\u0163\u0161\3\2\2\2\u0164H\3\2\2\2\u0165\u0166\13\2\2\2\u0166J\3\2"+
		"\2\2\n\2\u013c\u0142\u014a\u014c\u0154\u0156\u0163\3\3\35\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}