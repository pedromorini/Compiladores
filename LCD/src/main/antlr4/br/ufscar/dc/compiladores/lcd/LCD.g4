grammar LCD;

// Regras Léxicas

WS: (' '|'\t'|'\r'|'\n') { skip(); };

PALAVRA_CHAVE:  'nome' | 'capa' | 'console' | 'ps1' | 'ps2' | 'cheat' |
                'instrucao' | 'fim_instrucao'| 'escreva' | 'fase' |
                'R1' | 'R2' | 'L1' | 'L2' | 'T' | 'Q' | 'X' | 'O' | 'cima' | 
                'baixo' | 'esquerda' | 'direita' | 'meia_lua_esq' | 'meia_lua_dir';

IDENT: ('a'..'z' | 'A'..'Z' | '_')('a'..'z'| 'A'..'Z' | '0'..'9' | '_')*;

INDICE: '0'..'9';

CADEIA: '"' ( ESC_SEQ | ~('"') )* '"';

CADEIA_ERRADA: '"' ( ESC_SEQ | ~('"'))* '\n';

fragment
ESC_SEQ: '\\"';

SIMBOLOS: '[' | ']' | ',' | ':' | '<-' | '<>';

SIMBOLOS_DESCONHECIDOS: .;

// Regras Sintaticas

programa: info declaracoes EOF;

info: 'nome' ':' CADEIA
      'capa' ':' CADEIA
      'console' ':' tipo;

tipo: 'ps1' | 'ps2';

declaracoes: (cheat)* (fase)+;

cheat: 'cheat' ':' IDENT '<-' CADEIA (';' codigo)* instrucoes?;

codigo: botao (',' botao)*;
        
botao: 'R1' | 'R2' | 'L1' | 'L2' | 'T' | 'Q' | 'X' | 'O' | 'cima' | 'baixo' | 
       'esquerda' | 'direita';

fase: 'fase' ':' IDENT '<-' CADEIA instrucoes;

instrucoes: 'instrucao' ':' instrucao (',' instrucao)* 'fim_instrucao';

instrucao: CADEIA | IDENT ('[' INDICE ']')?;