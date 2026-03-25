import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[9][9];
	static boolean[][] rowNums, colNums, blockNums;
	static List<Integer> emptyRowList, emptyColumnList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		rowNums = new boolean[9][10];
		colNums = new boolean[9][10];
		blockNums = new boolean[9][10];
		emptyRowList = new ArrayList<>();
		emptyColumnList = new ArrayList<>();
		for(int r=0; r<9; r++) {
			String temp = br.readLine();
			for(int c=0; c<9; c++) {
				int num = temp.charAt(c) - '0';
				board[r][c] = num;
				if(num == 0) {
					emptyRowList.add(r);
					emptyColumnList.add(c);
				} else {
					rowNums[r][num] = true;
					colNums[c][num] = true;
					blockNums[getBlock(r, c)][num] = true;
				}
			}
		}
		fill(0);
		bw.write(sb.toString());
		bw.flush();
	}
	public static void print(int[][] arr) {
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				sb.append(board[r][c]);
			}
			sb.append("\n");
		}
	}
	public static void fill(int index) {
		if(sb.length() > 0) {
			return;
		}
		if(index == emptyRowList.size()) {
			print(board);
			return;
		}
		int r = emptyRowList.get(index);
		int c = emptyColumnList.get(index);
		for(int i=1; i<=9; i++) {
			if(!rowNums[r][i] && !colNums[c][i] && !blockNums[getBlock(r, c)][i]) {
				board[r][c] = i;
				rowNums[r][i] = true;
				colNums[c][i] = true;
				blockNums[getBlock(r,c)][i] = true;
				fill(index+1);
				board[r][c] = 0;
				rowNums[r][i] = false;
				colNums[c][i] = false;
				blockNums[getBlock(r,c)][i] = false;
			}
		}
	}
	public static int getBlock(int r, int c) {
		int[][] blocks = {{0,1,2},{3,4,5},{6,7,8}};
		return blocks[r/3][c/3];
	}
}