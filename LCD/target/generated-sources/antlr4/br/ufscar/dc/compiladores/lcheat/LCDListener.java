// Generated from br\u005Cufscar\dc\compiladores\lcheat\LCD.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.lcheat;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LCDParser}.
 */
public interface LCDListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LCDParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LCDParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LCDParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#info}.
	 * @param ctx the parse tree
	 */
	void enterInfo(LCDParser.InfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#info}.
	 * @param ctx the parse tree
	 */
	void exitInfo(LCDParser.InfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LCDParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LCDParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(LCDParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(LCDParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#cheat}.
	 * @param ctx the parse tree
	 */
	void enterCheat(LCDParser.CheatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#cheat}.
	 * @param ctx the parse tree
	 */
	void exitCheat(LCDParser.CheatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#codigo}.
	 * @param ctx the parse tree
	 */
	void enterCodigo(LCDParser.CodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#codigo}.
	 * @param ctx the parse tree
	 */
	void exitCodigo(LCDParser.CodigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#botao}.
	 * @param ctx the parse tree
	 */
	void enterBotao(LCDParser.BotaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#botao}.
	 * @param ctx the parse tree
	 */
	void exitBotao(LCDParser.BotaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#fase}.
	 * @param ctx the parse tree
	 */
	void enterFase(LCDParser.FaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#fase}.
	 * @param ctx the parse tree
	 */
	void exitFase(LCDParser.FaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#instrucoes}.
	 * @param ctx the parse tree
	 */
	void enterInstrucoes(LCDParser.InstrucoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#instrucoes}.
	 * @param ctx the parse tree
	 */
	void exitInstrucoes(LCDParser.InstrucoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LCDParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(LCDParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LCDParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(LCDParser.InstrucaoContext ctx);
}