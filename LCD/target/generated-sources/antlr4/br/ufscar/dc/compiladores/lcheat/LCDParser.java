// Generated from br\u005Cufscar\dc\compiladores\lcheat\LCD.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.lcheat;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LCDParser extends Parser {
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
	public static final int
		RULE_programa = 0, RULE_info = 1, RULE_tipo = 2, RULE_declaracoes = 3, 
		RULE_cheat = 4, RULE_codigo = 5, RULE_botao = 6, RULE_fase = 7, RULE_instrucoes = 8, 
		RULE_instrucao = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "info", "tipo", "declaracoes", "cheat", "codigo", "botao", 
			"fase", "instrucoes", "instrucao"
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

	@Override
	public String getGrammarFileName() { return "LCD.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LCDParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public InfoContext info() {
			return getRuleContext(InfoContext.class,0);
		}
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LCDParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			info();
			setState(21);
			declaracoes();
			setState(22);
			match(EOF);
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

	public static class InfoContext extends ParserRuleContext {
		public List<TerminalNode> CADEIA() { return getTokens(LCDParser.CADEIA); }
		public TerminalNode CADEIA(int i) {
			return getToken(LCDParser.CADEIA, i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public InfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoContext info() throws RecognitionException {
		InfoContext _localctx = new InfoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(T__1);
			setState(26);
			match(CADEIA);
			setState(27);
			match(T__2);
			setState(28);
			match(T__1);
			setState(29);
			match(CADEIA);
			setState(30);
			match(T__3);
			setState(31);
			match(T__1);
			setState(32);
			tipo();
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<CheatContext> cheat() {
			return getRuleContexts(CheatContext.class);
		}
		public CheatContext cheat(int i) {
			return getRuleContext(CheatContext.class,i);
		}
		public List<FaseContext> fase() {
			return getRuleContexts(FaseContext.class);
		}
		public FaseContext fase(int i) {
			return getRuleContext(FaseContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(36);
				cheat();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				fase();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__22 );
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

	public static class CheatContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LCDParser.IDENT, 0); }
		public TerminalNode CADEIA() { return getToken(LCDParser.CADEIA, 0); }
		public List<CodigoContext> codigo() {
			return getRuleContexts(CodigoContext.class);
		}
		public CodigoContext codigo(int i) {
			return getRuleContext(CodigoContext.class,i);
		}
		public InstrucoesContext instrucoes() {
			return getRuleContext(InstrucoesContext.class,0);
		}
		public CheatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cheat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterCheat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitCheat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitCheat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheatContext cheat() throws RecognitionException {
		CheatContext _localctx = new CheatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cheat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__6);
			setState(48);
			match(T__1);
			setState(49);
			match(IDENT);
			setState(50);
			match(T__7);
			setState(51);
			match(CADEIA);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(52);
				match(T__8);
				setState(53);
				codigo();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(59);
				instrucoes();
				}
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

	public static class CodigoContext extends ParserRuleContext {
		public List<BotaoContext> botao() {
			return getRuleContexts(BotaoContext.class);
		}
		public BotaoContext botao(int i) {
			return getRuleContext(BotaoContext.class,i);
		}
		public CodigoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codigo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterCodigo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitCodigo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitCodigo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodigoContext codigo() throws RecognitionException {
		CodigoContext _localctx = new CodigoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_codigo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			botao();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(63);
				match(T__9);
				setState(64);
				botao();
				}
				}
				setState(69);
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

	public static class BotaoContext extends ParserRuleContext {
		public BotaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_botao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterBotao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitBotao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitBotao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BotaoContext botao() throws RecognitionException {
		BotaoContext _localctx = new BotaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_botao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FaseContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LCDParser.IDENT, 0); }
		public TerminalNode CADEIA() { return getToken(LCDParser.CADEIA, 0); }
		public InstrucoesContext instrucoes() {
			return getRuleContext(InstrucoesContext.class,0);
		}
		public FaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterFase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitFase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitFase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaseContext fase() throws RecognitionException {
		FaseContext _localctx = new FaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__22);
			setState(73);
			match(T__1);
			setState(74);
			match(IDENT);
			setState(75);
			match(T__7);
			setState(76);
			match(CADEIA);
			setState(77);
			instrucoes();
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

	public static class InstrucoesContext extends ParserRuleContext {
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public InstrucoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterInstrucoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitInstrucoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitInstrucoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrucoesContext instrucoes() throws RecognitionException {
		InstrucoesContext _localctx = new InstrucoesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instrucoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__23);
			setState(80);
			match(T__1);
			setState(81);
			instrucao();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(82);
				match(T__9);
				setState(83);
				instrucao();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__24);
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

	public static class InstrucaoContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(LCDParser.CADEIA, 0); }
		public TerminalNode IDENT() { return getToken(LCDParser.IDENT, 0); }
		public TerminalNode INDICE() { return getToken(LCDParser.INDICE, 0); }
		public InstrucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LCDListener ) ((LCDListener)listener).exitInstrucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LCDVisitor ) return ((LCDVisitor<? extends T>)visitor).visitInstrucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrucaoContext instrucao() throws RecognitionException {
		InstrucaoContext _localctx = new InstrucaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instrucao);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(CADEIA);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(IDENT);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(93);
					match(T__25);
					setState(94);
					match(INDICE);
					setState(95);
					match(T__26);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%g\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\7\5("+
		"\n\5\f\5\16\5+\13\5\3\5\6\5.\n\5\r\5\16\5/\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\69\n\6\f\6\16\6<\13\6\3\6\5\6?\n\6\3\7\3\7\3\7\7\7D\n\7\f\7\16\7G\13"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\nW\n\n\f"+
		"\n\16\nZ\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13c\n\13\5\13e\n\13\3"+
		"\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\4\3\2\7\b\3\2\r\30\2d\2\26\3\2\2\2"+
		"\4\32\3\2\2\2\6$\3\2\2\2\b)\3\2\2\2\n\61\3\2\2\2\f@\3\2\2\2\16H\3\2\2"+
		"\2\20J\3\2\2\2\22Q\3\2\2\2\24d\3\2\2\2\26\27\5\4\3\2\27\30\5\b\5\2\30"+
		"\31\7\2\2\3\31\3\3\2\2\2\32\33\7\3\2\2\33\34\7\4\2\2\34\35\7\"\2\2\35"+
		"\36\7\5\2\2\36\37\7\4\2\2\37 \7\"\2\2 !\7\6\2\2!\"\7\4\2\2\"#\5\6\4\2"+
		"#\5\3\2\2\2$%\t\2\2\2%\7\3\2\2\2&(\5\n\6\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2"+
		"\2\2)*\3\2\2\2*-\3\2\2\2+)\3\2\2\2,.\5\20\t\2-,\3\2\2\2./\3\2\2\2/-\3"+
		"\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\61\62\7\t\2\2\62\63\7\4\2\2\63\64\7 \2"+
		"\2\64\65\7\n\2\2\65:\7\"\2\2\66\67\7\13\2\2\679\5\f\7\28\66\3\2\2\29<"+
		"\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=?\5\22\n\2>=\3\2\2\2"+
		">?\3\2\2\2?\13\3\2\2\2@E\5\16\b\2AB\7\f\2\2BD\5\16\b\2CA\3\2\2\2DG\3\2"+
		"\2\2EC\3\2\2\2EF\3\2\2\2F\r\3\2\2\2GE\3\2\2\2HI\t\3\2\2I\17\3\2\2\2JK"+
		"\7\31\2\2KL\7\4\2\2LM\7 \2\2MN\7\n\2\2NO\7\"\2\2OP\5\22\n\2P\21\3\2\2"+
		"\2QR\7\32\2\2RS\7\4\2\2SX\5\24\13\2TU\7\f\2\2UW\5\24\13\2VT\3\2\2\2WZ"+
		"\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\33\2\2\\\23\3\2"+
		"\2\2]e\7\"\2\2^b\7 \2\2_`\7\34\2\2`a\7!\2\2ac\7\35\2\2b_\3\2\2\2bc\3\2"+
		"\2\2ce\3\2\2\2d]\3\2\2\2d^\3\2\2\2e\25\3\2\2\2\n)/:>EXbd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}