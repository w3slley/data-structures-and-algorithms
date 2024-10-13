import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();//transforma cada linha (string) em um array contendo Chars
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
        String answ = "";
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                answ+=m[i][j];
            }
                
            answ+="\n";
        }
        System.out.print(answ);
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
    	int count = 0;
        /*//Another way to do it
        for(int i=y-1;i<y+2;i++){
            for(int j=x-1;j<x+2;j++){
                if((i>=0 && i<rows) && (j>=0 && j<cols)){
                    if(i==y && j==x) continue;
                    else count+=m[i][j]=='O'?1:0;
                }
            }
        }*/
    	for(int i=-1;i<2;i++){
            if(x+i>=0 && x+i<cols){
                if(y-1>=0) count+=m[y-1][x+i]=='O'?1:0;//somar celulas de cima
                if(x+i!=x) count+=m[y][x+i]=='O'?1:0; //somar celulas meio excepto celula base
                if(y+1<rows) count+=m[y+1][x+i]=='O'?1:0; //somar celulas de baixo 
            }
        }
    	return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate(int n) {
        for(int k=0;k<n;k++){
            char[][] m2 = new char[rows][cols]; 
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(m[i][j]=='O'){
                        if(countAlive(i,j)<=1 || countAlive(i,j)>=4) m2[i][j]='.';
                        else m2[i][j]='O';       
                    }
                    else{
                        if(countAlive(i,j)==3) m2[i][j]='O';
                        else m2[i][j]='.';
                    }
                }   
            } 
            m = m2; 
        }
    }     
}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);

    	// Ler linhas, colunas e numero de iteracoes
    	int rows = in.nextInt();
    	int cols = in.nextInt();
    	int n = in.nextInt();

    	// Criar objecto para conter o jogo e ler estado inicial
    	Game g = new Game(rows, cols);
    	g.read(in);
    	g.iterate(n);
        g.write();
    }
}