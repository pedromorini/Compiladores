lexer grammar LALexer;

// Comentários - tudo que estiver entre as chaves
COMENTARIO: '{' ~('\n'|'\r'|'}')* '}' { skip(); };

// Quando o parêntese não é fechado
COMENTARIO_ERRADO: '{' ~('\n'|'\r'|'}')* '\n';

// Ignora os espaços em branco
WS: (' '|'\t'|'\r'|'\n') { skip(); };

// Palavaras chaves
PALAVRA_CHAVE:  'algoritmo' | 'fim_algoritmo' | 'declare' | 'constante' |
                'tipo'      | 'literal'       | 'inteiro' | 'real'      | 
                'logico'    | 'verdadeiro'    | 'falso'   | 'registro'  | 
                'fim_registro'  | 'procedimento' | 'fim_procedimento'   |
                'funcao'    | 'fim_funcao'    | 'var'     | 'leia'      | 
                'escreva'   | 'se'  | 'entao' | 'senao'   | 'fim_se'    | 
                'caso'      | 'seja'          | 'fim_caso' | 'para'     | 
                'ate'       | 'faca'          | 'fim_para' | 'enquanto' | 
                'fim_enquanto' | 'retorne'    | 'nao';

// Números inteiros
NUM_INT: ('0'..'9')+;

// Números reais - com '.' como marcador de decimal
NUM_REAL: ('0'..'9')+'.'('0'..'9')+;

// Delimitador
DELIM: ':';

// Operador de atribuição
OP_ATR: '<-';

// Operadores aritméticos
OP_ARI: '+' | '-' | '*' | '/' | '%';

// Operadores relacionais
OP_REL: '=' | '<>' | '>' | '<' | '>=' | '<=';

// Operadores lógicos
OP_LOG: 'e' | 'ou';

// Parênteses
PAR: '(' | ')';

// Colchetes
COL: '[' | ']';

// Identificadores - sequência de caracteres, números e underscore que sempre começa com uma letra - variáveis
IDENT: ('a'..'z' | 'A'..'Z' | '_')('a'..'z'| 'A'..'Z' | '0'..'9' | '_')*;

// Cadeia de qualquer coisas entre aspas - até aspas
CADEIA: '"' ( ESC_SEQ | ~('"' | '\\' | '\n'))* '"';

// Quando não ocorre o fechamento da cadeia
CADEIA_ERRADA: '"' ( ESC_SEQ | ~('"' | '\\' | '\n'))* '\n';

// Escape para as aspas duplas
fragment
ESC_SEQ: '\\"';

// Símbolos, delimitadores, operadores aritméticos, lógicos, relacionais e de atribuição
SIMBOLOS: '&' | '^' | ',' | '.' | '..';

// Qualquer símbolo desconhecido para a linguagem
SIMBOLOS_DESCONHECIDOS: .;






