package leetcode;

class LeetCode289 {

    public static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
    public static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] res = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int count=0;
                for (int k=0; k<8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (check(nx, ny, n, m)) {
                        if (board[nx][ny] == 1) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    res[i][j] = board[i][j] == 1? 1:0;
                    continue;
                }
                if (count > 3) {
                    res[i][j] = 0;
                }

                if (count == 3) {
                    res[i][j] = 1;
                }

                if (count < 2) {
                    res[i][j] = 0;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] = res[i][j];
            }
        }

    }

    public static boolean check(int x, int y, int n, int m) {
        if (0<=x && x <n && 0<=y && y<m) {
            return true;
        }
        return false;
    }
}
