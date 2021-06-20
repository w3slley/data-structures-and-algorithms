public class TestBSTMap {
    public static void main( String [] args) {
	// Criação de um dicionário
	BSTMap <String ,Integer > map = new BSTMap <String,Integer>();
	// Inserindo alguns pares (chave,valor)
	map.put("Life", 42);
	map.put("Zero", 0);
	map.put(" Infinity ", 999);
	// Tamanho e conteúdo
	System.out.println("size = " + map.size());
	System.out.println("Value of \"Life\" = " + map.get("Life"));
	System.out.println("Value of \"Data\" = " + map.get("Data"));
	System.out.println(map.keys());
	// Modificando um valor
	map.put("Life", 22);
	System.out.println("Value of \"Life\" = " + map.get("Life"));
	// Apagando um valor
	map.remove ("Life");
	System.out.println("Value of \"Life\" = " + map.get("Life"));
    }
}
