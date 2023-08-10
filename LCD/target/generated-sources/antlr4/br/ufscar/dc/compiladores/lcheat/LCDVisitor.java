// Generated from br\u005Cufscar\dc\compiladores\lcheat\LCD.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.lcheat;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LCDParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LCDVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LCDParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LCDParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfo(LCDParser.InfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LCDParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(LCDParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#cheat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheat(LCDParser.CheatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodigo(LCDParser.CodigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#botao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBotao(LCDParser.BotaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#fase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFase(LCDParser.FaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#instrucoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucoes(LCDParser.InstrucoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LCDParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(LCDParser.InstrucaoContext ctx);
}