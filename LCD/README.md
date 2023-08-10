<h1 align="center" color="blue">LCD - Linguagem para escrever cheats e detonados e gerar um código HTML.</h1>
<h2 align="center" color="blue">TRABALHO 6 - CONSTRUÇÃO DE COMPILADORES</h2>
<h3 align="center" color="blue"> Universidade Federal de São Carlos - Prof. Daniel Lucrédio </h2>
<br>
<h3 align="center" color="blue"> Autor:</h2>
<p align="center"> Pedro Morini da Mota - 795414 </p>

## SUMÁRIO :pencil:

[Introdução](#introdução) <br>
[Gramática](#gramática) <br>
[Compilar](#compilar) <br>
[Vídeo](#vídeo)

## INTRODUÇÃO

O trabalho desenvolvido a seguir para a matéria de Compiladores visa a criação de uma linguagem de programação e um compilador para a mesma. A linguagem criada é utilizada para a escrita de detonados de jogos. O compilador, então, interpreta o programa dado em formato txt e interpreta-o, gerando uma página HTML.

## GRAMÁTICA

A gramática da linguagem LCD, está definida no arquivo [LCD.g4](https://github.com/pedromorini/Compiladores/blob/master/LCD/src/main/antlr4/br/ufscar/dc/compiladores/lcd/LCD.g4)

O seguinte exemplo ilustra o uso da linguagem LCD:

```textX
nome: "Nome do Jogo"
capa: "path/to/image/image.jpg"
console: ps1

cheat:
    Aqui se declara o nome do cheat (esse podendo ser um código, truque, ou apenas uma dica), os códigos do cheat se houverem e as instruções do cheat se houverem

fase:
    Aqui se declara o nome da fase 

instrucao:
    Aqui se claras as instruções da fase podendo acessar informações de cheats e de outras fases
fim_instrucao
```
Os valores do código declarado em cheat representm os botões de um controle:

| playstation | 
|----------------------------------|
| R1, L1, R2, L2 |
| cima, baixo, esquerda, direita |
| Q -> quadrado | 
| T -> triangulo | 
| O -> bolinha | 
| X |

## COMPILAR

Para executar o programa, no terminal use o comando:

java -jar Caminho/Do/Compilador/LCD-1.0-SNAPSHOT-jar-with-dependencies Caminho/Da/Entrada/arquivo_entrada.txt Caminho/Da/Saida/arquivo_saida.html

Além disso, alguns casos de testes podem ser usados como exemplo: [casos de teste](https://github.com/pedromorini/Compiladores/tree/master/LCD/casos-de-teste)

## VÍDEO
Disponível em: [link]()
