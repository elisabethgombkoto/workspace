package algUdaten.cbe6228.task2;

public class Main {
	public static void main(String[] args) throws InvalidStringException {
		CoDecompress k = new CoDecompress();
		String strDK = "abbcccccddddeefggg";
		String strK = "abbc5d4eefg3";
		System.out.println("compressed:   "+strDK + " -> "+k.compress(strDK));
		System.out.println("decompressed: "+strK + " -> "+k.decompress(strK));
	}
}
