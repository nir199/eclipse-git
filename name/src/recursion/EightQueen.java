package recursion;

public class EightQueen {
//	static int count = 0;
//	static int[][] chess = new int[8][8];
//	public static void main(String args[]){
//		for(int i=0;i<8;i++){
//			for(int j=0;j<8;j++){
//				chess[i][j]=0;
//			}
//		}
//	}
//	public static void solve(int row,int column,int[] index){
//		int[][] temp = new int[8][8];
//		int i,j;
//		for(i=0;i<8;i++){
//			for(j=0;j<8;j++){
//				temp[i][j]=chess[i][j];
//			}
//		}
//		if(8 == row){
//			System.out.println("第 "+(count+1)+" 种");
//			for(i=0;i<8;i++){
//				for(j=0;j<8;j++){
//					System.out.print(temp[index+i][j]+" ");
//				}
//				System.out.print("\n");
//			}
//			System.out.print("\n");
//			count++;
//		}else {
//			for(j=0;j<column;j++){
//				if(!isDanger(row,j,index)){
//					for(i=0;i<8;i++){
//						temp[index+row][i]=0;
//					}
//					temp[index+row][j]=1;
//					solve(row+1, column, index);
//				}
//			}
//		}
//	}
//	public static boolean isDanger(int row,int column,int index){
//		int i;
//		for(i=0;i<8;i++){
//			if(){
//				return true;
//			}
//		}
//		return false;
//	}
	public static void main(String args[]){
//		EightQueen eightQueens=new EightQueen();
//		eightQueens.putQueen(0);
//		System.out.println("皇后问题一共找到了 "+howMany+"组解。");
		int[][] chess = new int[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				chess[i][j] = 0;
			}
		}
		compute(0, 8, chess);
		System.out.println("总共" + count + "种");
	}
	public static int count;
	public static void compute(int row, int col, int[][] chess){
		int[][] chess2 = new int[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				chess2[i][j] = chess[i][j];
			}
		}
		if(8 == row){
			print(chess2);
		}else{
			for(int i = 0; i < col; i++){
				if(judge(row, i, chess2)){
					for(int j = 0; j < 8; j++){
						chess2[row][j] = 0;
					}
					chess2[row][i] = 1;
					compute(row + 1, col, chess2);
				}
			}
		}
	}
	public static void print(int[][] chess){
		int count1 = count + 1;
		System.out.println("第" + count1 + "种");
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		count++;
	}
	public static boolean judge(int row, int col, int[][] chess){
		for(int i = 0; i < 8; i++){
			if(0 != chess[i][col]){
				return false;
			}
		}
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
			if(0 != chess[i][j]){
				return false;
			}
		}
		for(int i = row, j = col; i < 8 && j < 8; i++, j++){
			if(0 != chess[i][j]){
				return false;
			}
		}
		for(int i = row, j = col; i < 8 && j >= 0; i++, j--){
			if(0 != chess[i][j]){
				return false;
			}
		}
		for(int i = row, j = col; i >= 0 && j < 8; i--, j++){
			if(0 != chess[i][j]){
				return false;
			}
		}
		return true;
	}
	//java递归方法
	private static final boolean AVAILABLE=true;
	private int squares=8,norm=squares-1;
	private int positionInRow[]=new int[squares];
	private boolean[] column=new boolean[squares];
	private boolean[] leftDiagonal=new boolean[2*squares-1];
	private boolean[] rightDiagonal=new boolean[2*squares-1];
	private static int howMany=0;
	public EightQueen(){
		//To complete the initialization work for the column,leftDiagonal,rigthDiagonal.
		for(int i=0;i<squares;i++){
			column[i]=AVAILABLE;
			positionInRow[i]=-1;
		}
		for(int i=0;i<2*squares-1;i++){
			leftDiagonal[i]=AVAILABLE;
			rightDiagonal[i]=AVAILABLE;
		}
	}
	public void printResults(int[] columns){
		int row,col;
		System.out.println("八皇后问题的第 "+howMany+" 种解法");
		System.out.print("八皇后问题的结果为：");
		for(int e:columns){
			System.out.print(e);
		}
		System.out.println("\n具体的图示如下图所示：");
		for(row=0;row<squares;row++){
			for(col=0;col<squares;col++){
				if(col==positionInRow[row]){
					System.out.print("@");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public void putQueen(int row){
		//如果前面已经得到了一个可行解
		for(int i=0;i<squares;i++){
			if(row>squares-1) break;
			if(column[i]==AVAILABLE&&leftDiagonal[row+i]==AVAILABLE
					&&rightDiagonal[row-i+norm]==AVAILABLE){
				positionInRow[row]=i;
				column[i]=!AVAILABLE;
				leftDiagonal[row+i]=!AVAILABLE;
				rightDiagonal[row-i+norm]=!AVAILABLE;
				if(row<squares-1){
					putQueen(row+1);
				}else
				{
					howMany+=1;
					printResults(positionInRow);
				}
				column[i]=AVAILABLE;
				leftDiagonal[row+i]=AVAILABLE;
				rightDiagonal[row-i+norm]=AVAILABLE;
			}
		}
	}

	//java循环方法
	/*
	private static final boolean AVAILABLE = true;
	private int squares = 8, norm = squares - 1;
	private int positionInRow[] = new int[squares];
	private int p=-1;
	private boolean[] rows = new boolean[squares];
	private boolean[] column = new boolean[squares];
	private boolean[] leftDiagonal = new boolean[2 * squares - 1];
	private boolean[] rightDiagonal = new boolean[2 * squares - 1];
	private static int howMany = 0;

	public EightQueen() {
		// To complete the initialization work for the
		// column,leftDiagonal,rigthDiagonal.
		for (int i = 0; i < squares; i++) {
			rows[i] = AVAILABLE;
			column[i] = AVAILABLE;
			positionInRow[i] = -1;
		}
		for (int i = 0; i < 2 * squares - 1; i++) {
			leftDiagonal[i] = AVAILABLE;
			rightDiagonal[i] = AVAILABLE;
		}

	}

	public void printResults(int[] columns) {
		int row, col;
		System.out.println("八皇后问题的第 " + howMany + " 种解法");
		System.out.print("八皇后问题的结果为：");
		for (int e : columns) {
			System.out.print(e);
		}
		System.out.println("\n具体的图示如下图所示：");
		for (row = 0; row < squares; row++) {
			for (col = 0; col < squares; col++) {
				if (col == positionInRow[row]) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void putQueen() {
		int row=0, col;
		while (true) 
		{
			for (col = p + 1; col < squares; col++){
				if(rows[row]==AVAILABLE&&column[col]==AVAILABLE
						&&leftDiagonal[row+col]==AVAILABLE
						&&rightDiagonal[row-col+norm]==AVAILABLE){
					break;
				}
			}
			//在当前的行里面找到了可以放置皇后的位置
			if(col<squares){
				rows[row]=!AVAILABLE;
				column[col]=!AVAILABLE;
				leftDiagonal[row+col]=!AVAILABLE;
				rightDiagonal[row-col+norm]=!AVAILABLE;
				positionInRow[row]=col;
				p=col;
			}else{//如果当前行没办反放置皇后了，那么回溯
				if(row>0){//到前一行
					row--;
					p=positionInRow[row];
					rows[row]=AVAILABLE;
					column[p]=AVAILABLE;
					leftDiagonal[row+p]=AVAILABLE;
					rightDiagonal[row-p+norm]=AVAILABLE;
					positionInRow[row]=-1;
					continue;
				}else{
					break;
				}
			}
			if(row==squares-1){
				howMany+=1;
				printResults(positionInRow);
				p=positionInRow[row];
				rows[row]=AVAILABLE;
				column[p]=AVAILABLE;
				leftDiagonal[row+p]=AVAILABLE;
				rightDiagonal[row-p+norm]=AVAILABLE;
				positionInRow[row]=-1;
				continue;
			}else{
				row++;
				p=-1;
				continue;
			}
		}
	}
	public static void main(String args[])
	{
		EightQueen eightQueens=new EightQueen();
		eightQueens.putQueen();
		System.out.println("皇后问题一共有"+howMany+"种解法");
	}
	*/
}
