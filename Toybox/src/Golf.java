class Golf {
    public static void main(String... args) {
        char[][] a = new char[11][11];
        a[0][5] = a[5][0] = a[5][10] = a[10][5] = '*';
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (Math.abs(5 - i) + Math.abs(5 - j) == 4) a[i][j] = '*';
                System.out.print(a[i][j]);
            }
            System.out.print("\n");
        }
    }
}