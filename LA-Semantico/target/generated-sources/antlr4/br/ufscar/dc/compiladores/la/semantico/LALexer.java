// Generated from br\u005Cufscar\dc\compiladores\la\semantico\LA.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.semantico;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, COMENTARIO=58, COMENTARIO_ERRADO=59, 
		WS=60, PALAVRA_CHAVE=61, NUM_INT=62, NUM_REAL=63, DELIM=64, OP_ATR=65, 
		OP_ARI=66, OP_REL=67, OP_LOG=68, PAR=69, COL=70, IDENT=71, CADEIA=72, 
		CADEIA_ERRADA=73, SIMBOLOS=74, SIMBOLOS_DESCONHECIDOS=75;
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
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"COMENTARIO", "COMENTARIO_ERRADO", "WS", "PALAVRA_CHAVE", "NUM_INT", 
			"NUM_REAL", "DELIM", "OP_ATR", "OP_ARI", "OP_REL", "OP_LOG", "PAR", "COL", 
			"IDENT", "CADEIA", "CADEIA_ERRADA", "ESC_SEQ", "SIMBOLOS", "SIMBOLOS_DESCONHECIDOS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'constante'", "'='", 
			"'tipo'", "','", "'.'", "'['", "']'", "'literal'", "'inteiro'", "'real'", 
			"'logico'", "'^'", "'verdadeiro'", "'falso'", "'registro'", "'fim_registro'", 
			"'procedimento'", "'('", "')'", "'fim_procedimento'", "'funcao'", "'fim_funcao'", 
			"'var'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'fim_se'", 
			"'caso'", "'seja'", "'fim_caso'", "'para'", "'ate'", "'faca'", "'fim_para'", 
			"'enquanto'", "'fim_enquanto'", "'retorne'", "'..'", "'-'", "'+'", "'*'", 
			"'/'", "'%'", "'&'", "'<>'", "'>='", "'<='", "'>'", "'<'", "'nao'", "'ou'", 
			"'e'", null, null, null, null, null, null, "':'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "COMENTARIO", 
			"COMENTARIO_ERRADO", "WS", "PALAVRA_CHAVE", "NUM_INT", "NUM_REAL", "DELIM", 
			"OP_ATR", "OP_ARI", "OP_REL", "OP_LOG", "PAR", "COL", "IDENT", "CADEIA", 
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


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LA.g4"; }

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
		case 57:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2M\u033a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#"+
		"\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\38\39\39\39\3:\3:\3;\3"+
		";\7;\u01e4\n;\f;\16;\u01e7\13;\3;\3;\3;\3<\3<\7<\u01ee\n<\f<\16<\u01f1"+
		"\13<\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u02ea\n>\3"+
		"?\6?\u02ed\n?\r?\16?\u02ee\3@\6@\u02f2\n@\r@\16@\u02f3\3@\3@\6@\u02f8"+
		"\n@\r@\16@\u02f9\3A\3A\3B\3B\3B\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\5D\u030b"+
		"\nD\3E\3E\3E\5E\u0310\nE\3F\3F\3G\3G\3H\3H\7H\u0318\nH\fH\16H\u031b\13"+
		"H\3I\3I\3I\7I\u0320\nI\fI\16I\u0323\13I\3I\3I\3J\3J\3J\7J\u032a\nJ\fJ"+
		"\16J\u032d\13J\3J\3J\3K\3K\3K\3L\3L\3L\5L\u0337\nL\3M\3M\2\2N\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w"+
		"=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091"+
		"J\u0093K\u0095\2\u0097L\u0099M\3\2\13\5\2\f\f\17\17\177\177\5\2\13\f\17"+
		"\17\"\"\6\2\'\',-//\61\61\4\2>>@@\4\2]]__\5\2C\\aac|\6\2\62;C\\aac|\4"+
		"\2\f\f$$\6\2((..\60\60``\2\u036a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\3\u009b\3\2\2\2\5\u00a5\3\2\2"+
		"\2\7\u00b3\3\2\2\2\t\u00bb\3\2\2\2\13\u00c5\3\2\2\2\r\u00c7\3\2\2\2\17"+
		"\u00cc\3\2\2\2\21\u00ce\3\2\2\2\23\u00d0\3\2\2\2\25\u00d2\3\2\2\2\27\u00d4"+
		"\3\2\2\2\31\u00dc\3\2\2\2\33\u00e4\3\2\2\2\35\u00e9\3\2\2\2\37\u00f0\3"+
		"\2\2\2!\u00f2\3\2\2\2#\u00fd\3\2\2\2%\u0103\3\2\2\2\'\u010c\3\2\2\2)\u0119"+
		"\3\2\2\2+\u0126\3\2\2\2-\u0128\3\2\2\2/\u012a\3\2\2\2\61\u013b\3\2\2\2"+
		"\63\u0142\3\2\2\2\65\u014d\3\2\2\2\67\u0151\3\2\2\29\u0156\3\2\2\2;\u015e"+
		"\3\2\2\2=\u0161\3\2\2\2?\u0167\3\2\2\2A\u016d\3\2\2\2C\u0174\3\2\2\2E"+
		"\u0179\3\2\2\2G\u017e\3\2\2\2I\u0187\3\2\2\2K\u018c\3\2\2\2M\u0190\3\2"+
		"\2\2O\u0195\3\2\2\2Q\u019e\3\2\2\2S\u01a7\3\2\2\2U\u01b4\3\2\2\2W\u01bc"+
		"\3\2\2\2Y\u01bf\3\2\2\2[\u01c1\3\2\2\2]\u01c3\3\2\2\2_\u01c5\3\2\2\2a"+
		"\u01c7\3\2\2\2c\u01c9\3\2\2\2e\u01cb\3\2\2\2g\u01ce\3\2\2\2i\u01d1\3\2"+
		"\2\2k\u01d4\3\2\2\2m\u01d6\3\2\2\2o\u01d8\3\2\2\2q\u01dc\3\2\2\2s\u01df"+
		"\3\2\2\2u\u01e1\3\2\2\2w\u01eb\3\2\2\2y\u01f4\3\2\2\2{\u02e9\3\2\2\2}"+
		"\u02ec\3\2\2\2\177\u02f1\3\2\2\2\u0081\u02fb\3\2\2\2\u0083\u02fd\3\2\2"+
		"\2\u0085\u0300\3\2\2\2\u0087\u030a\3\2\2\2\u0089\u030f\3\2\2\2\u008b\u0311"+
		"\3\2\2\2\u008d\u0313\3\2\2\2\u008f\u0315\3\2\2\2\u0091\u031c\3\2\2\2\u0093"+
		"\u0326\3\2\2\2\u0095\u0330\3\2\2\2\u0097\u0336\3\2\2\2\u0099\u0338\3\2"+
		"\2\2\u009b\u009c\7c\2\2\u009c\u009d\7n\2\2\u009d\u009e\7i\2\2\u009e\u009f"+
		"\7q\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7v\2\2\u00a2"+
		"\u00a3\7o\2\2\u00a3\u00a4\7q\2\2\u00a4\4\3\2\2\2\u00a5\u00a6\7h\2\2\u00a6"+
		"\u00a7\7k\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa\7c\2\2"+
		"\u00aa\u00ab\7n\2\2\u00ab\u00ac\7i\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae"+
		"\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7o\2\2\u00b1"+
		"\u00b2\7q\2\2\u00b2\6\3\2\2\2\u00b3\u00b4\7f\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7t\2\2"+
		"\u00b9\u00ba\7g\2\2\u00ba\b\3\2\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7q"+
		"\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1"+
		"\7c\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\n\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6\f\3\2\2\2\u00c7\u00c8\7v\2\2\u00c8"+
		"\u00c9\7k\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7q\2\2\u00cb\16\3\2\2\2\u00cc"+
		"\u00cd\7.\2\2\u00cd\20\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf\22\3\2\2\2\u00d0"+
		"\u00d1\7]\2\2\u00d1\24\3\2\2\2\u00d2\u00d3\7_\2\2\u00d3\26\3\2\2\2\u00d4"+
		"\u00d5\7n\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7g\2\2"+
		"\u00d8\u00d9\7t\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7n\2\2\u00db\30\3\2"+
		"\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7v\2\2\u00df\u00e0"+
		"\7g\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\32\3\2\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7c\2\2\u00e7"+
		"\u00e8\7n\2\2\u00e8\34\3\2\2\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7q\2\2\u00eb"+
		"\u00ec\7i\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef\7q\2\2"+
		"\u00ef\36\3\2\2\2\u00f0\u00f1\7`\2\2\u00f1 \3\2\2\2\u00f2\u00f3\7x\2\2"+
		"\u00f3\u00f4\7g\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7f\2\2\u00f6\u00f7"+
		"\7c\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7k\2\2\u00fa"+
		"\u00fb\7t\2\2\u00fb\u00fc\7q\2\2\u00fc\"\3\2\2\2\u00fd\u00fe\7h\2\2\u00fe"+
		"\u00ff\7c\2\2\u00ff\u0100\7n\2\2\u0100\u0101\7u\2\2\u0101\u0102\7q\2\2"+
		"\u0102$\3\2\2\2\u0103\u0104\7t\2\2\u0104\u0105\7g\2\2\u0105\u0106\7i\2"+
		"\2\u0106\u0107\7k\2\2\u0107\u0108\7u\2\2\u0108\u0109\7v\2\2\u0109\u010a"+
		"\7t\2\2\u010a\u010b\7q\2\2\u010b&\3\2\2\2\u010c\u010d\7h\2\2\u010d\u010e"+
		"\7k\2\2\u010e\u010f\7o\2\2\u010f\u0110\7a\2\2\u0110\u0111\7t\2\2\u0111"+
		"\u0112\7g\2\2\u0112\u0113\7i\2\2\u0113\u0114\7k\2\2\u0114\u0115\7u\2\2"+
		"\u0115\u0116\7v\2\2\u0116\u0117\7t\2\2\u0117\u0118\7q\2\2\u0118(\3\2\2"+
		"\2\u0119\u011a\7r\2\2\u011a\u011b\7t\2\2\u011b\u011c\7q\2\2\u011c\u011d"+
		"\7e\2\2\u011d\u011e\7g\2\2\u011e\u011f\7f\2\2\u011f\u0120\7k\2\2\u0120"+
		"\u0121\7o\2\2\u0121\u0122\7g\2\2\u0122\u0123\7p\2\2\u0123\u0124\7v\2\2"+
		"\u0124\u0125\7q\2\2\u0125*\3\2\2\2\u0126\u0127\7*\2\2\u0127,\3\2\2\2\u0128"+
		"\u0129\7+\2\2\u0129.\3\2\2\2\u012a\u012b\7h\2\2\u012b\u012c\7k\2\2\u012c"+
		"\u012d\7o\2\2\u012d\u012e\7a\2\2\u012e\u012f\7r\2\2\u012f\u0130\7t\2\2"+
		"\u0130\u0131\7q\2\2\u0131\u0132\7e\2\2\u0132\u0133\7g\2\2\u0133\u0134"+
		"\7f\2\2\u0134\u0135\7k\2\2\u0135\u0136\7o\2\2\u0136\u0137\7g\2\2\u0137"+
		"\u0138\7p\2\2\u0138\u0139\7v\2\2\u0139\u013a\7q\2\2\u013a\60\3\2\2\2\u013b"+
		"\u013c\7h\2\2\u013c\u013d\7w\2\2\u013d\u013e\7p\2\2\u013e\u013f\7e\2\2"+
		"\u013f\u0140\7c\2\2\u0140\u0141\7q\2\2\u0141\62\3\2\2\2\u0142\u0143\7"+
		"h\2\2\u0143\u0144\7k\2\2\u0144\u0145\7o\2\2\u0145\u0146\7a\2\2\u0146\u0147"+
		"\7h\2\2\u0147\u0148\7w\2\2\u0148\u0149\7p\2\2\u0149\u014a\7e\2\2\u014a"+
		"\u014b\7c\2\2\u014b\u014c\7q\2\2\u014c\64\3\2\2\2\u014d\u014e\7x\2\2\u014e"+
		"\u014f\7c\2\2\u014f\u0150\7t\2\2\u0150\66\3\2\2\2\u0151\u0152\7n\2\2\u0152"+
		"\u0153\7g\2\2\u0153\u0154\7k\2\2\u0154\u0155\7c\2\2\u01558\3\2\2\2\u0156"+
		"\u0157\7g\2\2\u0157\u0158\7u\2\2\u0158\u0159\7e\2\2\u0159\u015a\7t\2\2"+
		"\u015a\u015b\7g\2\2\u015b\u015c\7x\2\2\u015c\u015d\7c\2\2\u015d:\3\2\2"+
		"\2\u015e\u015f\7u\2\2\u015f\u0160\7g\2\2\u0160<\3\2\2\2\u0161\u0162\7"+
		"g\2\2\u0162\u0163\7p\2\2\u0163\u0164\7v\2\2\u0164\u0165\7c\2\2\u0165\u0166"+
		"\7q\2\2\u0166>\3\2\2\2\u0167\u0168\7u\2\2\u0168\u0169\7g\2\2\u0169\u016a"+
		"\7p\2\2\u016a\u016b\7c\2\2\u016b\u016c\7q\2\2\u016c@\3\2\2\2\u016d\u016e"+
		"\7h\2\2\u016e\u016f\7k\2\2\u016f\u0170\7o\2\2\u0170\u0171\7a\2\2\u0171"+
		"\u0172\7u\2\2\u0172\u0173\7g\2\2\u0173B\3\2\2\2\u0174\u0175\7e\2\2\u0175"+
		"\u0176\7c\2\2\u0176\u0177\7u\2\2\u0177\u0178\7q\2\2\u0178D\3\2\2\2\u0179"+
		"\u017a\7u\2\2\u017a\u017b\7g\2\2\u017b\u017c\7l\2\2\u017c\u017d\7c\2\2"+
		"\u017dF\3\2\2\2\u017e\u017f\7h\2\2\u017f\u0180\7k\2\2\u0180\u0181\7o\2"+
		"\2\u0181\u0182\7a\2\2\u0182\u0183\7e\2\2\u0183\u0184\7c\2\2\u0184\u0185"+
		"\7u\2\2\u0185\u0186\7q\2\2\u0186H\3\2\2\2\u0187\u0188\7r\2\2\u0188\u0189"+
		"\7c\2\2\u0189\u018a\7t\2\2\u018a\u018b\7c\2\2\u018bJ\3\2\2\2\u018c\u018d"+
		"\7c\2\2\u018d\u018e\7v\2\2\u018e\u018f\7g\2\2\u018fL\3\2\2\2\u0190\u0191"+
		"\7h\2\2\u0191\u0192\7c\2\2\u0192\u0193\7e\2\2\u0193\u0194\7c\2\2\u0194"+
		"N\3\2\2\2\u0195\u0196\7h\2\2\u0196\u0197\7k\2\2\u0197\u0198\7o\2\2\u0198"+
		"\u0199\7a\2\2\u0199\u019a\7r\2\2\u019a\u019b\7c\2\2\u019b\u019c\7t\2\2"+
		"\u019c\u019d\7c\2\2\u019dP\3\2\2\2\u019e\u019f\7g\2\2\u019f\u01a0\7p\2"+
		"\2\u01a0\u01a1\7s\2\2\u01a1\u01a2\7w\2\2\u01a2\u01a3\7c\2\2\u01a3\u01a4"+
		"\7p\2\2\u01a4\u01a5\7v\2\2\u01a5\u01a6\7q\2\2\u01a6R\3\2\2\2\u01a7\u01a8"+
		"\7h\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7o\2\2\u01aa\u01ab\7a\2\2\u01ab"+
		"\u01ac\7g\2\2\u01ac\u01ad\7p\2\2\u01ad\u01ae\7s\2\2\u01ae\u01af\7w\2\2"+
		"\u01af\u01b0\7c\2\2\u01b0\u01b1\7p\2\2\u01b1\u01b2\7v\2\2\u01b2\u01b3"+
		"\7q\2\2\u01b3T\3\2\2\2\u01b4\u01b5\7t\2\2\u01b5\u01b6\7g\2\2\u01b6\u01b7"+
		"\7v\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7t\2\2\u01b9\u01ba\7p\2\2\u01ba"+
		"\u01bb\7g\2\2\u01bbV\3\2\2\2\u01bc\u01bd\7\60\2\2\u01bd\u01be\7\60\2\2"+
		"\u01beX\3\2\2\2\u01bf\u01c0\7/\2\2\u01c0Z\3\2\2\2\u01c1\u01c2\7-\2\2\u01c2"+
		"\\\3\2\2\2\u01c3\u01c4\7,\2\2\u01c4^\3\2\2\2\u01c5\u01c6\7\61\2\2\u01c6"+
		"`\3\2\2\2\u01c7\u01c8\7\'\2\2\u01c8b\3\2\2\2\u01c9\u01ca\7(\2\2\u01ca"+
		"d\3\2\2\2\u01cb\u01cc\7>\2\2\u01cc\u01cd\7@\2\2\u01cdf\3\2\2\2\u01ce\u01cf"+
		"\7@\2\2\u01cf\u01d0\7?\2\2\u01d0h\3\2\2\2\u01d1\u01d2\7>\2\2\u01d2\u01d3"+
		"\7?\2\2\u01d3j\3\2\2\2\u01d4\u01d5\7@\2\2\u01d5l\3\2\2\2\u01d6\u01d7\7"+
		">\2\2\u01d7n\3\2\2\2\u01d8\u01d9\7p\2\2\u01d9\u01da\7c\2\2\u01da\u01db"+
		"\7q\2\2\u01dbp\3\2\2\2\u01dc\u01dd\7q\2\2\u01dd\u01de\7w\2\2\u01der\3"+
		"\2\2\2\u01df\u01e0\7g\2\2\u01e0t\3\2\2\2\u01e1\u01e5\7}\2\2\u01e2\u01e4"+
		"\n\2\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\7\177"+
		"\2\2\u01e9\u01ea\b;\2\2\u01eav\3\2\2\2\u01eb\u01ef\7}\2\2\u01ec\u01ee"+
		"\n\2\2\2\u01ed\u01ec\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f3\7\f"+
		"\2\2\u01f3x\3\2\2\2\u01f4\u01f5\t\3\2\2\u01f5\u01f6\b=\3\2\u01f6z\3\2"+
		"\2\2\u01f7\u01f8\7c\2\2\u01f8\u01f9\7n\2\2\u01f9\u01fa\7i\2\2\u01fa\u01fb"+
		"\7q\2\2\u01fb\u01fc\7t\2\2\u01fc\u01fd\7k\2\2\u01fd\u01fe\7v\2\2\u01fe"+
		"\u01ff\7o\2\2\u01ff\u02ea\7q\2\2\u0200\u0201\7h\2\2\u0201\u0202\7k\2\2"+
		"\u0202\u0203\7o\2\2\u0203\u0204\7a\2\2\u0204\u0205\7c\2\2\u0205\u0206"+
		"\7n\2\2\u0206\u0207\7i\2\2\u0207\u0208\7q\2\2\u0208\u0209\7t\2\2\u0209"+
		"\u020a\7k\2\2\u020a\u020b\7v\2\2\u020b\u020c\7o\2\2\u020c\u02ea\7q\2\2"+
		"\u020d\u020e\7f\2\2\u020e\u020f\7g\2\2\u020f\u0210\7e\2\2\u0210\u0211"+
		"\7n\2\2\u0211\u0212\7c\2\2\u0212\u0213\7t\2\2\u0213\u02ea\7g\2\2\u0214"+
		"\u0215\7e\2\2\u0215\u0216\7q\2\2\u0216\u0217\7p\2\2\u0217\u0218\7u\2\2"+
		"\u0218\u0219\7v\2\2\u0219\u021a\7c\2\2\u021a\u021b\7p\2\2\u021b\u021c"+
		"\7v\2\2\u021c\u02ea\7g\2\2\u021d\u021e\7v\2\2\u021e\u021f\7k\2\2\u021f"+
		"\u0220\7r\2\2\u0220\u02ea\7q\2\2\u0221\u0222\7n\2\2\u0222\u0223\7k\2\2"+
		"\u0223\u0224\7v\2\2\u0224\u0225\7g\2\2\u0225\u0226\7t\2\2\u0226\u0227"+
		"\7c\2\2\u0227\u02ea\7n\2\2\u0228\u0229\7k\2\2\u0229\u022a\7p\2\2\u022a"+
		"\u022b\7v\2\2\u022b\u022c\7g\2\2\u022c\u022d\7k\2\2\u022d\u022e\7t\2\2"+
		"\u022e\u02ea\7q\2\2\u022f\u0230\7t\2\2\u0230\u0231\7g\2\2\u0231\u0232"+
		"\7c\2\2\u0232\u02ea\7n\2\2\u0233\u0234\7n\2\2\u0234\u0235\7q\2\2\u0235"+
		"\u0236\7i\2\2\u0236\u0237\7k\2\2\u0237\u0238\7e\2\2\u0238\u02ea\7q\2\2"+
		"\u0239\u023a\7x\2\2\u023a\u023b\7g\2\2\u023b\u023c\7t\2\2\u023c\u023d"+
		"\7f\2\2\u023d\u023e\7c\2\2\u023e\u023f\7f\2\2\u023f\u0240\7g\2\2\u0240"+
		"\u0241\7k\2\2\u0241\u0242\7t\2\2\u0242\u02ea\7q\2\2\u0243\u0244\7h\2\2"+
		"\u0244\u0245\7c\2\2\u0245\u0246\7n\2\2\u0246\u0247\7u\2\2\u0247\u02ea"+
		"\7q\2\2\u0248\u0249\7t\2\2\u0249\u024a\7g\2\2\u024a\u024b\7i\2\2\u024b"+
		"\u024c\7k\2\2\u024c\u024d\7u\2\2\u024d\u024e\7v\2\2\u024e\u024f\7t\2\2"+
		"\u024f\u02ea\7q\2\2\u0250\u0251\7h\2\2\u0251\u0252\7k\2\2\u0252\u0253"+
		"\7o\2\2\u0253\u0254\7a\2\2\u0254\u0255\7t\2\2\u0255\u0256\7g\2\2\u0256"+
		"\u0257\7i\2\2\u0257\u0258\7k\2\2\u0258\u0259\7u\2\2\u0259\u025a\7v\2\2"+
		"\u025a\u025b\7t\2\2\u025b\u02ea\7q\2\2\u025c\u025d\7r\2\2\u025d\u025e"+
		"\7t\2\2\u025e\u025f\7q\2\2\u025f\u0260\7e\2\2\u0260\u0261\7g\2\2\u0261"+
		"\u0262\7f\2\2\u0262\u0263\7k\2\2\u0263\u0264\7o\2\2\u0264\u0265\7g\2\2"+
		"\u0265\u0266\7p\2\2\u0266\u0267\7v\2\2\u0267\u02ea\7q\2\2\u0268\u0269"+
		"\7h\2\2\u0269\u026a\7k\2\2\u026a\u026b\7o\2\2\u026b\u026c\7a\2\2\u026c"+
		"\u026d\7r\2\2\u026d\u026e\7t\2\2\u026e\u026f\7q\2\2\u026f\u0270\7e\2\2"+
		"\u0270\u0271\7g\2\2\u0271\u0272\7f\2\2\u0272\u0273\7k\2\2\u0273\u0274"+
		"\7o\2\2\u0274\u0275\7g\2\2\u0275\u0276\7p\2\2\u0276\u0277\7v\2\2\u0277"+
		"\u02ea\7q\2\2\u0278\u0279\7h\2\2\u0279\u027a\7w\2\2\u027a\u027b\7p\2\2"+
		"\u027b\u027c\7e\2\2\u027c\u027d\7c\2\2\u027d\u02ea\7q\2\2\u027e\u027f"+
		"\7h\2\2\u027f\u0280\7k\2\2\u0280\u0281\7o\2\2\u0281\u0282\7a\2\2\u0282"+
		"\u0283\7h\2\2\u0283\u0284\7w\2\2\u0284\u0285\7p\2\2\u0285\u0286\7e\2\2"+
		"\u0286\u0287\7c\2\2\u0287\u02ea\7q\2\2\u0288\u0289\7x\2\2\u0289\u028a"+
		"\7c\2\2\u028a\u02ea\7t\2\2\u028b\u028c\7n\2\2\u028c\u028d\7g\2\2\u028d"+
		"\u028e\7k\2\2\u028e\u02ea\7c\2\2\u028f\u0290\7g\2\2\u0290\u0291\7u\2\2"+
		"\u0291\u0292\7e\2\2\u0292\u0293\7t\2\2\u0293\u0294\7g\2\2\u0294\u0295"+
		"\7x\2\2\u0295\u02ea\7c\2\2\u0296\u0297\7u\2\2\u0297\u02ea\7g\2\2\u0298"+
		"\u0299\7g\2\2\u0299\u029a\7p\2\2\u029a\u029b\7v\2\2\u029b\u029c\7c\2\2"+
		"\u029c\u02ea\7q\2\2\u029d\u029e\7u\2\2\u029e\u029f\7g\2\2\u029f\u02a0"+
		"\7p\2\2\u02a0\u02a1\7c\2\2\u02a1\u02ea\7q\2\2\u02a2\u02a3\7h\2\2\u02a3"+
		"\u02a4\7k\2\2\u02a4\u02a5\7o\2\2\u02a5\u02a6\7a\2\2\u02a6\u02a7\7u\2\2"+
		"\u02a7\u02ea\7g\2\2\u02a8\u02a9\7e\2\2\u02a9\u02aa\7c\2\2\u02aa\u02ab"+
		"\7u\2\2\u02ab\u02ea\7q\2\2\u02ac\u02ad\7u\2\2\u02ad\u02ae\7g\2\2\u02ae"+
		"\u02af\7l\2\2\u02af\u02ea\7c\2\2\u02b0\u02b1\7h\2\2\u02b1\u02b2\7k\2\2"+
		"\u02b2\u02b3\7o\2\2\u02b3\u02b4\7a\2\2\u02b4\u02b5\7e\2\2\u02b5\u02b6"+
		"\7c\2\2\u02b6\u02b7\7u\2\2\u02b7\u02ea\7q\2\2\u02b8\u02b9\7r\2\2\u02b9"+
		"\u02ba\7c\2\2\u02ba\u02bb\7t\2\2\u02bb\u02ea\7c\2\2\u02bc\u02bd\7c\2\2"+
		"\u02bd\u02be\7v\2\2\u02be\u02ea\7g\2\2\u02bf\u02c0\7h\2\2\u02c0\u02c1"+
		"\7c\2\2\u02c1\u02c2\7e\2\2\u02c2\u02ea\7c\2\2\u02c3\u02c4\7h\2\2\u02c4"+
		"\u02c5\7k\2\2\u02c5\u02c6\7o\2\2\u02c6\u02c7\7a\2\2\u02c7\u02c8\7r\2\2"+
		"\u02c8\u02c9\7c\2\2\u02c9\u02ca\7t\2\2\u02ca\u02ea\7c\2\2\u02cb\u02cc"+
		"\7g\2\2\u02cc\u02cd\7p\2\2\u02cd\u02ce\7s\2\2\u02ce\u02cf\7w\2\2\u02cf"+
		"\u02d0\7c\2\2\u02d0\u02d1\7p\2\2\u02d1\u02d2\7v\2\2\u02d2\u02ea\7q\2\2"+
		"\u02d3\u02d4\7h\2\2\u02d4\u02d5\7k\2\2\u02d5\u02d6\7o\2\2\u02d6\u02d7"+
		"\7a\2\2\u02d7\u02d8\7g\2\2\u02d8\u02d9\7p\2\2\u02d9\u02da\7s\2\2\u02da"+
		"\u02db\7w\2\2\u02db\u02dc\7c\2\2\u02dc\u02dd\7p\2\2\u02dd\u02de\7v\2\2"+
		"\u02de\u02ea\7q\2\2\u02df\u02e0\7t\2\2\u02e0\u02e1\7g\2\2\u02e1\u02e2"+
		"\7v\2\2\u02e2\u02e3\7q\2\2\u02e3\u02e4\7t\2\2\u02e4\u02e5\7p\2\2\u02e5"+
		"\u02ea\7g\2\2\u02e6\u02e7\7p\2\2\u02e7\u02e8\7c\2\2\u02e8\u02ea\7q\2\2"+
		"\u02e9\u01f7\3\2\2\2\u02e9\u0200\3\2\2\2\u02e9\u020d\3\2\2\2\u02e9\u0214"+
		"\3\2\2\2\u02e9\u021d\3\2\2\2\u02e9\u0221\3\2\2\2\u02e9\u0228\3\2\2\2\u02e9"+
		"\u022f\3\2\2\2\u02e9\u0233\3\2\2\2\u02e9\u0239\3\2\2\2\u02e9\u0243\3\2"+
		"\2\2\u02e9\u0248\3\2\2\2\u02e9\u0250\3\2\2\2\u02e9\u025c\3\2\2\2\u02e9"+
		"\u0268\3\2\2\2\u02e9\u0278\3\2\2\2\u02e9\u027e\3\2\2\2\u02e9\u0288\3\2"+
		"\2\2\u02e9\u028b\3\2\2\2\u02e9\u028f\3\2\2\2\u02e9\u0296\3\2\2\2\u02e9"+
		"\u0298\3\2\2\2\u02e9\u029d\3\2\2\2\u02e9\u02a2\3\2\2\2\u02e9\u02a8\3\2"+
		"\2\2\u02e9\u02ac\3\2\2\2\u02e9\u02b0\3\2\2\2\u02e9\u02b8\3\2\2\2\u02e9"+
		"\u02bc\3\2\2\2\u02e9\u02bf\3\2\2\2\u02e9\u02c3\3\2\2\2\u02e9\u02cb\3\2"+
		"\2\2\u02e9\u02d3\3\2\2\2\u02e9\u02df\3\2\2\2\u02e9\u02e6\3\2\2\2\u02ea"+
		"|\3\2\2\2\u02eb\u02ed\4\62;\2\u02ec\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2"+
		"\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef~\3\2\2\2\u02f0\u02f2\4"+
		"\62;\2\u02f1\u02f0\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3"+
		"\u02f4\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\7\60\2\2\u02f6\u02f8\4"+
		"\62;\2\u02f7\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02f7\3\2\2\2\u02f9"+
		"\u02fa\3\2\2\2\u02fa\u0080\3\2\2\2\u02fb\u02fc\7<\2\2\u02fc\u0082\3\2"+
		"\2\2\u02fd\u02fe\7>\2\2\u02fe\u02ff\7/\2\2\u02ff\u0084\3\2\2\2\u0300\u0301"+
		"\t\4\2\2\u0301\u0086\3\2\2\2\u0302\u030b\7?\2\2\u0303\u0304\7>\2\2\u0304"+
		"\u030b\7@\2\2\u0305\u030b\t\5\2\2\u0306\u0307\7@\2\2\u0307\u030b\7?\2"+
		"\2\u0308\u0309\7>\2\2\u0309\u030b\7?\2\2\u030a\u0302\3\2\2\2\u030a\u0303"+
		"\3\2\2\2\u030a\u0305\3\2\2\2\u030a\u0306\3\2\2\2\u030a\u0308\3\2\2\2\u030b"+
		"\u0088\3\2\2\2\u030c\u0310\7g\2\2\u030d\u030e\7q\2\2\u030e\u0310\7w\2"+
		"\2\u030f\u030c\3\2\2\2\u030f\u030d\3\2\2\2\u0310\u008a\3\2\2\2\u0311\u0312"+
		"\4*+\2\u0312\u008c\3\2\2\2\u0313\u0314\t\6\2\2\u0314\u008e\3\2\2\2\u0315"+
		"\u0319\t\7\2\2\u0316\u0318\t\b\2\2\u0317\u0316\3\2\2\2\u0318\u031b\3\2"+
		"\2\2\u0319\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u0090\3\2\2\2\u031b"+
		"\u0319\3\2\2\2\u031c\u0321\7$\2\2\u031d\u0320\5\u0095K\2\u031e\u0320\n"+
		"\t\2\2\u031f\u031d\3\2\2\2\u031f\u031e\3\2\2\2\u0320\u0323\3\2\2\2\u0321"+
		"\u031f\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0324\3\2\2\2\u0323\u0321\3\2"+
		"\2\2\u0324\u0325\7$\2\2\u0325\u0092\3\2\2\2\u0326\u032b\7$\2\2\u0327\u032a"+
		"\5\u0095K\2\u0328\u032a\n\t\2\2\u0329\u0327\3\2\2\2\u0329\u0328\3\2\2"+
		"\2\u032a\u032d\3\2\2\2\u032b\u0329\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032e"+
		"\3\2\2\2\u032d\u032b\3\2\2\2\u032e\u032f\7\f\2\2\u032f\u0094\3\2\2\2\u0330"+
		"\u0331\7^\2\2\u0331\u0332\7$\2\2\u0332\u0096\3\2\2\2\u0333\u0337\t\n\2"+
		"\2\u0334\u0335\7\60\2\2\u0335\u0337\7\60\2\2\u0336\u0333\3\2\2\2\u0336"+
		"\u0334\3\2\2\2\u0337\u0098\3\2\2\2\u0338\u0339\13\2\2\2\u0339\u009a\3"+
		"\2\2\2\21\2\u01e5\u01ef\u02e9\u02ee\u02f3\u02f9\u030a\u030f\u0319\u031f"+
		"\u0321\u0329\u032b\u0336\4\3;\2\3=\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}